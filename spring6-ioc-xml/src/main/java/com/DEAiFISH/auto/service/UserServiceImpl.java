package com.DEAiFISH.auto.service;

import com.DEAiFISH.auto.dao.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService方法执行...");
//        UserDao dao = new UserDaoImp();
        //调用dao中的方法
        userDao.addUserDao();
    }
}
