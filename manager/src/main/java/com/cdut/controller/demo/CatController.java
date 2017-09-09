package com.cdut.controller.demo;

import com.cdut.service.demo.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by king on 2017/9/10.
 */

@RestController
@RequestMapping("cat")
public class CatController {

    @Autowired
    private CatService catService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable("name")String name) {

        return catService.sayHello(name);
    }
}
