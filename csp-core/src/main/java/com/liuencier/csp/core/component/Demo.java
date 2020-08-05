package com.liuencier.csp.core.component;

import java.math.BigDecimal;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-07-31 10:38
 **/
public class Demo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("3");
        BigDecimal result = a.divide(b).setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println("result=" + result);
    }
}
