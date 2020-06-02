package com.gxzy.bigdata.einfo.service.impl;

import com.gxzy.bigdata.einfo.dao.EInfoMapper;
import com.gxzy.bigdata.einfo.service.EInfoService;
import com.gxzy.bigdata.einfo.vo.Brand;
import com.gxzy.bigdata.einfo.vo.MachInfo;
import com.gxzy.bigdata.mes.vo.OrderOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/8 13:10
 */
@Service
public class EInfoServiceImpl implements EInfoService {

    private static final String Mach_Info_Name = "machInfo";
    private static final String Bran_Name = "BranName";

    @Autowired
    private EInfoMapper eInfoMapper;

    @Override
    @Cacheable(value = Mach_Info_Name, key = "'machs_all'")
    public List<MachInfo> findMachInfoAll() {
        return eInfoMapper.findMachInfoAll();
    }

    @Override
    @Cacheable(value = Bran_Name, key = "'machs_all'")
    public List<Brand> findBrandAll() {
        return eInfoMapper.findBrandAll();
    }

    @Override
    public int saveMesDBPrmPackworkorderoutput(List<OrderOutput> orderOutputs) {
        return eInfoMapper.saveMesDBPrmPackworkorderoutput(orderOutputs);
    }
}
