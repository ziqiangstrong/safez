package com.safez.project.entity;

import java.util.Date;

public class TanzhengManager {
    private Long tzid;

    private Date tzcreatetime;

    private String tzname;

    private String tzmiaoshu;

    private String tzfunction;

    private String tzpath;

    private String tztype;

    public Long getTzid() {
        return tzid;
    }

    public void setTzid(Long tzid) {
        this.tzid = tzid;
    }

    public Date getTzcreatetime() {
        return tzcreatetime;
    }

    public void setTzcreatetime(Date tzcreatetime) {
        this.tzcreatetime = tzcreatetime;
    }

    public String getTzname() {
        return tzname;
    }

    public void setTzname(String tzname) {
        this.tzname = tzname == null ? null : tzname.trim();
    }

    public String getTzmiaoshu() {
        return tzmiaoshu;
    }

    public void setTzmiaoshu(String tzmiaoshu) {
        this.tzmiaoshu = tzmiaoshu == null ? null : tzmiaoshu.trim();
    }

    public String getTzfunction() {
        return tzfunction;
    }

    public void setTzfunction(String tzfunction) {
        this.tzfunction = tzfunction == null ? null : tzfunction.trim();
    }

    public String getTzpath() {
        return tzpath;
    }

    public void setTzpath(String tzpath) {
        this.tzpath = tzpath == null ? null : tzpath.trim();
    }

    public String getTztype() {
        return tztype;
    }

    public void setTztype(String tztype) {
        this.tztype = tztype == null ? null : tztype.trim();
    }
}