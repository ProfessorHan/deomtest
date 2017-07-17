package com.hbsd.utils;

/**
 * @Author: Hanfei
 * @Date: 2017/7/14
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:JsonResult
 */

public class JsonResult {

    private Object data;

    private String msg = "";

    private int code;

    public static JsonResult success(Object data) {
        JsonResult result = new JsonResult();
        result.data = data;
        result.code = 0;
        return result;
    }

    public static JsonResult success(Object data, String msg) {
        JsonResult result = new JsonResult();
        result.code = 0;
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static JsonResult success() {
        JsonResult result = new JsonResult();
        result.code = 0;
        return result;
    }

    public static JsonResult success(String msg) {
        JsonResult result = new JsonResult();
        result.msg = msg;
        result.code = 0;
        return result;
    }

    public static JsonResult failure(String msg) {
        return failure(-1, msg);
    }

    public static JsonResult failure(int code, String msg) {
        JsonResult result = new JsonResult();
        result.msg = msg;
        result.code = code;
        return result;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
