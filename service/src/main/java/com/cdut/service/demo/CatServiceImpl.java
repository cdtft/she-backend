package com.cdut.service.demo;

import org.springframework.stereotype.Service;

/**
 * Created by king on 2017/9/10.
 */
@Service
public class CatServiceImpl implements CatService {

    @Override
    public String sayHello(String name) {

        return "hello " + name;
    }
}
