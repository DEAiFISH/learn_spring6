package com.DEAiFISH.autowired.service;

import com.DEAiFISH.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //注入dao
    //第一种方式，属性注入
    //根据类型找到对应对象，完成注入
    /*@Autowired
    private UserDao userDao;*/

    //第二种方式，set方法注入
    /*private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    //第三种方式，构造方法
    /*private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }*/

    //第四种方式，形参上注入
    /*private UserDao userDao;
    public UserServiceImpl(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }*/

    //第五种方式，只有一个有参数构造函数，无注解
    /*private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }*/

    //第六种方式，两个注解，根据名｜称注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}
