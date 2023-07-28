package com.DEAiFISH.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        //创建Person对象
        Person person = new Person();
        person.setAge(-1);

        //创建Person对应databinder
        DataBinder binder = new DataBinder(person);

        //设置校验器
        binder.setValidator(new PersonValidator());

        //调用方法进行校验
        binder.validate();

        //输出校验结果
        BindingResult result = binder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
