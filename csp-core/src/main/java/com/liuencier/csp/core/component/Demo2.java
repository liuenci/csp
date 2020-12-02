package com.liuencier.csp.core.component;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-04 17:37
 **/
public class Demo2 {


    public static void main(String[] argv) {
//        String replace = s.replaceAll("\"", "'").replaceAll("/", "").replaceAll("’","");
        String s = "{\"reason_desc\": \"中文双引号“英文双引号\\\"中文单引号‘英文单引号'\"}";
        String replace = s.replaceAll("/", "").replaceAll("’","");
        Object parse = JSON.parseObject(replace);
        System.out.println("end");

        User user = new User();
        user.setName("测试\"测试");
        String s1 = JSON.toJSONString(user);
        System.out.println(s1);
    }
}
