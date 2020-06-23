package com.liuencier.csp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: csp
 * @description: Csp启动类
 * @author: liuenci
 * @create: 2020-06-23 19:03
 **/
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.liuencier.csp"})
public class CspApplitionStarter {

    public static void main(String[] args) {
        SpringApplication.run(CspApplitionStarter.class, args);
        log.info("Csp 启动成功...");
    }
}
