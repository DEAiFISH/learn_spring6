package com.DEAiFISH.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceLoaderDemo {

    /*
    Spring将采用和ApplicationContext相同的策略来访问资源。
    也就是说，如果ApplicationContext是FileSystemXmlApplicationContext，res就是FileSystemResource实例；
    如果ApplicationContext是ClassPathXmlApplicationContext，res就是ClassPathResource实例
    当Spring应用需要进行资源访问时，实际上并不需要直接使用Resource实现类，
    而是调用ResourceLoader实例的getResource()方法来获得资源，ReosurceLoader将会负责选择Reosurce实现类，
    也就是确定具体的资源访问策略，从而将应用程序和具体的资源访问策略分离开来
    另外，使用ApplicationContext访问资源时，
    可通过不同前缀指定强制使用指定的ClassPathResource、FileSystemResource等实现类
    */
    @Test
    public void demo1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
//        通过ApplicationContext访问资源
//        ApplicationContext实例获取Resource实例时，
//        默认采用与ApplicationContext相同的资源访问策略
        Resource res = ctx.getResource("deaifish.txt");
        System.out.println(res.getFilename());
    }

    @Test
        public void demo2() {
            ApplicationContext ctx = new FileSystemXmlApplicationContext();
            Resource res = ctx.getResource("deaifish.txt");
            System.out.println(res.getFilename());
        }

}