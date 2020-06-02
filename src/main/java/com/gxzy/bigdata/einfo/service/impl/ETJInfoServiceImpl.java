package com.gxzy.bigdata.einfo.service.impl;

import com.gxzy.bigdata.core.page.MybatisPageHelper;
import com.gxzy.bigdata.core.page.PageRequest;
import com.gxzy.bigdata.core.page.PageResult;
import com.gxzy.bigdata.einfo.dao.ETJInfoMapper;
import com.gxzy.bigdata.einfo.service.ETJInfoService;
import com.gxzy.bigdata.einfo.vo.EmpTJInfo;
import com.gxzy.bigdata.einfo.vo.TingJiR;
import com.gxzy.bigdata.einfo.vo.TingJiTime;
import com.gxzy.bigdata.mes.vo.OrderOutput;
import com.gxzy.bigdata.user.model.SysUser;
import com.gxzy.bigdata.user.service.SysUserService;
import com.gxzy.bigdata.vo.CustomOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/9 14:21
 */
@Service
public class ETJInfoServiceImpl implements ETJInfoService {

    @Autowired
    ETJInfoMapper etjInfoMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public int save(EmpTJInfo empTJInfo) {
        return etjInfoMapper.save(empTJInfo);
    }

    @Override
    public List<CustomOptions> findZRWXName() {
        CustomOptions customOptions = new CustomOptions();
        List<CustomOptions> customOptions1 = etjInfoMapper.findZRWXName();
        customOptions1.add(0, customOptions);
        return customOptions1;
    }

    @Override
    public int delete(EmpTJInfo empTJInfo) {
        etjInfoMapper.deleteEmpTJBrand(empTJInfo.getId());
        etjInfoMapper.deleteTingJiR(empTJInfo.getId());
        etjInfoMapper.deleteTingJiTime(empTJInfo.getId());
        return etjInfoMapper.delete(empTJInfo.getId());
    }

    @Override
    public int delete(List<EmpTJInfo> records) {
        return 0;
    }

    @Override
    public EmpTJInfo findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {

        Object banBie = pageRequest.getParam("banBie");
        Object machineType = pageRequest.getParam("machineType");
        Object sTime = pageRequest.getParam("sTime");
        Object eTime = pageRequest.getParam("eTime");
        Object zRWeiXiu = pageRequest.getParam("zRWeiXiu");
        PageResult pageResult = MybatisPageHelper.findPage(pageRequest, etjInfoMapper, "findPageSearch", banBie, sTime, eTime, zRWeiXiu, machineType);
        return pageResult;
    }

    @Override
    public int saveEmpTJBrand(String tJID, String brandID) {
        return etjInfoMapper.saveEmpTJBrand(tJID, brandID);
    }

    @Override
    public int saveTingJiR(TingJiR tingJiR) {
        return etjInfoMapper.saveTingJiR(tingJiR);
    }

    @Override
    public int saveTingJiTime(TingJiTime tingJiTime) {
        return etjInfoMapper.saveTingJiTime(tingJiTime);
    }

    @Override
    public int update(EmpTJInfo empTJInfo) {
        return etjInfoMapper.update(empTJInfo);
    }

    @Override
    public int deleteEmpTJBrand(String empTJInfoID) {
        return etjInfoMapper.deleteEmpTJBrand(empTJInfoID);
    }

    @Override
    public int deleteTingJiR(String empTJInfoID) {
        return etjInfoMapper.deleteTingJiR(empTJInfoID);
    }

    @Override
    public int deleteTingJiTime(String empTJInfoID) {
        return etjInfoMapper.deleteTingJiTime(empTJInfoID);
    }

    @Override
    public EmpTJInfo findHandleAdd(String user, String machineNo, String operflagname) {
        // 用户信息
        SysUser sysUser = sysUserService.findByName(user);
        String machineTypeName = "";
        EmpTJInfo empTJInfo = new EmpTJInfo();
        if (sysUser.getRoleNames().contains("卷接")) {
            empTJInfo.setMachineType("JJ");
            machineTypeName = "卷接";
        } else {
            empTJInfo.setMachineType("BZ");
            machineTypeName = "包装";
        }
        empTJInfo.setMachineNo(machineNo);
        if (machineNo.length() == 1) {
            machineNo = "0" + machineNo;
        }
        OrderOutput orderOutput = etjInfoMapper.findPackWorkOrderOutput(machineNo, operflagname, machineTypeName);
        OrderOutput orderOutput1 = etjInfoMapper.findPackWorkOrderOutput(machineNo, "剔除量", machineTypeName);
        empTJInfo.setBanBie(banbieFommat(orderOutput.getTeamname()));
        empTJInfo.setBanCi(banCiFommat(orderOutput.getShiftname()));
        empTJInfo.setBrands(etjInfoMapper.addSTJBrands(orderOutput.getMaterialname()));
        empTJInfo.setJiZhang(orderOutput1.getOperateusername());
        empTJInfo.setzRWeiXiu(sysUser.getNickName());
        empTJInfo.setTime(orderOutput.getBusinessdate());
        empTJInfo.setChanLiang(Double.parseDouble(orderOutput.getQuantity()));
        if (!orderOutput1.getQuantity().isEmpty()) {
            empTJInfo.setFeiPL(Double.parseDouble(orderOutput1.getQuantity()) / (10000 * Double.parseDouble(orderOutput.getQuantity())));
        }
        return empTJInfo;
    }

    public String banbieFommat(String banbie) {
        String banbieFommat = "A";
        if (banbie.contains("甲班")) {
            banbieFommat = "A";
        } else if (banbie.contains("乙班")) {
            banbieFommat = "B";
        } else if (banbie.contains("丙班")) {
            banbieFommat = "C";
        } else if (banbie.contains("丁班")) {
            banbieFommat = "D";
        }
        return banbieFommat;
    }

    public String banCiFommat(String banci) {
        String banCiFommat = "B";
        if (banci.contains("白")) {
            banCiFommat = "B";
        } else if (banci.contains("中")) {
            banCiFommat = "Z";
        } else if (banci.contains("零")) {
            banCiFommat = "L";
        }
        return banCiFommat;
    }

}
