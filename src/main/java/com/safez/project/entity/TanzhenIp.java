package com.safez.project.entity;

import java.util.Date;

public class TanzhenIp {
    private Long ipid;

    private String qdsjid;

    private String ywtanzhenid;

    private String ywid;

    private Date qdsjtime;

    private String jqid;

    private String ipInfo;

    private String url;

    public Long getIpid() {
        return ipid;
    }

    public void setIpid(Long ipid) {
        this.ipid = ipid;
    }

    public String getQdsjid() {
        return qdsjid;
    }

    public void setQdsjid(String qdsjid) {
        this.qdsjid = qdsjid == null ? null : qdsjid.trim();
    }

    public String getYwtanzhenid() {
        return ywtanzhenid;
    }

    public void setYwtanzhenid(String ywtanzhenid) {
        this.ywtanzhenid = ywtanzhenid == null ? null : ywtanzhenid.trim();
    }

    public String getYwid() {
        return ywid;
    }

    public void setYwid(String ywid) {
        this.ywid = ywid == null ? null : ywid.trim();
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

    public String getIpInfo() {
        return ipInfo;
    }

    public void setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo == null ? null : ipInfo.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}