package com.gxzy.bigdata.einfo.vo;

/**
 * Description: 设备信息
 * Created by wwquan on 2020/5/8 11:33
 */
public class MachInfo {
    private String id;//ID
    private String machineNo;//机台号
    private String jJType;//卷接设备类型
    private String bZZJType;//包装主机设备类型
    private String bZFJType;//包装辅机设备类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public String getjJType() {
        return jJType;
    }

    public void setjJType(String jJType) {
        this.jJType = jJType;
    }

    public String getbZZJType() {
        return bZZJType;
    }

    public void setbZZJType(String bZZJType) {
        this.bZZJType = bZZJType;
    }

    public String getbZFJType() {
        return bZFJType;
    }

    public void setbZFJType(String bZFJType) {
        this.bZFJType = bZFJType;
    }
}
