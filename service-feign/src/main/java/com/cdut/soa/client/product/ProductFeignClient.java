package com.cdut.soa.client.product;

import com.cdut.soa.hystrix.product.ProductFeignClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by king on 2017/9/21.
 */
@FeignClient(name = "soa-product", fallback = ProductFeignClientHystrix.class)
public interface ProductFeignClient {

    @RequestMapping(value = "soa/product/test", method = RequestMethod.GET)
    String test();
}
