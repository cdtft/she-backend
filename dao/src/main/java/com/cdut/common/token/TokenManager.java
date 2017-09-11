package com.cdut.common.token;

import com.cdut.dao.redis.ro.admin.UserToken;

/**
 * 对Token进行操作的接口
 * Created by king on 2017/9/11.
 */
public interface TokenManager {

    /**
     * 生成Token并绑定到指定的User对象
     * @param userId
     * @return 生成的token
     */
    UserToken createTokenUser(Long userId);

    /**
     * 检查token信息是否有效
     * @param tokenUser
     * @return 检查结果
     */
    boolean checkToken(UserToken tokenUser);

    /**
     * 从加密的字符串中解析出token信息
     * @param authentication
     * @return
     */
    UserToken getToken(String authentication);

    /**
     * 清楚user对应的token信息
     * @param userId
     */
    void deleteToken(Long userId);
}
