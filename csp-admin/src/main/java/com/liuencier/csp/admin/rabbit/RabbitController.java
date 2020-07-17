package com.liuencier.csp.admin.rabbit;

import com.liuencier.csp.core.common.CommonResult;
import com.liuencier.csp.core.mq.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: csp
 * @description: Rabbit控制器
 * @author: liuenci
 * @create: 2020-07-15 20:37
 **/
@RestController
@RequestMapping("/rabbit/")
public class RabbitController {

    @Autowired
    private RabbitSender rabbitSender;

    @RequestMapping("send")
    public CommonResult send() {
        rabbitSender.send();
        return CommonResult.success("发送成功");
    }
}
