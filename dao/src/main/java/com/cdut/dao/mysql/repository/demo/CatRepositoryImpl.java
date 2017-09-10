package com.cdut.dao.mysql.repository.demo;

import com.cdut.common.CommonRepositoryBean;
import com.cdut.common.CommonRepositoryFactoryBean;
import com.cdut.dao.mysql.po.demo.CatPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 *
 * Created by king on 2017/9/10.
 */
@Repository
public class CatRepositoryImpl extends CommonRepositoryBean<CatPo, String> implements CatDao {

    @Autowired
    public CatRepositoryImpl (EntityManager em) {

        super(CatPo.class, em);
    }

}
