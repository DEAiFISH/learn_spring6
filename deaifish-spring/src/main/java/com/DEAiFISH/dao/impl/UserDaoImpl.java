package com.DEAiFISH.dao.impl;

import com.DEAiFISH.anno.Bean;
import com.DEAiFISH.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao.......");
    }
}
