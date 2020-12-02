package com.liuencier.csp.core.component;

import com.google.common.collect.Lists;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-12 11:13
 **/
public class B extends A{
    public static void main(String[] args) {
        B b = new B();
        b.print();
        b.print(1);
        b.print(Lists.newArrayList());
    }
}
