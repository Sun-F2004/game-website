package com.firewin.common.exception;

//自定义exception
public class BaseException extends RuntimeException {

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }
}
