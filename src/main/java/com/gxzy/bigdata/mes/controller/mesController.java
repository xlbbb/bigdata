package com.gxzy.bigdata.mes.controller;

import com.gxzy.bigdata.mes.service.MesService;
import com.gxzy.bigdata.mes.vo.OrderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/20 14:32
 */
@RestController
public class mesController {
    private static final Logger logger = LoggerFactory.getLogger(mesController.class);

    @Autowired
    MesService mesService;

    @GetMapping(value = "/findOrderOutputAll")
    public List<OrderOutput> findOrderOutputAll() {
        List<OrderOutput> orderOutputs =  mesService.findOrderOutputAll("2020/5/18");
        return orderOutputs;
    }
}
