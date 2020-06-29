package com.liuencier.csp.admin.mongo;

import com.liuencier.csp.common.CommonResult;
import com.liuencier.csp.mongo.User;
import com.liuencier.csp.service.IMongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: csp
 * @description: 用户控制器
 * @author: liuenci
 * @create: 2020-06-29 09:33
 **/
@RestController
@RequestMapping("mongo/user")
public class UserController {
    @Autowired
    private IMongoUserService mongoUserService;

    @PostMapping("/save")
    public CommonResult save(@RequestBody User user) {
        return CommonResult.success(mongoUserService.save(user));
    }

    @GetMapping("/find/{userId}")
    public CommonResult find(@PathVariable("userId") String userId) {
        return CommonResult.success(mongoUserService.findOne(userId));
    }
}
