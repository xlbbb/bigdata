package com.gxzy.bigdata.einfo.vo;

/**
 * Description: 停机修机时间
 * Created by wwquan on 2020/5/9 10:49
 */
public class TingJiTime {
    private String id;
    private String tjsjzy;//停机时间主要原因
    private String tjsj;//停机时间
    private String key;//

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjsj() {
        return tjsj;
    }

    public void setTjsj(String tjsj) {
        this.tjsj = tjsj;
    }

    public String getTjsjzy() {
        return tjsjzy;
    }

    public void setTjsjzy(String tjsjzy) {
        this.tjsjzy = tjsjzy;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TingJiTime{" +
                "id='" + id + '\'' +
                ", tjsj='" + tjsj + '\'' +
                ", tjsjzy='" + tjsjzy + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
