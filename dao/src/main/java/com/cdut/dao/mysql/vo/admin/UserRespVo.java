package com.cdut.dao.mysql.vo.admin;

import com.cdut.common.myenum.CdutCommonStatus;

import java.sql.Timestamp;

/**
 *
 * Created by king on 2017/9/15.
 */
public class UserRespVo {

    private Long id;

    private String username;

    private String password;

    private String qqNum;

    private String school;

    private String email;

    private Timestamp createTime;

    private CdutCommonStatus commonStatus;

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
