package com.liuencier.csp.admin.demo;

import com.liuencier.csp.core.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Value("${profiles}")
    private String profie;

    @GetMapping("/health/{id}")
    public CommonResult health(@PathVariable("id") String id) {
        log.info("心跳检测中,ID={}", id);
        return CommonResult.success("心跳检测成功", id);
    }

    @GetMapping("/profie")
    public CommonResult profie() {
        return CommonResult.success(profie);
    }
}
