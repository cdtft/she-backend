package com.cdut.controller.admin;

import com.cdut.annotation.Authorization;
import com.cdut.common.AbstractBaseService;
import com.cdut.common.entity.JsonResult;
import com.cdut.common.myenum.ResultStatus;
import com.cdut.dao.mysql.vo.admin.UserRequestVo;
import com.cdut.service.CheckImgservice;
import com.cdut.service.admin.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by king on 2017/9/11.
 */
@RestController
@RequestMapping("v1/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CheckImgservice checkImgservice;

    /**
     * 用户登陆方法,执行成功后data中封装了UserToken信息
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody UserRequestVo vo) {

        if (StringUtils.isBlank(vo.getUsername()) || StringUtils.isBlank(vo.getPassword())) {

            return new JsonResult("用户名或密码为空", ResultStatus.FAIL.getStatus());
        }
        return userService.login(vo.getUsername(), vo.getPassword());
    }

    /**
     * 用户注册
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "register")
    public JsonResult register(@RequestBody UserRequestVo vo) {
        return userService.register(vo);
    }

    /**
     * 检查用户名是否被注册
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkname/{username}")
    public JsonResult checkUsername(@PathVariable("username") String username) {
        return userService.usernameIsExist(username);
    }

    /**
     * 只用传newPassword, userId在用户登陆后就放在了request中（该接口需要登陆验证）
     *
     * @param userId
     * @param newPassword
     * @return
     */
    @Authorization
    @RequestMapping(value = "/resetPassword/{newPassword}")
    public JsonResult resetPassword(@RequestParam("userId") String userId, @PathVariable("newPassword") String newPassword) {
        return userService.resetPassword(userId, newPassword);
    }


    /**
     * 对管理员用户开放，查找所用的用户（还未验证该用户是否为拥有管理员权限）
     *
     * @return
     */
    @Authorization
    @RequestMapping(value = "/findAll")
    public JsonResult findAll() {
        return userService.findAll();
    }

<<<<<<< HEAD
    /*
    * 验证码接口
    * */
    @RequestMapping(value = "/varifycode", method = RequestMethod.GET)
    public void Varifucode(HttpServletRequest request, HttpServletResponse response) throws Exception {
=======
    /**
     * 验证码接口
     */
    @RequestMapping(value = "/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
>>>>>>> 8f6d6d9e49dc8b8ffcc8824a71c1bbe6bc7c1872
        checkImgservice.execute(request, response);
    }
    //TODO 退出登陆接口
}
