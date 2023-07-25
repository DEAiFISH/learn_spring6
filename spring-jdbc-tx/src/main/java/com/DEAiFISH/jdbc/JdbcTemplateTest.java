package com.DEAiFISH.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询：返回对象
    @Test
    public void testSelectObject() {
        String sql = "select * from t_emp where id = ?";
        Emp emp;

        /*//写法一：
        emp = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Emp(
                Integer.parseInt(rs.getString("id")),
                rs.getString("name"),
                Integer.parseInt(rs.getString("age")),
                rs.getString("sex")), 1);
        System.out.println(emp);*/

        //写法二：
        emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp);
    }

    //查询：返回List集合
    @Test
    public void testSelectList() {
        String sql = "select * from t_emp;";
        List<Emp> list;
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));

        System.out.println(list);

    }

    //查询：返回单个值
    @Test
    public void testSelectValue() {
        String sql = "select count(*) from t_emp";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

        System.out.println(count);
    }


    //添加 修改 删除操作
    @Test
    public void testUpdate() {
        /*//1 添加操作
        //第一步 编写sql语句
        String  sql = "insert into t_emp values(null,?,?,?)";
        //第二步 调用jdbcTemplate的方法，传入相关参数
        int rows = jdbcTemplate.update(sql, "林平之", 20, "??");
        System.out.println(rows);*/

        //2 修改操作
        //第一步 编写sql语句
        String sql = "update t_emp set name = ? where id = ?";
        //第二步 调用jdbcTemplate的方法，传入相关参数
        int rows = jdbcTemplate.update(sql, "林平之cxx", 3);
        System.out.println(rows);
    }

    @Test
    public void testDelete() {
        //2 删除操作
        //第一步 编写sql语句
        String sql = "delete from t_emp where id = ?";
        //第二步 调用jdbcTemplate的方法，传入相关参数
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println(rows);
    }
}
