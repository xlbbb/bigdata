package com.gxzy.bigdata.mes.vo;

import java.util.Date;

/**
 * Description: 卷包工单产量，对应mes表PRM.PACKWORKORDEROUTPUT
 * Created by wwquan on 2020/5/20 17:30
 */
public class OrderOutput {
    private String id;//主键
    private String shiftid;//班次Id
    private String shiftname;//班次名称
    private String teamid;//班组Id
    private String teamname;//班组名称
    private String materialid;//物料Id
    private String materialname;//物料名称
    private String measureid;//单位Id
    private String measurename;//单位名称
    private Date operatetime;//操作时间
    private String operateuserid;//操作人Id
    private String operateusername;//操作人名称
    private String quantity = "";//数量
    private String operflagid;//操作类型
    private String operflagname;//操作类型名称
    private int isdeleted;//是否被删除
    private int islocked;//是否锁定
    private Date businessdate;//业务时间
    private String remark;//备注
    private String stateid;//状态Id
    private String statename;//状态名称
    private String typeid;//数据类型Id，如掺配、投料等
    private String typename;//数据类型名称，如掺配、投料等
    private int isreported;//是否已生成上报记录
    private String workorderid;//工单Id
    private String workordercode;//工单编码
    private String processunitid;//加工单元，如工艺段、机台
    private String processunitname;//加工单元名称，如工艺段、机台
    private String productsegmentid;//产品段Id
    private String productsegmentname;//产品段名称
    private String workorderexecuteresultid;//工单执行记录

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShiftid() {
        return shiftid;
    }

    public void setShiftid(String shiftid) {
        this.shiftid = shiftid;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getMaterialid() {
        return materialid;
    }

    public void setMaterialid(String materialid) {
        this.materialid = materialid;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getMeasureid() {
        return measureid;
    }

    public void setMeasureid(String measureid) {
        this.measureid = measureid;
    }

    public String getMeasurename() {
        return measurename;
    }

    public void setMeasurename(String measurename) {
        this.measurename = measurename;
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getOperateuserid() {
        return operateuserid;
    }

    public void setOperateuserid(String operateuserid) {
        this.operateuserid = operateuserid;
    }

    public String getOperateusername() {
        return operateusername;
    }

    public void setOperateusername(String operateusername) {
        this.operateusername = operateusername;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOperflagid() {
        return operflagid;
    }

    public void setOperflagid(String operflagid) {
        this.operflagid = operflagid;
    }

    public String getOperflagname() {
        return operflagname;
    }

    public void setOperflagname(String operflagname) {
        this.operflagname = operflagname;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }

    public int getIslocked() {
        return islocked;
    }

    public void setIslocked(int islocked) {
        this.islocked = islocked;
    }

    public Date getBusinessdate() {
        return businessdate;
    }

    public void setBusinessdate(Date businessdate) {
        this.businessdate = businessdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateid(String stateid) {
        this.stateid = stateid;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getIsreported() {
        return isreported;
    }

    public void setIsreported(int isreported) {
        this.isreported = isreported;
    }

    public String getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(String workorderid) {
        this.workorderid = workorderid;
    }

    public String getWorkordercode() {
        return workordercode;
    }

    public void setWorkordercode(String workordercode) {
        this.workordercode = workordercode;
    }

    public String getProcessunitid() {
        return processunitid;
    }

    public void setProcessunitid(String processunitid) {
        this.processunitid = processunitid;
    }

    public String getProcessunitname() {
        return processunitname;
    }

    public void setProcessunitname(String processunitname) {
        this.processunitname = processunitname;
    }

    public String getProductsegmentid() {
        return productsegmentid;
    }

    public void setProductsegmentid(String productsegmentid) {
        this.productsegmentid = productsegmentid;
    }

    public String getProductsegmentname() {
        return productsegmentname;
    }

    public void setProductsegmentname(String productsegmentname) {
        this.productsegmentname = productsegmentname;
    }

    public String getWorkorderexecuteresultid() {
        return workorderexecuteresultid;
    }

    public void setWorkorderexecuteresultid(String workorderexecuteresultid) {
        this.workorderexecuteresultid = workorderexecuteresultid;
    }

    @Override
    public String toString() {
        return "OrderOutput{" +
                "id='" + id + '\'' +
                ", shiftid='" + shiftid + '\'' +
                ", shiftname='" + shiftname + '\'' +
                ", teamid='" + teamid + '\'' +
                ", teamname='" + teamname + '\'' +
                ", materialid='" + materialid + '\'' +
                ", materialname='" + materialname + '\'' +
                ", measureid='" + measureid + '\'' +
                ", measurename='" + measurename + '\'' +
                ", operatetime='" + operatetime + '\'' +
                ", operateuserid='" + operateuserid + '\'' +
                ", operateusername='" + operateusername + '\'' +
                ", quantity='" + quantity + '\'' +
                ", operflagid='" + operflagid + '\'' +
                ", operflagname='" + operflagname + '\'' +
                ", isdeleted='" + isdeleted + '\'' +
                ", islocked='" + islocked + '\'' +
                ", businessdate='" + businessdate + '\'' +
                ", remark='" + remark + '\'' +
                ", stateid='" + stateid + '\'' +
                ", statename='" + statename + '\'' +
                ", typeid='" + typeid + '\'' +
                ", typename='" + typename + '\'' +
                ", isreported='" + isreported + '\'' +
                ", workorderid='" + workorderid + '\'' +
                ", workordercode='" + workordercode + '\'' +
                ", processunitid='" + processunitid + '\'' +
                ", processunitname='" + processunitname + '\'' +
                ", productsegmentid='" + productsegmentid + '\'' +
                ", productsegmentname='" + productsegmentname + '\'' +
                ", workorderexecuteresultid='" + workorderexecuteresultid + '\'' +
                '}';
    }
}
