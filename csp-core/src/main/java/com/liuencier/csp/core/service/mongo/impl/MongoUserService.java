package com.liuencier.csp.core.service.mongo.impl;

import com.liuencier.csp.core.entity.mongo.User;
import com.liuencier.csp.core.service.mongo.IMongoUserService;
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

    @Override
//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public User transSave(User user) {
        mongoTemplate.save(user);

        int i = 1 / 0;
        user.setUserName("测试名称2");

        return mongoTemplate.save(user);
    }
}
