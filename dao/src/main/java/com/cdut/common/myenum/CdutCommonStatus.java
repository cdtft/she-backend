package com.cdut.common.myenum;

/**
 * 公共状态类
 * Created by king on 2017/9/15.
 */
public enum CdutCommonStatus {

    ENABLE(0),
    DISABLE(1);

    private int value;

    CdutCommonStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
