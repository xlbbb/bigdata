package com.gxzy.bigdata.core.exception;

import com.alibaba.fastjson.JSON;
import com.gxzy.bigdata.core.http.HttpResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description:
 * Created by wwquan on 2020/5/18 9:38
 */
public class ExceptionIntercept {
    public static final String PLAT_ERROR = "PLAT_ERROR";
    // Logger和LogManager导入的是org.apache.logging包
    private static final Logger logger = LogManager.getLogger(ExceptionIntercept.class);

    //捕捉什么类型的异常进行处理，可自定义异常
    @ExceptionHandler(Exception.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    //返回的状态码
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)     //服务内部错误
    public HttpResult handler(Exception ex) {
        //返回错误数据包
        HttpResult pack = new HttpResult();
        pack.setCode(com.gxzy.bigdata.core.http.HttpStatus.SC_INTERNAL_SERVER_ERROR);
        pack.setMsg(ex.getMessage());
        //同时记录错误日志
        logger.error("Controller全局错误捕获类==>" + JSON.toJSONString(pack));
        return pack;
    }
}
