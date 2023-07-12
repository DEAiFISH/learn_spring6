package com.DEAiFISH;

import com.DEAiFISH.auto.controller.UserController;
import com.DEAiFISH.bean.UserDao;
import com.DEAiFISH.di.Book;
import com.DEAiFISH.dimap.Student;
import com.DEAiFISH.ditest.Dept;
import com.DEAiFISH.ditest.Emp;
import com.DEAiFISH.life.User;
import com.DEAiFISH.scope.Orders;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    /**
     * 获取bean
     */
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //1、根据id获取bean
        User user1 = (User) context.getBean("user");
        System.out.println("1、根据id获取bean：" + user1);

        //2、根据类型获取bean,配置文件中只能又一个同类型的bean
        User user2 = context.getBean(User.class);
        System.out.println("2、根据类型获取bean：" + user2);

        //3、根据id和类型获取bena
        User user3 = context.getBean("user", User.class);
        System.out.println("3、根据id和类型获取bean：" + user3);
    }

    /**
     * 通过接口获取bean
     */
    @Test
    public void testUserDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //根据类型获取接口对应bean,配置文件中只能有一个实现类实现该接口
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }

    /**
     * set注入
     */
    @Test
    public void testSetter() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = context.getBean("book", Book.class);

        System.out.println(book);
    }

    /**
     * 构造器注入
     */
    @Test
    public void testConstructor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = context.getBean("bookCon", Book.class);

        System.out.println(book);
    }

    /**
     * 特殊属性注入
     */
    @Test
    public void testEmp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");

        //员工对象
//        Emp emp = context.getBean("emp", Emp.class);
//        Emp emp = context.getBean("emp2", Emp.class);
        Emp emp = context.getBean("emp3", Emp.class);
        emp.work();
    }

    /**
     * 数组属性注入
     */
    @Test
    public void testArray() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");

        Emp emp = context.getBean("emp", Emp.class);

        emp.work();
    }

    /**
     * List属性注入
     */
    @Test
    public void testList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");

        Dept dept = context.getBean("dept", Dept.class);

        dept.info();
    }

    /**
     * Map属性注入
     */
    @Test
    public void testMap() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dimap.xml");

        Student student = context.getBean("student", Student.class);

        student.run();
    }

    /**
     * 引入集合bean
     */
    @Test
    public void testUtil() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");

        Student student = context.getBean("student", Student.class);

        student.run();
    }

    /**
     * p命名空间
     */
    @Test
    public void testP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");

        Student student = context.getBean("studentP", Student.class);

        student.run();
    }

    /**
     * 引入外部属性文件
     */
    @Test
    public void demo1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/learn_spring?serverTimezone=UTC");
        dataSource.setName("root");
        dataSource.setPassword("tmmKing4612.m");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    @Test
    public void demo2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc.xml");

        DruidDataSource dataSource = context.getBean("druidDataSource", DruidDataSource.class);

        System.out.println(dataSource.getUrl());
    }

    /**
     * scope属性
     */
    @Test
    public void testOrders() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");

        //单实例
        Orders orders1 = context.getBean("orders-singleton", Orders.class);
        Orders orders2 = context.getBean("orders-singleton", Orders.class);
        System.out.println(orders1);
        System.out.println(orders2);
        System.out.println(orders1 == orders2);

        //多实例
        Orders orders3 = context.getBean("orders-prototype", Orders.class);
        Orders orders4 = context.getBean("orders-prototype", Orders.class);
        System.out.println(orders3);
        System.out.println(orders4);
        System.out.println(orders3 == orders4);
    }

    /**
     * bean生命周期
     */
    @Test
    public void testLife() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");

        User user = context.getBean("user", User.class);

        System.out.println("6、bean对象创建完成了，可以使用了");
        System.out.println(user);

        //销毁
        context.close();
    }

    /**
     * FactoryBean
     */
    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");

        System.out.println(context.getBean("user") instanceof com.DEAiFISH.factorybean.User);
    }

    /**
     * 自动装配
     */
    @Test
    public void testAuto() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");

        UserController userController = context.getBean("userController", UserController.class);
        userController.addUSer();
    }
}