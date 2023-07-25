package com.DEAiFISH.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//法一（常用）：
@SpringJUnitConfig(locations = "classpath:bean.xml")

//法二（不常用）：
/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean.xml")*/
public class SpringTestJunit5 {
    //注入
    @Autowired
    private User user;

    //测试方法
    @Test
    public void testUSer() {
        System.out.println(user);
        user.run();
    }
}
