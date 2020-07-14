package com.liuencier.csp.core.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: csp
 * @description: Rabbit消费者
 * @author: liuenci
 * @create: 2020-07-14 19:58
 **/
@Slf4j
@Component
@RabbitListener(queues = "rabbit_queue_demo")
public class RabbitReciver {

    @RabbitHandler
    public void process(String msg) {
        log.info("Rabbit接收到消息:{}", msg);
    }
}
