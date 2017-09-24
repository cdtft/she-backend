package com.cdut.controller.admin;

import com.cdut.annotation.Authorization;
import com.cdut.annotation.LoginUser;
import com.cdut.common.entity.JsonResult;
import com.cdut.common.myenum.ResultStatus;
import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.vo.admin.UserRequestVo;
import com.cdut.service.CheckImgService;
import com.cdut.service.admin.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by king on 2017/9/11.
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CheckImgService checkImgService;

    /**
     * 用户登陆方法,执行成功后data中封装了UserToken信息
     */
    @RequestMapping(value = "v1/api/session", method = RequestMethod.POST)
    public JsonResult login(@RequestBody UserRequestVo vo) {

        if (StringUtils.isBlank(vo.getUsername()) || StringUtils.isBlank(vo.getPassword())) {

            return new JsonResult("用户名或密码为空", ResultStatus.SUCCESS);
        }
        return userService.login(vo.getUsername(), vo.getPassword());
    }

    /**
     * 退出登陆
     *
     * @param loginUser
     * @return
     */
    @Authorization
    @RequestMapping(value = "v1/api/session", method = RequestMethod.DELETE)
    public JsonResult logout(@LoginUser User loginUser) {
        return userService.logout(loginUser);
    }

    /**
     * 用户注册
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "v1/api/user", method = RequestMethod.POST)
    public JsonResult register(@RequestBody UserRequestVo vo) {
        return userService.register(vo);
    }

    /**
     * 检查用户名是否被注册
     *
     * @param username user表主键
     * @return
     */
    @RequestMapping(value = "v1/api/user/{username}", method = RequestMethod.POST)
    public JsonResult checkUsername(@PathVariable("username") String username) {
        return userService.usernameIsExist(username);
    }

    /**
     * 只用传newPassword, userId在用户登陆后就放在了request中（该接口需要登陆验证）
     *
     * @param user
     * @param newPassword
     * @return
     */
    @Authorization
    @RequestMapping(value = "v1/api/user/{newPassword}", method = RequestMethod.PUT)
    public JsonResult resetPassword(@LoginUser User user, @PathVariable("newPassword") String newPassword) {
        return userService.resetPassword(user.getId(), newPassword);
    }


    /**
     * 对管理员用户开放，查找所用的用户（还未验证该用户是否为拥有管理员权限）
     *
     * @return
     */
    @Authorization
    @RequestMapping(value = "v1/api/users", method = RequestMethod.GET)
    public JsonResult findAll() {
        return userService.findAll();
    }

    /**
     * 获取验证码图片
     */
    @RequestMapping(value = "v1/api/verifyCode", method = RequestMethod.GET)
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        checkImgService.execute(request, response, session);
    }

    /**
     * 验证用户输入的验证码是否正确
     * @param code
     * @param session
     * @return
     */
    @RequestMapping(value = "v1/api/checkImg/{customerVerifyCode}", method = RequestMethod.POST)
    public JsonResult checkVerifyCode(@PathVariable("customerVerifyCode") String code, HttpSession session) {

        String correct;
        try {
            correct = session.getAttribute("verifyCode").toString();
        } catch (Exception e) {
            logger.error("从session中获取VerifyCode失败");
            return new JsonResult(Boolean.FALSE, "从session中获取VerifyCode失败", ResultStatus.SUCCESS);
        }
        return userService.checkVerifyCode(code, correct);
    }

}
