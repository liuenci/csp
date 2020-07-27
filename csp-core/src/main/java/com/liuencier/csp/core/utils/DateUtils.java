package com.liuencier.csp.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: csp
 * @description: 日期处理工具类
 * @author: liuenci
 * @create: 2020-06-24 10:11
 **/
public class DateUtils {


    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date, String pattern) {

        if (date == null) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static String now() {
        return format(new Date(), DEFAULT_PATTERN);
    }
}
