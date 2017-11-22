package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;


import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration("classpath*:/smart-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests{

    @Autowired
    private UserService userService;

    @Rollback(false)
    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "11111");
        assertTrue(b1);
        //assertTrue(b2);
    }

    @Rollback(false)
    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }

    @Rollback(false)
    @Test
    public void testAddLoginLog(){
        User user = userService.findUserByUserName("admin");
        user.setUserId(2);
        user.setUserName("tang");
        user.setLastIp("192.168.12.8");
        user.setLastVistit(new Date());
        userService.loginSuccess(user);
    }
}
