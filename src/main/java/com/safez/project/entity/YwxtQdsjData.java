package com.safez.project.entity;

import java.util.Date;

public class YwxtQdsjData {
    private Long qdsjid;

    private String ywid;

    private String ywtanzhenid;

    private Date qdsjtime;

    private String jqid;

    private String userid;

    private String behavior;

    public Long getQdsjid() {
        return qdsjid;
    }

    public void setQdsjid(Long qdsjid) {
        this.qdsjid = qdsjid;
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

    public Date getQdsjtime() {
        return qdsjtime;
    }

    public void setQdsjtime(Date qdsjtime) {
        this.qdsjtime = qdsjtime;
    }

    public String getJqid() {
        return jqid;
    }

    public void setJqid(String jqid) {
        this.jqid = jqid == null ? null : jqid.trim();
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