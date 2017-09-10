package com.cdut.service.demo;

import com.cdut.dao.mysql.po.demo.CatPo;
import com.cdut.dao.mysql.repository.demo.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by king on 2017/9/10.
 */
@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Override
    public String sayHello(String name) {

        return "hello " + name;
    }

    @Override
    public CatPo findByUsername(String username) {

        return catRepository.findByUsername(username);
    }
}
