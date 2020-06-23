package com.liuencier.csp.web;

import com.liuencier.csp.domain.common.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: csp
 * @description: Demo Controller
 * @author: liuenci
 * @create: 2020-06-23 19:31
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/health")
    public CommonResult health(String id) {
        return CommonResult.success("心跳检测成功", id);
    }
}
