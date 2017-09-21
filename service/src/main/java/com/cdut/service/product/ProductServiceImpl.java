package com.cdut.service.product;

import com.cdut.dao.mysql.po.product.ProductPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by king on 2017/9/11.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductService productService;

    @Override
    public ProductPo findByName(String name) {

        return productService.findByName(name);
    }
}
