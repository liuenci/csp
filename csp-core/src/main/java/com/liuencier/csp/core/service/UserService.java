package com.liuencier.csp.core.service;

import com.liuencier.csp.core.entity.User;

public interface UserService {

    User save(User user);

    User transSave(User user);

    User find(Long userId);
}
