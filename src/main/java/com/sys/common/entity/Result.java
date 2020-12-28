package com.sys.common.entity;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", SystemCode.SYS0000.getCode());
        put("msg", SystemCode.SYS0000.getDesc());
    }

    public static Result error() {
        return error(SystemCode.SYS0500.getCode(), SystemCode.SYS0500.getDesc());
    }

    public static Result error(String msg) {
        return error(SystemCode.SYS0500.getCode(), msg);
    }

    public static Result error(String code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result error(Object msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Object msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }


    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}