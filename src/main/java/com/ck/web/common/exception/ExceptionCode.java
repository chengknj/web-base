package com.ck.web.common.exception;

/**
 * 异常编码
 * Created by ChengK on 2017/1/9 0009.
 */
public enum ExceptionCode {

    LOGIN_PWD_ERROR("LOGIN_PWD_ERROR","登录密码错误");

    private String errCode;

    private String errMsg;

    ExceptionCode(String errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getCode() {
        return this.errCode;
    }

    public String getDesc() {
        return this.errMsg;
    }
}
