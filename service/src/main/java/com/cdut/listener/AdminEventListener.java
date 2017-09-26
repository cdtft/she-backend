package com.cdut.listener;

import com.cdut.dao.mysql.po.admin.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by king on 2017/9/26.
 */
@Component
public class AdminEventListener {

    private static final Logger logger = LoggerFactory.getLogger(AdminEventListener.class);

    @EventListener
    public void handUserEvent(User user) {
        logger.debug("User事件监听1[{}]", user.getUsername());
    }


    @EventListener
    public void handUser(User user) {
        logger.info("User事件监听2[{}]", user.getUsername());
    }
}
