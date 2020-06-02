package com.gxzy.bigdata.einfo.service;

import com.gxzy.bigdata.einfo.vo.Brand;
import com.gxzy.bigdata.einfo.vo.MachInfo;
import com.gxzy.bigdata.mes.vo.OrderOutput;

import java.util.List;

/**
 * Description: 设备信息
 * Created by wwquan on 2020/5/8 13:09
 */
public interface EInfoService {

    /*
     *  查找所有设备信息
     */
    List<MachInfo> findMachInfoAll();

    /*
     *  查找所有牌号信息
     */
    List<Brand> findBrandAll();

    /*
     *  保存每日工单确认信息
     */
    int saveMesDBPrmPackworkorderoutput(List<OrderOutput> orderOutputs);
}
