package com.DEAiFISH;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void testUserObject(){
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //获取创建的对象
        //底层是使用反射
        User user = (User)context.getBean("user");
        System.out.println("1:" + user);

        //使用对象调用方法进行测速
        System.out.print("2:");
        user.add();
    }
}