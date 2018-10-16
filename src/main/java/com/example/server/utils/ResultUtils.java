package com.example.server.utils;

import com.example.server.object.ResultObject;

public class ResultUtils {

    public static ResultObject success(Object data) {
        ResultObject resultObject = new ResultObject();
        resultObject.setCode(0);
        resultObject.setMsg("SUCCESS");
        resultObject.setData(data);
        return resultObject;
    }

    public static ResultObject success() {
        return success(null);
    }

    public static ResultObject error(Integer code, String message) {
        ResultObject resultObject = new ResultObject();
        resultObject.setCode(code);
        resultObject.setMsg(message);
        return resultObject;
    }
}

