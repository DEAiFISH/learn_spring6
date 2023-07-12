package com.DEAiFISH.resource.controller;

import com.DEAiFISH.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {
    //根据名称进行注入
    @Resource(name = "myUserService")
    private UserService userService;

    public void add() {
        System.out.println("controller...");
        userService.add();
    }
}
