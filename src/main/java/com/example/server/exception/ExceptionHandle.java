package com.example.server.exception;

import com.example.server.object.ResultObject;
import com.example.server.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultObject handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException ge = (GirlException) e;
            return ResultUtils.error(ge.getCode(), ge.getMessage());
        } else {
            return ResultUtils.error(404, "未知错误");
        }
    }
}
