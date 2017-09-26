package com.cdut.dao.mysql.repository.product;

import com.cdut.dao.mysql.po.product.ProductPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by king on 2017/9/11.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductPo, Long>, ProductDao,JpaSpecificationExecutor<ProductPo> {

    ProductPo findByName(String name);
}
