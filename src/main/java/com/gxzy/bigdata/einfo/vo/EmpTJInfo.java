package com.gxzy.bigdata.einfo.vo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: 设备停机新增
 * Created by wwquan on 2020/5/9 10:35
 */
public class EmpTJInfo {
    private String id = "";
    private String jiZhang = "";//机长
    private String zRWeiXiu = "";//责任维修
    private String machineNo = "";//机台号
    private String machineType = "";//机台类型（卷接JJ，包装BZ）
    private String banCi = "";//班次（白B，中Z，零L）
    private String banBie = "";//班别（甲A，乙B,丙C,丁D）
    private Date time;//时间日期
    private double chanLiang = 0;//产量
    private int tingJiNUM = 0;//停机次数
    private double feiPL = 0;//废品率（卷接特有）
    private List<String> brands = new ArrayList<>();//牌号
    private List<TingJiR> tingJiRes = new ArrayList<>();//停机次数较多的原因
    private List<TingJiTime> tingJiTimes = new ArrayList<>();//停机时间较长的原因（一般是修机、等料、等下游机）

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJiZhang() {
        return jiZhang;
    }

    public void setJiZhang(String jiZhang) {
        this.jiZhang = jiZhang;
    }

    public String getzRWeiXiu() {
        return zRWeiXiu;
    }

    public void setzRWeiXiu(String zRWeiXiu) {
        this.zRWeiXiu = zRWeiXiu;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getBanCi() {
        return banCi;
    }

    public void setBanCi(String banCi) {
        this.banCi = banCi;
    }

    public String getBanBie() {
        return banBie;
    }

    public void setBanBie(String banBie) {
        this.banBie = banBie;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getChanLiang() {
        return chanLiang;
    }

    public void setChanLiang(double chanLiang) {
        this.chanLiang = chanLiang;
    }

    public int getTingJiNUM() {
        return tingJiNUM;
    }

    public void setTingJiNUM(int tingJiNUM) {
        this.tingJiNUM = tingJiNUM;
    }

    public double getFeiPL() {
        return feiPL;
    }

    public void setFeiPL(double feiPL) {
        this.feiPL = feiPL;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<TingJiR> getTingJiRes() {
        return tingJiRes;
    }

    public void setTingJiRes(List<TingJiR> tingJiRes) {
        this.tingJiRes = tingJiRes;
    }

    public List<TingJiTime> getTingJiTimes() {
        return tingJiTimes;
    }

    public void setTingJiTimes(List<TingJiTime> tingJiTimes) {
        this.tingJiTimes = tingJiTimes;
    }

    @Override
    public String toString() {
        return "EmpTJInfo{" +
                "id='" + id + '\'' +
                ", jiZhang='" + jiZhang + '\'' +
                ", zRWeiXiu='" + zRWeiXiu + '\'' +
                ", machineNo='" + machineNo + '\'' +
                ", machineType='" + machineType + '\'' +
                ", banCi='" + banCi + '\'' +
                ", banBie='" + banBie + '\'' +
                ", time=" + time +
                ", chanLiang=" + chanLiang +
                ", tingJiNUM=" + tingJiNUM +
                ", feiPL='" + feiPL + '\'' +
                ", brands=" + brands +
                ", tingJiRes=" + tingJiRes +
                ", tingJiTimes=" + tingJiTimes +
                '}';
    }
}
