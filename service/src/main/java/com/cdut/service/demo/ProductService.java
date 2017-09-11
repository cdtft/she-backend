package com.cdut.service.demo;

import com.cdut.dao.mysql.po.demo.ProductPo;

/**
 *
 * Created by king on 2017/9/11.
 */
public interface ProductService {

    ProductPo findByName(String name);
}
