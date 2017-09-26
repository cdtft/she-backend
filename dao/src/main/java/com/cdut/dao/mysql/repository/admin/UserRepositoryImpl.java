package com.cdut.dao.mysql.repository.admin;

import com.cdut.common.repository.CommonJpaRepositoryBean;
import com.cdut.dao.mysql.po.admin.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by king on 2017/9/25.
 */
public class UserRepositoryImpl extends CommonJpaRepositoryBean<User, String> implements UserDao {

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        super(User.class, entityManager);
    }
}
