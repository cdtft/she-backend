package com.cdut.dao.mysql.repository.admin;

import com.cdut.common.repository.CommonJpaRepositoryBean;
import com.cdut.dao.mysql.po.admin.Role;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by king on 2017/9/25.
 */
public class RoleRepositoryImpl extends CommonJpaRepositoryBean<Role, Long> implements RoleDao {

    @Autowired
    public RoleRepositoryImpl(EntityManager em) {
        super(Role.class, em);
    }
}
