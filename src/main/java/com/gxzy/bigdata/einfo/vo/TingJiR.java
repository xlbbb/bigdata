package com.gxzy.bigdata.einfo.vo;

/**
 * Description: 停机数量的主要原因
 * Created by wwquan on 2020/5/9 10:45
 */
public class TingJiR {
    private String id;
    private String tjzy;//停机主要原因
    private String tjcs;//停机主要原因次数
    private String key;//填写原因的时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjzy() {
        return tjzy;
    }

    public void setTjzy(String tjzy) {
        this.tjzy = tjzy;
    }

    public String getTjcs() {
        return tjcs;
    }

    public void setTjcs(String tjcs) {
        this.tjcs = tjcs;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
