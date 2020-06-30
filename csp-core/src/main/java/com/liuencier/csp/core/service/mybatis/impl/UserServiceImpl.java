package com.liuencier.csp.core.service.mybatis.impl;

import com.liuencier.csp.core.entity.mybatis.User;
import com.liuencier.csp.core.mappers.UserMapper;
import com.liuencier.csp.core.service.mybatis.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: csp
 * @description: mybatis user 服务
 * @author: liuenci
 * @create: 2020-06-29 19:26
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User user) {
        userMapper.insert(user);
        return user;
    }
}
