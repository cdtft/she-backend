package com.cdut.dao.redis.ro.admin;

import java.io.Serializable;

/**
 * 往redis中存入Ro对象
 * Created by king on 2017/9/11.
 */
public class UserToken implements Serializable {

    private static final long serialVersionUID = 7426332267123601077L;

    /**
     * user id(由IdService生成)
     */
    private Long id;

    /**
     * 随机生成的UUID
     */
    private String token;

    public UserToken (Long userId, String token) {
        this.id = userId;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
