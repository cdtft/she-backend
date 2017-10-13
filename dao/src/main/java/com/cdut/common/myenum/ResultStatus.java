package com.cdut.common.myenum;

/**
 * json 返回值中的状态枚举类型，所用的执行状态值都在这里定义
 * 0： 返回成功
 * 500：服务器内部错误
 * Created by king on 2017/9/11.
 */
public enum ResultStatus {//枚举类型

    SUCCESS(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),
    INVALID_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    SERVICE_ERROR(500);

    ResultStatus(int value){
        this.value = value;
    }

    private int value;

    public int getStatus() {
        return value;
    }

    public void setStatus(String status) {
        this.value = value;
    }
}
