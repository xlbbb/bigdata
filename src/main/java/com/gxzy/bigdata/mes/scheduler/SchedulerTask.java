package com.gxzy.bigdata.mes.scheduler;

import com.alibaba.fastjson.JSON;
import com.gxzy.bigdata.einfo.service.EInfoService;
import com.gxzy.bigdata.mes.service.MesService;
import com.gxzy.bigdata.mes.vo.OrderOutput;
import com.gxzy.bigdata.redis.RedisUtils;
import com.gxzy.bigdata.user.model.SysDict;
import com.gxzy.bigdata.user.service.SysDictService;
import com.gxzy.bigdata.utils.DateTimeUtils;
import net.sf.jsqlparser.expression.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Created by wwquan on 2020/5/20 14:39
 */
@Component
public class SchedulerTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);
//    private static final String MES_DB_PRM_PACKWORKORDEROUTPUT = "MES_DB:PRM:PACKWORKORDEROUTPUT";

    @Autowired
    private MesService mesService;
    @Autowired
    private DateTimeUtils dateTimeUtils;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private EInfoService eInfoService;

//      @Scheduled(cron = "*/20 * * * * ?")
//    @Scheduled(cron = "0 0/5 * * * ?")
//    @Scheduled(cron = "0 0/5 0,1,2,3,7,8,9,10,16,17,18,19 * * ?")
    public void saveMesDBPrmPackworkorderoutput() {
        logger.info("============================开始执行定时任务saveMesDBPrmPackworkorderoutput=======================");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        List<OrderOutput> orderOutputs = mesService.findOrderOutputAll(calendarFommat(calendar, "-"));
        if (orderOutputs.size() > 0) {
            eInfoService.saveMesDBPrmPackworkorderoutput(orderOutputs);
        }
        logger.info("---------------------------saveMesDBPrmPackworkorderoutput----------END-------------------");
    }


    private String calendarFommat(Calendar cl, String symbol) {
        int year = cl.get(Calendar.YEAR);
        int month = cl.get(Calendar.MONTH) + 1;
        int day = cl.get(Calendar.DATE);
        return year + symbol + month + symbol + day;
    }
}
