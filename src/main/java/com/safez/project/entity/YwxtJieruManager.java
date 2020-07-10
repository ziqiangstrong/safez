package com.safez.project.entity;

import java.util.Date;

public class YwxtJieruManager {
    private Long ywid;

    private String ywxittanzhengid;

    private String ywxtname;

    private String ywxtjrstate;

    private String ywxtnameen;

    private Date ywjierutime;

    private String ywindexpage;

    private String ywserveradd;

    private Boolean jiamisend;

    private String jiamishuanfa;

    private Boolean javascriptjiami;

    private String ywxtqx;

    private String userid;

    private String mirror;

    public Long getYwid() {
        return ywid;
    }

    public void setYwid(Long ywid) {
        this.ywid = ywid;
    }

    public String getYwxittanzhengid() {
        return ywxittanzhengid;
    }

    public void setYwxittanzhengid(String ywxittanzhengid) {
        this.ywxittanzhengid = ywxittanzhengid == null ? null : ywxittanzhengid.trim();
    }

    public String getYwxtname() {
        return ywxtname;
    }

    public void setYwxtname(String ywxtname) {
        this.ywxtname = ywxtname == null ? null : ywxtname.trim();
    }

    public String getYwxtjrstate() {
        return ywxtjrstate;
    }

    public void setYwxtjrstate(String ywxtjrstate) {
        this.ywxtjrstate = ywxtjrstate == null ? null : ywxtjrstate.trim();
    }

    public String getYwxtnameen() {
        return ywxtnameen;
    }

    public void setYwxtnameen(String ywxtnameen) {
        this.ywxtnameen = ywxtnameen == null ? null : ywxtnameen.trim();
    }

    public Date getYwjierutime() {
        return ywjierutime;
    }

    public void setYwjierutime(Date ywjierutime) {
        this.ywjierutime = ywjierutime;
    }

    public String getYwindexpage() {
        return ywindexpage;
    }

    public void setYwindexpage(String ywindexpage) {
        this.ywindexpage = ywindexpage == null ? null : ywindexpage.trim();
    }

    public String getYwserveradd() {
        return ywserveradd;
    }

    public void setYwserveradd(String ywserveradd) {
        this.ywserveradd = ywserveradd == null ? null : ywserveradd.trim();
    }

    public Boolean getJiamisend() {
        return jiamisend;
    }

    public void setJiamisend(Boolean jiamisend) {
        this.jiamisend = jiamisend;
    }

    public String getJiamishuanfa() {
        return jiamishuanfa;
    }

    public void setJiamishuanfa(String jiamishuanfa) {
        this.jiamishuanfa = jiamishuanfa == null ? null : jiamishuanfa.trim();
    }

    public Boolean getJavascriptjiami() {
        return javascriptjiami;
    }

    public void setJavascriptjiami(Boolean javascriptjiami) {
        this.javascriptjiami = javascriptjiami;
    }

    public String getYwxtqx() {
        return ywxtqx;
    }

    public void setYwxtqx(String ywxtqx) {
        this.ywxtqx = ywxtqx == null ? null : ywxtqx.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getMirror() {
        return mirror;
    }

    public void setMirror(String mirror) {
        this.mirror = mirror == null ? null : mirror.trim();
    }
}