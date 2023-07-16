package com.DEAiFISH.service.impl;

import com.DEAiFISH.anno.Bean;
import com.DEAiFISH.anno.Di;
import com.DEAiFISH.dao.UserDao;
import com.DEAiFISH.service.UserService;

@Bean
public class UserServiceImpl  implements UserService {

    @Di
    private UserDao userDao;

    public void add() {
        System.out.println("service.......");
        //调用dao的方法
        userDao.add();
    }
}
