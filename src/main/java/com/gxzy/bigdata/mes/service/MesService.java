package com.gxzy.bigdata.mes.service;

import com.gxzy.bigdata.mes.vo.OrderOutput;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/20 17:34
 */
public interface MesService {

    List<OrderOutput> findOrderOutputAll(String businessdate);
}
