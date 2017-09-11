package com.cdut.common.myenum;

/**
 * Created by king on 2017/9/11.
 */
public enum ResultStatus {

    SUCCESS(Boolean.TRUE),
    FALI(Boolean.FALSE);

    ResultStatus(Boolean s){
        this.status = s;
    }

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
