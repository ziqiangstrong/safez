package com.safez.project.entity;

import java.util.Date;

public class YwxtHdSj {
    private Long hdsjid;

    private String ywid;

    private String ywtanzhenid;

    private Date hdsjtime;

    private String jqid;

    private String status;

    private String userid;

    private String behavior;

    public Long getHdsjid() {
        return hdsjid;
    }

    public void setHdsjid(Long hdsjid) {
        this.hdsjid = hdsjid;
    }

    public String getYwid() {
        return ywid;
    }

    public void setYwid(String ywid) {
        this.ywid = ywid == null ? null : ywid.trim();
    }

    public String getYwtanzhenid() {
        return ywtanzhenid;
    }

    public void setYwtanzhenid(String ywtanzhenid) {
        this.ywtanzhenid = ywtanzhenid == null ? null : ywtanzhenid.trim();
    }

    public Date getHdsjtime() {
        return hdsjtime;
    }

    public void setHdsjtime(Date hdsjtime) {
        this.hdsjtime = hdsjtime;
    }

    public String getJqid() {
        return jqid;
    }

    public void setJqid(String jqid) {
        this.jqid = jqid == null ? null : jqid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior == null ? null : behavior.trim();
    }
}