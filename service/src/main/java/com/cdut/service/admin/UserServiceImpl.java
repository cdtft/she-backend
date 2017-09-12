package com.cdut.service.admin;

import com.cdut.common.AbstractBaseService;
import com.cdut.common.entity.JsonResult;
import com.cdut.common.myenum.ResultStatus;
import com.cdut.common.token.TokenManager;
import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.repository.admin.UserRepository;
import com.cdut.dao.redis.ro.admin.UserToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return new JsonResult("未找到该用户", ResultStatus.FAIL.getStatus());
        }
        logger.info("创建token信息");
        UserToken token = tokenManager.createTokenUser(user.getId());
        String authorization = String.valueOf(token.getId()) +
                "_" +
                token.getToken();
        return new JsonResult(authorization, "登陆成功", ResultStatus.SUCCESS.getStatus());
    }
}
