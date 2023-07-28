package com.DEAiFISH.validator.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    //原生校验器
    @Test
    public void testValidation1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);

        User user = new User();
        user.setAge(1);
        user.setName("123");

        boolean message = validation1.validatorByUser(user);
        System.out.println(message);
    }

    //spring校验
    @Test
    public void testValidation2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);

        User user = new User();
        user.setAge(1);
        user.setName("123");

        boolean message = validation2.validatorByUser(user);
        System.out.println(message);
    }
}
