package com.DEAiFISH.auto.controller;

import com.DEAiFISH.auto.service.UserService;

//调用顺序: controller --> service --> dao
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUSer() {
        System.out.println("controller方法执行...");
//        UserService userService = new UserServiceImpl();

        //调用service的方法
        userService.addUserService();
    }
}
