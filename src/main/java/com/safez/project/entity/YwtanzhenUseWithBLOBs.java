package com.safez.project.entity;

public class YwtanzhenUseWithBLOBs extends YwtanzhenUse {
    private String info1;

    private String info2;

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1 == null ? null : info1.trim();
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2 == null ? null : info2.trim();
    }
}