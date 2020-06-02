package com.gxzy.bigdata.vo;

/**
 * Description: 自定义返回类，用作数组查询用返回前端使用
 * Created by wwquan on 2020/5/23 11:14
 */
public class CustomOptions {
    private String value;
    private String label;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "CustomOptions{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
