package com.cdut.dao.mysql.repository.admin;

import com.cdut.common.repository.CommonJpaRepositoryBean;
import com.cdut.dao.mysql.po.admin.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by king on 2017/9/25.
 */
public class PermissionRepositoryImpl extends CommonJpaRepositoryBean<Permission, Long> implements PermissionDao {

    @Autowired
    public PermissionRepositoryImpl(EntityManager em) {
        super(Permission.class, em);
    }
}
