package com.gxzy.bigdata.mes.mapper;

import com.gxzy.bigdata.mes.vo.OrderOutput;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/20 17:36
 */
public interface MesMapper {
    List<OrderOutput> findOrderOutputAll(@Param("businessdate") String businessdate);
}
