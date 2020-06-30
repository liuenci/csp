package com.liuencier.csp.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: csp
 * @description: mybatis 配置
 * @author: liuenci
 * @create: 2020-06-30 11:35
 **/
@Configuration
@EnableTransactionManagement
@MapperScan({"com.liuencier.csp.core.mappers"})
public class MyBatisConfig {
}
