package com.safez.project.entity;

public class UserBehavior {
    private Long behid;

    private String busfunc;

    private String subfunc;

    private String step;

    private String url;

    private String relation;

    private String rolecons;

    private String behavior;

    public Long getBehid() {
        return behid;
    }

    public void setBehid(Long behid) {
        this.behid = behid;
    }

    public String getBusfunc() {
        return busfunc;
    }

    public void setBusfunc(String busfunc) {
        this.busfunc = busfunc == null ? null : busfunc.trim();
    }

    public String getSubfunc() {
        return subfunc;
    }

    public void setSubfunc(String subfunc) {
        this.subfunc = subfunc == null ? null : subfunc.trim();
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getRolecons() {
        return rolecons;
    }

    public void setRolecons(String rolecons) {
        this.rolecons = rolecons == null ? null : rolecons.trim();
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior == null ? null : behavior.trim();
    }
}