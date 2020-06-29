package com.liuencier.csp.service.impl;

import com.liuencier.csp.mongo.User;
import com.liuencier.csp.service.IMongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @program: csp
 * @description: mongo用户服务
 * @author: liuenci
 * @create: 2020-06-29 09:31
 **/
@Service
public class MongoUserService implements IMongoUserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User save(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public User findOne(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }
}
