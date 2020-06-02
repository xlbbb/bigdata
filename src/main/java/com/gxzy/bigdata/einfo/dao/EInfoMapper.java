package com.gxzy.bigdata.einfo.dao;

import com.gxzy.bigdata.einfo.vo.Brand;
import com.gxzy.bigdata.einfo.vo.MachInfo;
import com.gxzy.bigdata.mes.vo.OrderOutput;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/8 14:01
 */
public interface EInfoMapper {

    List<MachInfo> findMachInfoAll();

    List<Brand> findBrandAll();

    int saveMesDBPrmPackworkorderoutput(List<OrderOutput> orderOutputs);
}
