package com.cdut.transform;

import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.vo.admin.UserRequestVo;
import com.google.common.base.Function;

import javax.annotation.Nullable;

/**
 * Created by king on 2017/9/13.
 */
public class UserReqVo2User implements Function<UserRequestVo, User> {
    @Nullable
    @Override
    public User apply(@Nullable UserRequestVo vo) {
        return null;
    }
}
