package com.gxzy.bigdata.einfo.dao;

import com.gxzy.bigdata.einfo.vo.EmpMachInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 对于emp_mach_info表的操作实现的第一个接口
 *
 *
 */

public interface ElnfoNewMapper {

    EmpMachInfo addEMI();//增

    int delEMI(@Param("EMid")int EMid);//删

    EmpMachInfo FindEMI();//查








}
