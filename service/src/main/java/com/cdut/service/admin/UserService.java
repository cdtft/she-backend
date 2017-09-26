package com.cdut.service.admin;

import com.cdut.common.entity.JsonResult;
import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.vo.admin.UserRequestVo;

/**
 *
 * Created by king on 2017/9/11.
 */
public interface UserService {

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    JsonResult login(String username, String password);

    /**
     * 推出登陆
     * @param user
     * @return
     */
    JsonResult logout(User user);

    /**
     * 验证用户名是否被注册
     * @param username
     * @return
     */
    JsonResult usernameIsExist(String username);

    /**
     * 用户注册
     * @param vo
     * @return
     */
    JsonResult register(UserRequestVo vo);

    /**
     * 修改密码
     * @return
     */
    JsonResult resetPassword(Long userId, String newPassword);

    /**
     * 查询所有user
     * @return
     */
    JsonResult findAll();

    JsonResult checkVerifyCode(String code, String correctCode);

}
