package com.gxzy.bigdata.einfo.service;

import com.gxzy.bigdata.einfo.vo.EmpMachInfo;

public interface EmpNewService {


    EmpMachInfo addEMI();//增

    int delEMI(int EMid);//删

    EmpMachInfo FindEMI();//查


}
