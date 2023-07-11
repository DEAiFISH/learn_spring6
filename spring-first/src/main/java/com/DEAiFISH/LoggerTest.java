package com.DEAiFISH;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    //创建Logger对象
    private Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){
        logger.info("### loggerTest");
    }
}
