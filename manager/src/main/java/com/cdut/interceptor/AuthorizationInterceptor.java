package com.cdut.interceptor;

import com.cdut.annotation.Authorization;
import com.cdut.common.token.TokenManager;
import com.cdut.dao.redis.ro.admin.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器完成权限验证
 * Created by king on 2017/9/11.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //如果不是映射的方法直接返回true
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String authorization = request.getHeader("authorization");
        UserToken userToken = tokenManager.getToken(authorization);
        if (tokenManager.checkToken(userToken)) {
            //token解析成功，将userId放在request中
            request.setAttribute("USER_ID", userToken.getId());
        }
        //验证失败,返回401未授权(controller中的方法使用的Authorization注解)
        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus (HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
