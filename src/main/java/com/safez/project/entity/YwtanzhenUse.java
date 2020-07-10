package com.safez.project.entity;

import java.util.Date;

public class YwtanzhenUse {
    private Long tzjrid;

    private String ywid;

    private String tzuseid;

    private Date cjtime;

    private Date xgtime;

    private String cjyuan;

    private String jrtztype;

    public Long getTzjrid() {
        return tzjrid;
    }

    public void setTzjrid(Long tzjrid) {
        this.tzjrid = tzjrid;
    }

    public String getYwid() {
        return ywid;
    }

    public void setYwid(String ywid) {
        this.ywid = ywid == null ? null : ywid.trim();
    }

    public String getTzuseid() {
        return tzuseid;
    }

    public void setTzuseid(String tzuseid) {
        this.tzuseid = tzuseid == null ? null : tzuseid.trim();
    }

    public Date getCjtime() {
        return cjtime;
    }

    public void setCjtime(Date cjtime) {
        this.cjtime = cjtime;
    }

    public Date getXgtime() {
        return xgtime;
    }

    public void setXgtime(Date xgtime) {
        this.xgtime = xgtime;
    }

    public String getCjyuan() {
        return cjyuan;
    }

    public void setCjyuan(String cjyuan) {
        this.cjyuan = cjyuan == null ? null : cjyuan.trim();
    }

    public String getJrtztype() {
        return jrtztype;
    }

    public void setJrtztype(String jrtztype) {
        this.jrtztype = jrtztype == null ? null : jrtztype.trim();
    }
}