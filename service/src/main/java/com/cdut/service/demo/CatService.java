package com.cdut.service.demo;

import com.cdut.dao.mysql.po.demo.CatPo;

/**
 * Created by king on 2017/9/10.
 */
public interface CatService {

    String sayHello(String name);

    CatPo findByUsername(String username);
}
