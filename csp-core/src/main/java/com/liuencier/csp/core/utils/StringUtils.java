package com.liuencier.csp.core.utils;

/**
 * @program: csp
 * @description: 字符串工具类
 * @author: liuenci
 * @create: 2020-07-23 20:00
 **/
public class StringUtils {

    public static String upperCase(String str) {
        return str == null ? null : str.toUpperCase();
    }

    public static String lowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }
}
