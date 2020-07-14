package com.liuencier.csp.test;

import com.liuencier.csp.core.mq.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: csp
 * @description: Rabbit测试类
 * @author: liuenci
 * @create: 2020-07-14 20:16
 **/
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CspApplicationTest.class)
public class RabbitTest {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void testRabbitSender() {
        rabbitSender.send();
    }
}
