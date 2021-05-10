package com.ssm.exception;

public class SysException extends Exception {

    private String message;
    //存储错误信息


    public SysException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }


}
