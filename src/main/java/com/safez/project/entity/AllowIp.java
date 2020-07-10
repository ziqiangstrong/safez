package com.safez.project.entity;

public class AllowIp {
    private Long ipid;

    private String ip;

    public Long getIpid() {
        return ipid;
    }

    public void setIpid(Long ipid) {
        this.ipid = ipid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}