package com.liuencier.csp.core.mq;

import cn.hutool.core.date.DateUtil;
import com.liuencier.csp.core.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: csp
 * @description: Rabbit发送者
 * @author: liuenci
 * @create: 2020-07-14 19:56
 **/
@Slf4j
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + DateUtils.format(new Date(), DateUtils.DEFAULT_PATTERN);
        log.info("Sender : {}", context);
        amqpTemplate.convertAndSend("rabbit_queue_demo", context);
    }
}
