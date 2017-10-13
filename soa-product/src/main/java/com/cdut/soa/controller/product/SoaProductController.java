package com.cdut.soa.controller.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by king on 2017/9/21.
 */
@RestController
@RequestMapping("soa/product")
public class SoaProductController {

    @RequestMapping("test")
    public String test() {
        return "hello";
    }
}
