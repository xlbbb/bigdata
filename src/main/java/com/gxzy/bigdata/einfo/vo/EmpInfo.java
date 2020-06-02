package com.gxzy.bigdata.einfo.vo;

/**
 * Description: 工号或姓名模糊查询返回前端
 * Created by wwquan on 2020/5/1 1:17
 */
public class EmpInfo {
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    private String empName;
    private String empCode;


}
