package com.cdut.transform;

import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.vo.admin.UserRespVo;
import com.google.common.base.Function;
import org.springframework.beans.BeanUtils;

import javax.annotation.Nullable;

/**
 *
 * Created by king on 2017/9/16.
 */
public class User2UserRespVo implements Function<User, UserRespVo> {

    @Nullable
    @Override
    public UserRespVo apply(@Nullable User user) {

        if (user != null) {
            UserRespVo vo = new UserRespVo();
            BeanUtils.copyProperties(user, vo);
            return vo;
        }
        return null;
    }
}
