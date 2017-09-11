package com.cdut.dao.mysql.repository.demo;

import com.cdut.common.repository.CommonJpaRepositoryBean;
import com.cdut.dao.mysql.po.demo.CatPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 *
 * Created by king on 2017/9/10.
 */
@Repository
public class CatRepositoryImpl extends CommonJpaRepositoryBean<CatPo, Long>  {

    @Autowired
    public CatRepositoryImpl (EntityManager em) {

        super(CatPo.class, em);
    }

}
