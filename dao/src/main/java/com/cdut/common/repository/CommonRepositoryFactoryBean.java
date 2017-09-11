package com.cdut.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class CommonRepositoryFactoryBean<T extends JpaRepository<Object, Serializable>> extends JpaRepositoryFactoryBean<T, Object, Serializable> {

    /**
     * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public CommonRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new CommonRepositoryFactory(em);
    }
}  
