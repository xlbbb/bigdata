package com.gxzy.bigdata.einfo.vo;

import java.io.Serializable;

/**
 * Description: 牌号
 * Created by wwquan on 2020/5/8 16:21
 */
public class Brand  implements Serializable {
    private String id;
    private String jiXing;//机型 Y:硬盒，X:细支，R：软盒
    private String brand;//牌号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJiXing() {
        return jiXing;
    }

    public void setJiXing(String jiXing) {
        this.jiXing = jiXing;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
