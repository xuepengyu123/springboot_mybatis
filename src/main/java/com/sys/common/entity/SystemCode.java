package com.sys.common.entity;

public enum SystemCode {

    SYS0000("SYS0000", "成功"),

    SYS0001("SYS0001", "用户未登录"),

    SYS0500("SYS0500", "未知异常，请联系管理员");


    private String code;

    private String desc;

    private SystemCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
