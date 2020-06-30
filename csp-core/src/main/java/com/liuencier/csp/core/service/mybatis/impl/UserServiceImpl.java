package com.liuencier.csp.core.service.mybatis.impl;

import com.liuencier.csp.core.entity.mybatis.User;
import com.liuencier.csp.core.mappers.UserMapper;
import com.liuencier.csp.core.service.mybatis.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public User transSave(User user) {
        userMapper.insert(user);

        int i = 1 / 0;
        user.setUserId(3L);
        userMapper.insert(user);

        return user;
    }
}
