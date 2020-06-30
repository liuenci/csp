package com.liuencier.csp.admin.mybatis;

import com.liuencier.csp.core.common.CommonResult;
import com.liuencier.csp.core.entity.mybatis.User;
import com.liuencier.csp.core.service.mybatis.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private IUserService iUserService;

    @PostMapping("/save")
    public CommonResult save(@RequestBody User user) {
        return CommonResult.success(iUserService.save(user));
    }

    @PostMapping("/trans/save")
    public CommonResult transSave(@RequestBody User user) {
        return CommonResult.success(iUserService.transSave(user));
    }
}
