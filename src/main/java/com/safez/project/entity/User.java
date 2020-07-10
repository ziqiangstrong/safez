package com.safez.project.entity;

import java.util.Date;

public class User {
    private Long userid;

    private String username;

    private String passwd;

    private Date createtime;

    private String createip;

    private String createjqid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateip() {
        return createip;
    }

    public void setCreateip(String createip) {
        this.createip = createip == null ? null : createip.trim();
    }

    public String getCreatejqid() {
        return createjqid;
    }

    public void setCreatejqid(String createjqid) {
        this.createjqid = createjqid == null ? null : createjqid.trim();
    }
}