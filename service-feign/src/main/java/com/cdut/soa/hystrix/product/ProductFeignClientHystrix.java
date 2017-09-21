package com.cdut.soa.hystrix.product;

import com.cdut.soa.client.product.ProductFeignClient;
import org.springframework.stereotype.Component;

/**
 * 断路器
 * Created by king on 2017/9/21.
 */
@Component
public class ProductFeignClientHystrix implements ProductFeignClient {

    @Override
    public String test() {
        return null;
    }
}
