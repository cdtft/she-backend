package com.cdut.common;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

/**
 * Created by king on 2017/9/10.
 */
public class CommonRepositoryFactory extends JpaRepositoryFactory {

    public CommonRepositoryFactory(EntityManager entityManager) {

        super(entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

        return super.getRepositoryBaseClass(metadata);
    }
}
