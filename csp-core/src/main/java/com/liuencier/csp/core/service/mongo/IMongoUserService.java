package com.liuencier.csp.core.service.mongo;

import com.liuencier.csp.core.entity.mongo.User;

public interface IMongoUserService {

    User save(User user);

    User findOne(String userId);

    User transSave(User user);

}
