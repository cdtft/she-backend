package com.cdut.common;

import com.cdut.service.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2017/9/11.
 */
public abstract class AbstractBaseService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected IdService idService;

}
