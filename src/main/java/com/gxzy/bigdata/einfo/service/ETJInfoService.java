package com.gxzy.bigdata.einfo.service;

import com.gxzy.bigdata.core.service.CurdService;
import com.gxzy.bigdata.einfo.vo.EmpTJInfo;
import com.gxzy.bigdata.einfo.vo.TingJiR;
import com.gxzy.bigdata.einfo.vo.TingJiTime;
import com.gxzy.bigdata.vo.CustomOptions;

import java.util.List;


/**
 * Description: 设备停机信息
 * Created by wwquan on 2020/5/9 14:20
 */
public interface ETJInfoService  extends CurdService<EmpTJInfo> {
    /*
     *  存储所有设备信息
     */
    int save(EmpTJInfo empTJInfo);

    /*
     *  查询责任维修列表
     */
    List<CustomOptions> findZRWXName();

    /*
     *  存储设备关联牌号
     */
    int saveEmpTJBrand(String tJID, String brandID);

    /*
     *  存储停机数量的主要原因
     */
    int saveTingJiR(TingJiR tingJiR);

    /*
     *  存储停机修机时间
     */
    int saveTingJiTime(TingJiTime tingJiTime);

    /*
     *  更新设备信息
     */
    int update(EmpTJInfo empTJInfo);

    /*
     *  删除设备停机关联牌号信息
     */
    int deleteEmpTJBrand(String empTJInfoID);

    /*
     *  删除设备停机关联停机信息
     */
    int deleteTingJiR(String empTJInfoID);

    /*
     *  删除设备停机关联停机时长信息
     */
    int deleteTingJiTime(String empTJInfoID);

    /*
     *  新增预填充信息
     */
    EmpTJInfo findHandleAdd(String user, String machineNo, String operflagname);

}
