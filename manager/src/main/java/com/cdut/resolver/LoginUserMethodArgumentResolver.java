package com.cdut.resolver;

import com.cdut.annotation.LoginUser;
import com.cdut.dao.mysql.po.admin.User;
import com.cdut.dao.mysql.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 自定义参数解析器，将方法参数中带有@LoginUser注解的参数解析为当前登陆的User对象
 * Created by king on 2017/9/21.
 */
@Component
public class LoginUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserRepository userRepository;

    /**
     * 返回true才支持该方法参数的解析
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        if (methodParameter.getParameterType().isAssignableFrom(User.class) &&
                methodParameter.hasMethodAnnotation(LoginUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Long loginUserId = (Long) nativeWebRequest.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);
        if (loginUserId != null) {
            return userRepository.findById(loginUserId);
        }
        throw new MissingServletRequestPartException("userId");
    }
}
