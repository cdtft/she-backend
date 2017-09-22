package com.cdut.common.token;

import com.cdut.common.security.JWTUtil;
import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.repository.admin.UserRepository;
import com.cdut.dao.redis.ro.admin.UserToken;
import com.google.common.collect.Maps;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis Token验证器
 * Created by king on 2017/9/11.
 */
@Component
public class RedisTokenManager implements TokenManager {

    private static final Logger logger = Logger.getLogger(RedisTokenManager.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public RedisTokenManager(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    @Override
    public UserToken createTokenUser(Long userId) {
        logger.info("为用户生成token信息");
        //使用uuid作为源token信息
        User loginUser = userRepository.findById(userId);
        Map<String, Object> claims = Maps.newHashMap();
        claims.put("ID", userId);
        String token = JWTUtil.generateToken(claims);
        UserToken userToken = new UserToken(userId, token);
        //todo 将时间提取出来
        redisTemplate.boundValueOps(userId).set(token, 30, TimeUnit.MINUTES);
        return userToken;
    }

    @Override
    public boolean checkToken(UserToken tokenUser) {
        if (tokenUser == null) {
            return false;
        }
        try {
            String token = (String) redisTemplate.boundValueOps(tokenUser.getId()).get();
            if (token == null || !tokenUser.getToken().equals(token)) {
                return false;
            }
            //验证成功存重新入redis延长token信息过期时间
            redisTemplate.boundValueOps(tokenUser.getId()).expire(30, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserToken getToken(String authentication) {

        try {
            Claims claims = JWTUtil.getClaimsFromToken(authentication);
            if (claims == null) {
                return null;
            }
            Long userId = Long.parseLong(claims.get("ID").toString());
            return new UserToken(userId, authentication);
        } catch (Exception e) {
            logger.info("获取UserToken失败");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteToken(Long userId) {

        redisTemplate.delete(userId);
    }
}
