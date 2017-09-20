package com.cdut.service.product;

import com.cdut.dao.mysql.po.product.ProductPo;

/**
 *
 * Created by king on 2017/9/11.
 */
public interface ProductService {

    ProductPo findByName(String name);
}
