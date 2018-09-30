package com.ebrightmoon.bean;


/**
 */
public class ResponseResult<T> {
    private int Code;
    private String Message;
    private T Data;


    public int getCode() {
        return Code;
    }

    public ResponseResult setCode(int code) {
        Code = code;
        return this;
    }

    public String getMessage() {
        return Message;
    }

    public ResponseResult setMessage(String message) {
        Message = message;

        return this;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
