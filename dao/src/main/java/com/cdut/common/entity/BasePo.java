package com.cdut.common.entity;


import java.util.Objects;

/**
 * Created by king on 2017/9/11.
 */
public abstract class BasePo<T> implements Identifiable<T> {

    private static final long serialVersionUID = -8842792284862526474L;

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof BasePo))
            return false;

        BasePo po = (BasePo) o;
        return getId() != null && po.getId() != null && Objects.equals(po.getId(), this.getId());
    }

    @Override
    public int hashCode() {

        return getId() != null ? getId().hashCode() : 0;
    }
}
