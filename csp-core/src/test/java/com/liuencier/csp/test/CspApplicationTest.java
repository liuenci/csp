package com.liuencier.csp.test;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: csp
 * @description: 测试启动类
 * @author: liuenci
 * @create: 2020-07-14 20:28
 **/
//@ActiveProfiles("dev")
//@RunWith(SpringRunner.class)
//@EnableTransactionManagement
//@SpringBootApplication(scanBasePackages = "com.liuencier.csp.core", exclude = {
//        DataSourceAutoConfiguration.class
//})
public class CspApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(CspApplicationTest.class, args);
    }
}
