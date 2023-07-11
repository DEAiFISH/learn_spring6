package com.DEAiFISH;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //1、根据id获取bean
        User user1 = (User) context.getBean("user");
        System.out.println("1、根据id获取bean：" + user1);

        //2、根据类型获取bean
        User user2 = context.getBean(User.class);
        System.out.println("2、根据类型获取bean：" + user2);

        //3、根据id和类型获取bena
        User user3 = context.getBean("user", User.class);
        System.out.println("3、根据id和类型获取bean：" + user3);
    }
}