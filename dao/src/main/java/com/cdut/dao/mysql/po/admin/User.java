package com.cdut.dao.mysql.po.admin;

import com.cdut.common.entity.BaseEntity;
import com.cdut.common.myenum.CdutCommonStatus;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by king on 2017/9/11.
 */
@Entity
@Table(name = "adm_user")
public class User implements Serializable {

    private static final long serialVersionUID = 2860143348597400920L;

    private Long id;

    @Id
    @Column(length = 40)
    private String username;

    @Column(length = 40)
    private String password;

    @Column(length = 40)
    private String qqNum;

    @Column(length = 40)
    private String school;

    @Column(length = 40)
    private String email;

    private Timestamp createTime = new Timestamp(System.currentTimeMillis());

    /**
     * 不能为空，默认为可用
     */
    @Column(nullable = false)
    private CdutCommonStatus commonStatus = CdutCommonStatus.ENABLE;


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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public CdutCommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CdutCommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }
}
