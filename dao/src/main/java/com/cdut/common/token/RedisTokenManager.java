package com.cdut.common.token;

import com.cdut.dao.redis.ro.admin.UserToken;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * redis Token验证器
 * Created by king on 2017/9/11.
 */
@Component
public class RedisTokenManager implements TokenManager {

    private static final Logger logger = Logger.getLogger(RedisTokenManager.class);

    private RedisTemplate redisTemplate;

    @Autowired
    public RedisTokenManager(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    @Override
    public UserToken createTokenUser(Long userId) {
        logger.info("为用户生成token信息");
        //使用uuid作为源token信息
        String token = UUID.randomUUID().toString().replace("-", "");
        UserToken userToken = new UserToken(userId, token);
        //存到redis并设置过期时间72小时过期
        //todo 将时间提取出来
        redisTemplate.boundValueOps(userId).set(token, 72, TimeUnit.HOURS);
        return userToken;
    }

    @Override
    public boolean checkToken(UserToken tokenUser) {
        if (tokenUser == null) {
            return false;
        }
        String token = (String) redisTemplate.boundValueOps(tokenUser.getId()).get();
        if(token == null || !tokenUser.getToken().equals(token)){
            return false;
        }
        //验证成功存重新入redis延长token信息过期时间
        redisTemplate.boundValueOps(tokenUser.getId()).expire( 72, TimeUnit.HOURS);
        return true;
    }

    @Override
    public UserToken getToken(String authentication) {

        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new UserToken(userId, token);
    }

    @Override
    public void deleteToken(Long userId) {

        redisTemplate.delete(userId);
    }
}
