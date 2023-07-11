package com.DEAiFISH.ditest;

import java.util.List;

//部门类
public class Dept {
    private String dName;
    private List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void info() {
        System.out.println("部门名字：" + dName);
        StringBuilder stringBuilder = new StringBuilder();
        for (Emp emp : empList) {
            stringBuilder.append(emp.toString()).append(",");
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}
