package com.DEAiFISH.ditest;

import java.util.Arrays;

//员工类
public class Emp {
    //对象类型属性：员工输入某个部门
    private Dept dept;
    private String eName;
    private Integer age;
    private String[] interests;

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void work() {
        System.out.println(eName + "emp work..." + age);
        dept.info();
        System.out.println(Arrays.toString(interests));
    }


    @Override
    public String toString() {
        return geteName();
    }
}
