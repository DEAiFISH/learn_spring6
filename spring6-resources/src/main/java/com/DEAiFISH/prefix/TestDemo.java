package com.DEAiFISH.prefix;

import com.DEAiFISH.di.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class TestDemo {
    public static void main(String[] args) {
        //通配符
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:bean*.xml");
//        Resource resource = context.getResource("classpath:deaifish.txt");
//        Resource resource = context.getResource("file:deaifish.txt");
//        System.out.println(resource.getDescription());

        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
