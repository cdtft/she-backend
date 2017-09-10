package com.cdut.dao.mysql.repository.demo;

import com.cdut.common.CommonRepository;
import com.cdut.dao.mysql.po.demo.CatPo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by king on 2017/9/10.
 */
@Repository
public interface CatRepository extends CommonRepository<CatPo, String>, JpaSpecificationExecutor<CatPo> {

    CatPo findByUsername(String username);
}
