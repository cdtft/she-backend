package com.cdut.common;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by king on 2017/9/10.
 */
@NoRepositoryBean
public class CommonRepositoryBean<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CommonRepository<T, ID> {

    private EntityManager entityManager;

    public CommonRepositoryBean(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    public CommonRepositoryBean(final JpaEntityInformation<T, ?> entityInformation,final EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager() {

        return entityManager;
    }

    @Override
    public void persist(T entity) {

    }
}
