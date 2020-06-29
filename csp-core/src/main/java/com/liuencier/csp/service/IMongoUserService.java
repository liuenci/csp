package com.liuencier.csp.service;

import com.liuencier.csp.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface IMongoUserService {

    User save(User user);

    User findOne(String userId);

}
