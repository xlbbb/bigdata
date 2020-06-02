package com.gxzy.bigdata.einfo.controller;

/**
 * Description:
 * Created by wwquan on 2020/4/30 22:30
 */

import com.gxzy.bigdata.core.http.HttpResult;
import com.gxzy.bigdata.core.page.PageRequest;
import com.gxzy.bigdata.einfo.service.ETJInfoService;
import com.gxzy.bigdata.einfo.vo.EmpInfo;
import com.gxzy.bigdata.einfo.vo.EmpTJInfo;
import com.gxzy.bigdata.einfo.vo.TingJiR;
import com.gxzy.bigdata.einfo.vo.TingJiTime;
import com.gxzy.bigdata.redis.RedisUtils;
import com.gxzy.bigdata.user.model.SysUser;
import com.gxzy.bigdata.user.service.SysUserService;
import com.gxzy.bigdata.vo.CustomOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * 停机信息控制器
 */
@RestController
@RequestMapping("eInfoTJ")
public class EInfoTJController {

    private static final Logger logger = LoggerFactory.getLogger(EInfoTJController.class);

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ETJInfoService etjInfoService;


    @PreAuthorize("hasAuthority('sys:einfo:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
            return HttpResult.ok(etjInfoService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:einfo:view')")
    @GetMapping(value = "/findHandleAdd")
    public HttpResult findHandleAdd(@RequestParam String user, @RequestParam String machineNo) {
        return HttpResult.ok(etjInfoService.findHandleAdd(user, machineNo, "核对量"));
    }

    @PreAuthorize("hasAuthority('sys:einfo:view')")
    @GetMapping(value = "/getJZName")
    public HttpResult getJZName(@RequestParam String staffCode) {
            List<SysUser> sysUsers = sysUserService.findAllUser();
            List<EmpInfo> jZNames = sysUsers.stream().map(temp -> {
                EmpInfo obj = new EmpInfo();
                obj.setEmpCode(temp.getName());
                obj.setEmpName(temp.getNickName());
                return obj;
            }).collect(Collectors.toList());
            return HttpResult.ok(jZNames);
    }

    @PreAuthorize("hasAuthority('sys:einfo:view')")
    @GetMapping(value = "/findZRWXName")
    public HttpResult findZRWXName() {
            return HttpResult.ok(etjInfoService.findZRWXName());
    }

    @PreAuthorize("hasAuthority('sys:einfo:add') AND hasAuthority('sys:einfo:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody EmpTJInfo empTJInfo) {
            logger.info(empTJInfo.toString());
            //新增
            if (empTJInfo.getId().isEmpty()) {
                String uuid = UUID.randomUUID().toString();
                uuid = uuid.replaceAll("-", "");
                empTJInfo.setId(uuid);
                int i = etjInfoService.save(empTJInfo);
                saveEmpTJInfo(empTJInfo);
            } else {
                //更新
                etjInfoService.update(empTJInfo);
                etjInfoService.deleteEmpTJBrand(empTJInfo.getId());
                etjInfoService.deleteTingJiR(empTJInfo.getId());
                etjInfoService.deleteTingJiTime(empTJInfo.getId());
                saveEmpTJInfo(empTJInfo);
            }
        return HttpResult.ok();
    }

    public void saveEmpTJInfo(EmpTJInfo empTJInfo) {
        String uuid = empTJInfo.getId();
        for (String brandID : empTJInfo.getBrands()) {
            int d = etjInfoService.saveEmpTJBrand(uuid, brandID);
        }
        if (empTJInfo.getTingJiRes() != null) {
            for (TingJiR tingJiR : empTJInfo.getTingJiRes()) {
                tingJiR.setId(uuid);
                int r = etjInfoService.saveTingJiR(tingJiR);
            }
        }
        if (empTJInfo.getTingJiTimes() != null) {
            for (TingJiTime tingJiTime : empTJInfo.getTingJiTimes()) {
                tingJiTime.setId(uuid);
                int t = etjInfoService.saveTingJiTime(tingJiTime);
            }
        }
    }

}
