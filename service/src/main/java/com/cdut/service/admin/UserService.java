package com.cdut.service.admin;

import com.cdut.common.entity.JsonResult;

/**
 *
 * Created by king on 2017/9/11.
 */
public interface UserService {

    JsonResult login(String username, String password);
}
