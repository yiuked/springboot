package com.example.server.enums;

public enum CodeEnum {
    DENY_18_AGE(101,"禁止未成年人注册"),
    USER_EXISTS(102,"用户已存在"),
    UNKONW_ERROR(103,"未知错误"),
    USER_LENGTH(104,"用户已存在"),
    DATA_EMPTY(105,"数据为空")
    ;
    private Integer code;
    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
