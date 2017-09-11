package com.cdut.common.entity;

import java.io.Serializable;

/**
 * Created by king on 2017/9/11.
 */
public interface Identifiable<ID> extends Serializable {

    ID getId();

    void setId(ID id);
}
