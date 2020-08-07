package com.liuencier.csp.core.utils;

import org.springframework.stereotype.Component;

/**
 * @program: csp
 * @description: 订单ID生成器
 * @author: liuenci
 * @create: 2020-08-07 17:15
 **/
@Component
public class OrderIdGenrator {

    public String generate() {
        return UuidGenerator.newUuid();
    }
}
