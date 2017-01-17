package com.ck.web.model.base;

import lombok.ToString;

import java.io.Serializable;

/**
 * 统一响应处理类
 * Created by ChengK on 2017/1/5 0005.
 */
@ToString
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -6315705751650655704L;

    /**
     * 服务调用是否成功
     */
    private boolean success = false;

    private T result; //返回值

    private String errorCode; //获取错误码

    private String errorMsg;

    public BaseResponse(){}

    public BaseResponse(T result) {
        this.result = result;
        this.success = true;
    }

    public BaseResponse(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
        this.success = true;
    }

    public void setError(String errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.success = false;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
