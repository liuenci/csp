package com.liuencier.csp.core.utils;

import java.util.UUID;

/**
 * @program: csp
 * @description: Id生成器
 * @author: liuenci
 * @create: 2020-07-02 16:50
 **/
public class IdWorker {

    private static Sequence worker = new Sequence();

    public static long getId() {
        return worker.nextId();
    }

    public static synchronized String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
