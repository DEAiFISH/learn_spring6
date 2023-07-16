package com.DEAiFISH;

import com.DEAiFISH.bean.AnnotationApplicationContext;
import com.DEAiFISH.bean.ApplicationContext;
import com.DEAiFISH.service.UserService;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationApplicationContext("com.atguigu");
        UserService userService = (UserService)context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
