package com.liuencier.csp.core.component;

import java.util.List;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-12 11:11
 **/
public class A {

    private void print(String a){
        System.out.println("private");
    }

    protected void print(Integer a){
        System.out.println("protected");
    }

    static void print(List<String> a){
        System.out.println("private");
    }

    public void print(){
        System.out.println("private");
    }
}
