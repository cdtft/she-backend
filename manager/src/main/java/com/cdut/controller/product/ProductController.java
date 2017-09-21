package com.cdut.controller.product;

import com.cdut.dao.mysql.po.product.ProductPo;
import com.cdut.service.product.ProductService;
import com.cdut.soa.client.product.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by king on 2017/9/11.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private ProductService productService;

    @RequestMapping("/findByName/{name}")
    @ResponseBody
    public ProductPo findByName(@PathVariable("name") String name) {

        return productService.findByName(name);
    }

    @RequestMapping("test")
    public String test() {

        return productFeignClient.test();
    }
}
