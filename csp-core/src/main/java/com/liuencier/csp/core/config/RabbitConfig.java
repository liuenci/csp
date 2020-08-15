package com.liuencier.csp.core.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: csp
 * @description: Rabbit配置类
 * @author: liuenci
 * @create: 2020-07-14 19:51
 **/
//@Configuration
public class RabbitConfig {

    @Bean
    public Queue queueDemo() {
        return new Queue("rabbit_queue_demo");
    }
}
