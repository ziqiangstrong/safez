package com.safez.project.entity;

public class YwxtKeyManager {
    private Long keyid;

    private String ywid;

    public Long getKeyid() {
        return keyid;
    }

    public void setKeyid(Long keyid) {
        this.keyid = keyid;
    }

    public String getYwid() {
        return ywid;
    }

    public void setYwid(String ywid) {
        this.ywid = ywid == null ? null : ywid.trim();
    }
}