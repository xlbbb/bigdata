package com.gxzy.bigdata.einfo.service.impl;

        import com.gxzy.bigdata.einfo.dao.ElnfoNewMapper;
        import com.gxzy.bigdata.einfo.service.EmpNewService;
        import com.gxzy.bigdata.einfo.vo.EmpMachInfo;

        import com.gxzy.bigdata.einfo.vo.EmpMachInfo;
        import org.omg.Messaging.SYNC_WITH_TRANSPORT;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;


@Service
public class EmpNewServiceImpl  implements EmpNewService {

    @Autowired
    private ElnfoNewMapper elnfoNewMapper;

    @Override
    public EmpMachInfo addEMI(){ return elnfoNewMapper.addEMI();

    };//增
    @Override
    public int delEMI(int EMid){  return elnfoNewMapper.delEMI(EMid);

    };//删
    @Override
    public EmpMachInfo FindEMI(){

        EmpMachInfo emp = new EmpMachInfo();
               emp = elnfoNewMapper.FindEMI();
        System.out.println(emp);
        return elnfoNewMapper.FindEMI();

    };//查





}
