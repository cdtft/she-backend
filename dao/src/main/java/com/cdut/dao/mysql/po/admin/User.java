package com.cdut.dao.mysql.po.admin;

import com.cdut.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by king on 2017/9/11.
 */
@Entity
@Table(name = "adm_user")
public class User implements Serializable{

    private static final long serialVersionUID = 2860143348597400920L;

    private Long id;

    @Id
    @Column(length = 40)
    private String username;

    @Column(length = 40)
    private String password;

    @Column(length = 40)
    private String qqNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

}
