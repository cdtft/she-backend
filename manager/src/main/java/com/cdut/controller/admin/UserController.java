package com.cdut.controller.admin;

import com.cdut.common.AbstractBaseService;
import com.cdut.common.entity.JsonResult;
import com.cdut.common.myenum.ResultStatus;
import com.cdut.service.admin.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by king on 2017/9/11.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登陆方法,执行成功后data中封装了UserToken信息
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResult login(@RequestParam("username") String username, @RequestParam("password") String password) {

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return new JsonResult(ResultStatus.FALI.getStatus(), "用户名或密码为空");
        }
        return userService.login(username, password);
    }

}
