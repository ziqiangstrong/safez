package com.safez.project.entity;

import java.util.Date;

public class YwxtGjdata {
    private Long gjid;

    private String ywid;

    private String tzid;

    private Date gjtime;

    private String gjtype;

    private String gjip;

    private String gjjqid;

    private String gjtezhe;

    private String aqdj;

    private String url;

    private String qdsjid;

    private String hdsjid;

    private String userid;

    private Byte setStatus;

    private String gjdatahash;

    public Long getGjid() {
        return gjid;
    }

    public void setGjid(Long gjid) {
        this.gjid = gjid;
    }

    public String getYwid() {
        return ywid;
    }

    public void setYwid(String ywid) {
        this.ywid = ywid == null ? null : ywid.trim();
    }

    public String getTzid() {
        return tzid;
    }

    public void setTzid(String tzid) {
        this.tzid = tzid == null ? null : tzid.trim();
    }

    public Date getGjtime() {
        return gjtime;
    }

    public void setGjtime(Date gjtime) {
        this.gjtime = gjtime;
    }

    public String getGjtype() {
        return gjtype;
    }

    public void setGjtype(String gjtype) {
        this.gjtype = gjtype == null ? null : gjtype.trim();
    }

    public String getGjip() {
        return gjip;
    }

    public void setGjip(String gjip) {
        this.gjip = gjip == null ? null : gjip.trim();
    }

    public String getGjjqid() {
        return gjjqid;
    }

    public void setGjjqid(String gjjqid) {
        this.gjjqid = gjjqid == null ? null : gjjqid.trim();
    }

    public String getGjtezhe() {
        return gjtezhe;
    }

    public void setGjtezhe(String gjtezhe) {
        this.gjtezhe = gjtezhe == null ? null : gjtezhe.trim();
    }

    public String getAqdj() {
        return aqdj;
    }

    public void setAqdj(String aqdj) {
        this.aqdj = aqdj == null ? null : aqdj.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getQdsjid() {
        return qdsjid;
    }

    public void setQdsjid(String qdsjid) {
        this.qdsjid = qdsjid == null ? null : qdsjid.trim();
    }

    public String getHdsjid() {
        return hdsjid;
    }

    public void setHdsjid(String hdsjid) {
        this.hdsjid = hdsjid == null ? null : hdsjid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Byte getSetStatus() {
        return setStatus;
    }

    public void setSetStatus(Byte setStatus) {
        this.setStatus = setStatus;
    }

    public String getGjdatahash() {
        return gjdatahash;
    }

    public void setGjdatahash(String gjdatahash) {
        this.gjdatahash = gjdatahash == null ? null : gjdatahash.trim();
    }
}