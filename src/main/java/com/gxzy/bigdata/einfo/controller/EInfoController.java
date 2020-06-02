package com.gxzy.bigdata.einfo.controller;



import com.gxzy.bigdata.core.http.HttpResult;
import com.gxzy.bigdata.einfo.service.EInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 设备信息控制器
 * Created by wwquan on 2020/5/8 14:20
 */
@RestController
@RequestMapping("eInfo")
public class EInfoController {

    private static final Logger logger = LoggerFactory.getLogger(EInfoController.class);

    @Autowired
    private EInfoService eInfoService;


    @PreAuthorize("hasAuthority('sys:einfo:view')")
    @GetMapping(value = "/findMachInfoAll")
    public HttpResult findMachInfoAll() {
        try {
            return HttpResult.ok(eInfoService.findMachInfoAll());
        } catch (Exception e) {
            return HttpResult.error(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('sys:einfo:view')")
    @GetMapping(value = "/findBrandAll")
    public HttpResult findBrandAll() {
        try {
            return HttpResult.ok(eInfoService.findBrandAll());
        } catch (Exception e) {
            return HttpResult.error(e.getMessage());
        }
    }
}
