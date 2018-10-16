package com.example.server.exception;

import com.example.server.enums.CodeEnum;

public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
