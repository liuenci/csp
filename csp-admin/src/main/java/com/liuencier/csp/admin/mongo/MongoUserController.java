package com.liuencier.csp.admin.mongo;

import com.liuencier.csp.core.common.CommonResult;
import com.liuencier.csp.core.entity.mongo.User;
import com.liuencier.csp.core.service.mongo.IMongoUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: csp
 * @description: 用户控制器
 * @author: liuenci
 * @create: 2020-06-29 09:33
 **/
@Api("mongo user 控制器")
@RestController
@RequestMapping("mongo/user")
public class MongoUserController {
    @Autowired
    private IMongoUserService mongoUserService;

    @ApiOperation(value = "保存用户", notes = "保存用户-测试自动事务")
    @PostMapping("/save")
    public CommonResult save(@RequestBody User user) {
        return CommonResult.success(mongoUserService.save(user));
    }

    @ApiOperation("通过用户ID查询用户")
    @GetMapping("/find/{userId}")
    public CommonResult find(@PathVariable("userId") String userId) {
        return CommonResult.success(mongoUserService.findOne(userId));
    }

    @ApiOperation(value = "保存用户", notes = "保存用户-测试切面事务")
    @PostMapping("/trans/save")
    public CommonResult transSave(@RequestBody User user) {
        return CommonResult.success(mongoUserService.transSave(user));
    }
}
