package com.liuencier.csp.core.service.impl;

import com.liuencier.csp.core.entity.User;
import com.liuencier.csp.core.mappers.UserMapper;
import com.liuencier.csp.core.service.UserService;
import com.liuencier.csp.core.utils.IdWorker;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User user) {
        if (user.getUserId() == null) {
            user.setUserId(IdWorker.getId());
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKey(user);
        }
        return user;
    }

    @Override
    public User transSave(User user) {
        userMapper.insert(user);

        int i = 1 / 0;
        user.setUserId(3L);
        userMapper.insert(user);

        return user;
    }

    @Override
    public User find(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
