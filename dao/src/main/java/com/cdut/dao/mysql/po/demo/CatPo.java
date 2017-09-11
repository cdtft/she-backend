package com.cdut.dao.mysql.po.demo;

import com.cdut.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by king on 2017/9/10.
 */
@Entity
@Table(name = "adm_cat")
public class CatPo extends BaseEntity {

    private static final long serialVersionUID = -3543103751532039034L;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
