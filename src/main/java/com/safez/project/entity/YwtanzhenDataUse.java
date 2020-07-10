package com.safez.project.entity;

public class YwtanzhenDataUse {
    private Long ysid;

    private String ywid;

    private String tzid;

    private String zdyname;

    private String zdymiaoshu;

    private String fjgqdzhiduan;

    public Long getYsid() {
        return ysid;
    }

    public void setYsid(Long ysid) {
        this.ysid = ysid;
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

    public String getZdyname() {
        return zdyname;
    }

    public void setZdyname(String zdyname) {
        this.zdyname = zdyname == null ? null : zdyname.trim();
    }

    public String getZdymiaoshu() {
        return zdymiaoshu;
    }

    public void setZdymiaoshu(String zdymiaoshu) {
        this.zdymiaoshu = zdymiaoshu == null ? null : zdymiaoshu.trim();
    }

    public String getFjgqdzhiduan() {
        return fjgqdzhiduan;
    }

    public void setFjgqdzhiduan(String fjgqdzhiduan) {
        this.fjgqdzhiduan = fjgqdzhiduan == null ? null : fjgqdzhiduan.trim();
    }
}