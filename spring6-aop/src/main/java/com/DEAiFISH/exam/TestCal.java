package com.DEAiFISH.exam;

import org.junit.jupiter.api.Test;

public class TestCal {
    @Test
    public void testDynamicProxy(){
        ProxyFactory factory = new ProxyFactory(new CalculatorLogImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.div(0,1);
        //proxy.div(1,1);
    }
}
