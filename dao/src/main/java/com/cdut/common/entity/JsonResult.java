package com.cdut.common.entity;

import com.cdut.common.myenum.ResultStatus;

/**
 * rest接口返回的统一对象
 * Created by king on 2017/9/11.
 */
public class JsonResult {

    /**
     * 返回的数据对象
     */
    private Object data;

    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 状态 false:
     */
    private Boolean status;

    public JsonResult() {

    }

    public JsonResult(Object data, String msg, Boolean status) {
        this.data = data;
        this.msg = msg;
        this.status = status;
    }

    public JsonResult(Boolean status, String msg) {
        this.msg = msg;
        this.status = status;
    }


    public JsonResult(Object data, Boolean status) {
        this.data = data;
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
