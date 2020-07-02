package com.liuencier.csp.admin.mybatis;

import com.liuencier.csp.core.common.CommonResult;
import com.liuencier.csp.core.entity.User;
import com.liuencier.csp.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: csp
 * @description: mybatis user 控制器
 * @author: liuenci
 * @create: 2020-06-29 19:30
 **/
@RestController
@RequestMapping("/mybatis/user")
public class MybatisUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public CommonResult save(@RequestBody User user) {
        return CommonResult.success(userService.save(user));
    }

    @PostMapping("/trans/save")
    public CommonResult transSave(@RequestBody User user) {
        return CommonResult.success(userService.transSave(user));
    }

    @GetMapping("/find/{userId}")
    public CommonResult find(@PathVariable("userId") Long userId) {
        return CommonResult.success(userService.find(userId));
    }
}
