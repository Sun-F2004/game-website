package com.firewin.common.result;

import lombok.Data;

//返回消息的统一封装类
@Data
public class Result<T> {

    private Integer code; //编码：1成功，0为失败
    private String msg; //错误信息
    private T data; //数据

    //无需返回数据给前端的方法
    public static Result<String> success() {
        Result<String> result = new Result<>();
        result.code = 1;
        return result;
    }

    //需要返回数据的方法
    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 1;
        return result;
    }

    //访问错误的方法
    public static Result<String> error(String msg) {
        Result<String> result = new Result<>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
