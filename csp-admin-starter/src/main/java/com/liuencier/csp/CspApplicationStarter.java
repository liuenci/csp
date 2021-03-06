package com.liuencier.csp;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: csp
 * @description: Csp启动类
 * @author: liuenci
 * @create: 2020-06-23 19:03
 **/
@Slf4j
@SpringBootApplication(scanBasePackages = "com.liuencier.csp")
public class CspApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(CspApplicationStarter.class, args);
        log.info("csp 启动成功...");
    }
}
