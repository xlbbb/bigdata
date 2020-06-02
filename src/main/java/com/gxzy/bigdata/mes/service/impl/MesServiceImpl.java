package com.gxzy.bigdata.mes.service.impl;

import com.gxzy.bigdata.mes.mapper.MesMapper;
import com.gxzy.bigdata.mes.service.MesService;
import com.gxzy.bigdata.mes.vo.OrderOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/20 17:35
 */
@Service
public class MesServiceImpl implements MesService {

    @Autowired
    MesMapper mesMapper;

    @Override
    public List<OrderOutput> findOrderOutputAll(String businessdate) {
        return mesMapper.findOrderOutputAll(businessdate);
    }
}
