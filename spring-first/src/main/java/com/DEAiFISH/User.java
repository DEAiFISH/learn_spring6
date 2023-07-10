package com.DEAiFISH;

public class User {
    public User() {
        System.out.println("0:无参数构造执行...");
    }
    public void add(){
        System.out.println("add...");
    }

    public static void main(String[] args) {
        User user = new User();
        user.add();
    }
}
