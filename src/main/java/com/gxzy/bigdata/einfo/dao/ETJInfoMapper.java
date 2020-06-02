package com.gxzy.bigdata.einfo.dao;

import com.gxzy.bigdata.einfo.vo.EmpTJInfo;
import com.gxzy.bigdata.einfo.vo.TingJiR;
import com.gxzy.bigdata.einfo.vo.TingJiTime;
import com.gxzy.bigdata.mes.vo.OrderOutput;
import com.gxzy.bigdata.vo.CustomOptions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 * Created by wwquan on 2020/5/9 14:24
 */
public interface ETJInfoMapper {

    List<EmpTJInfo> findPage();

    List<EmpTJInfo> findPageSearch(@Param("banBie") String banBie, @Param("sTime") String sTime, @Param("eTime") String eTime, @Param("zRWeiXiu") String zRWeiXiu, @Param("machineType") String machineType);

    int save(EmpTJInfo empTJInfo);

    List<CustomOptions> findZRWXName();

    int saveEmpTJBrand(@Param("tJID") String tJID, @Param("brandID") String brandID);

    int saveTingJiR(TingJiR tingJiR);

    int saveTingJiTime(TingJiTime tingJiTime);

    OrderOutput findPackWorkOrderOutput(@Param("processunitname") String processunitname, @Param("operflagname") String operflagname, @Param("productsegmentname") String productsegmentname);

    List<String> addSTJBrands(@Param("brandName") String brandName);

    int update(EmpTJInfo empTJInfo);

    int delete(@Param("empTJInfoID") String empTJInfoID);

    int deleteEmpTJBrand(@Param("empTJInfoID") String empTJInfoID);

    int deleteTingJiR(@Param("empTJInfoID") String empTJInfoID);

    int deleteTingJiTime(@Param("empTJInfoID") String empTJInfoID);
}
