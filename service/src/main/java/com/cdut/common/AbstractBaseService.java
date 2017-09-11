package com.cdut.common;

import com.cdut.common.token.TokenManager;
import com.cdut.service.IdService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2017/9/11.
 */
public abstract class AbstractBaseService {

    protected Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    protected IdService idService;

}
