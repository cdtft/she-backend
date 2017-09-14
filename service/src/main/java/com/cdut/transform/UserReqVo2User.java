package com.cdut.transform;

import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.vo.admin.UserRequestVo;
import com.google.common.base.Function;

import javax.annotation.Nullable;

/**
 * user vo trans po
 * Created by king on 2017/9/13.
 */
public class UserReqVo2User implements Function<UserRequestVo, User> {

    @Nullable
    @Override
    public User apply(@Nullable UserRequestVo vo) {
        if (vo != null) {
            User user = new User();
            user.setUsername(vo.getUsername());
            user.setPassword(vo.getPassword());
            user.setQqNum(vo.getQqNum());
            return user;
        }
        return null;
    }
}
