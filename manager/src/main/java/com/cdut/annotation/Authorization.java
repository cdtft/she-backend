package com.cdut.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解该注解在controller中的方法上将会检查用户是否登陆
 * 如果没有登陆将会返回401未授权错误
 * Created by king on 2017/9/11.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {

}
