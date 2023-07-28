package com.DEAiFISH.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

public class ResourceI18n {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Object[] objs = new Object[]{"deaifish", new Date().toString()};

        String message = context.getMessage("www.deaifish.com", objs, Locale.ENGLISH);

        System.out.println(message);
    }
}
