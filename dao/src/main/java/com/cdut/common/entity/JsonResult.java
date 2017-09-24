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
     * 状态 code值:成功状态值为0，失败为其他值
     */
    private ResultStatus code;

    public JsonResult() {

    }

    public JsonResult(Object data, String msg, ResultStatus code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public JsonResult(String msg, ResultStatus code) {
        this.msg = msg;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultStatus getCode() {
        return code;
    }

    public void setCode(ResultStatus code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
