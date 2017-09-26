package com.cdut.controller.product;

import com.cdut.soa.client.product.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by king on 2017/9/11.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductFeignClient productFeignClient;


    @RequestMapping("test")
    public String test() {

        return productFeignClient.test();
    }
}
