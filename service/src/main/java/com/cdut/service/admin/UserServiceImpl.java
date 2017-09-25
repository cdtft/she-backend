package com.cdut.service.admin;

import com.cdut.common.AbstractBaseService;
import com.cdut.common.entity.JsonResult;
import com.cdut.common.myenum.ResultStatus;
import com.cdut.common.token.TokenManager;
import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.repository.admin.UserRepository;
import com.cdut.dao.mysql.vo.admin.UserRequestVo;
import com.cdut.dao.mysql.vo.admin.UserRespVo;
import com.cdut.dao.redis.ro.admin.UserToken;
import com.cdut.transform.User2UserRespVo;
import com.cdut.transform.UserReqVo2User;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by king on 2017/9/11.
 */
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    @Override
    public JsonResult login(String username, String password) {

        User user = userRepository.findByUsername(username);
        if (user == null || !StringUtils.equals(user.getPassword(), password)) {
            return new JsonResult("密码或用户名不正确", ResultStatus.FORBIDDEN);
        }
        logger.info("创建token信息");
        UserToken tokenModel = tokenManager.createTokenUser(user.getId());
        Map<String, Object> tokenInfo = Maps.newHashMap();
        tokenInfo.put("userId", tokenModel.getId().toString());
        tokenInfo.put("authorization", tokenModel.getToken());
        return new JsonResult(tokenInfo, "登陆成功", ResultStatus.SUCCESS);
    }

    @Override
    public JsonResult logout(User user) {
        tokenManager.deleteToken(user.getId());
        return new JsonResult("用户退出登陆", ResultStatus.SUCCESS);
    }

    @Override
    public JsonResult usernameIsExist(String username) {

        if (StringUtils.isBlank(username)) {
            logger.info("校验有户名为空");
            return new JsonResult("校验用户名为空", ResultStatus.INVALID_REQUEST);
        }
        User user =  userRepository.findOne(username);
        if (user == null) {
            return new JsonResult("该用户名可用", ResultStatus.SUCCESS);
        }
        return new JsonResult("该用户名已存在", ResultStatus.FORBIDDEN);
    }

    @Transactional
    @Override
    public JsonResult register(UserRequestVo vo) {
        if (StringUtils.isBlank(vo.getUsername())) {
            logger.info("register 用户提交的用户名为空[{}]", vo);
            return new JsonResult(null, "用户名不能为空", ResultStatus.INVALID_REQUEST);
        }
        if (StringUtils.isBlank(vo.getPassword())) {
            logger.info("register 用户提交的密码为空[{}]", vo);
            return new JsonResult("密码不能为空", ResultStatus.INVALID_REQUEST);
        }
        User existUser = userRepository.findByUsername(vo.getUsername());
        if (existUser != null) {
            logger.info("该用户已经存在[{}]", vo.getUsername());
            return new JsonResult("该用户名已经存在", ResultStatus.INVALID_REQUEST);
        }
        User user = new UserReqVo2User().apply(vo);
        user.setId(idService.nextId());
        userRepository.save(user);
        return new JsonResult("注册成功", ResultStatus.CREATED);
    }

    @Transactional
    @Override
    public JsonResult resetPassword(Long userId, String newPassword) {
        userRepository.updatePasswordById(userId, newPassword);
        return new JsonResult(null, "密码修改成功", ResultStatus.CREATED);
    }

    @Override
    public JsonResult findAll() {
        List<User> users = userRepository.findAll();
        List<UserRespVo> userRespVos = Lists.transform(users, new User2UserRespVo());
        return new JsonResult(userRespVos, "获取所用的用户", ResultStatus.SUCCESS);
    }

    @Override
    public JsonResult checkVerifyCode(String code, String correctCode) {
        if (code.equalsIgnoreCase(correctCode)) {
            return new JsonResult(Boolean.TRUE, "验证成功", ResultStatus.SUCCESS);
        }
        return new JsonResult(Boolean.FALSE, "验证失败", ResultStatus.SUCCESS);
    }
}
