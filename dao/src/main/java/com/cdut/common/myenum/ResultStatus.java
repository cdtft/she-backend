package com.cdut.common.myenum;

/**
 * json 返回值中的状态枚举类型，所用的执行状态值都在这里定义
 * 0： 返回成功
 * 500：服务器内部错误
 * Created by king on 2017/9/11.
 */
public enum ResultStatus {

    SUCCESS("0"),
    FAIL("500");

    ResultStatus(String status){
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
