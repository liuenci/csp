package com.liuencier.csp.config;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * @program: csp
 * @description: mongo配置类
 * @author: liuenci
 * @create: 2020-06-28 20:07
 **/
@Configuration
@ConditionalOnProperty(value = "spring.data.mongodb.enabled", havingValue = "true")
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoURI;

    @Value("${mongodb.conf.maxWaitTime}")
    private int maxWaitTime;

    @Value("${mongodb.conf.connectTimeout}")
    private int connectTimeout;

    @Value("${mongodb.conf.connectionsPerHost}")
    private int connectionsPerHost;

    @Value("${mongodb.conf.socketTimeout}")
    private int socketTimeout;

    @Bean
    public MongoTemplate mongoTemplate(SimpleMongoDbFactory simpleMongoDbFactory) {
        MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
        return mongoTemplate;
    }

    @Bean
    public SimpleMongoDbFactory simpleMongoDbFactory() throws UnknownHostException {
        MongoClientOptions.Builder mongoBuilder = new MongoClientOptions.Builder();
        mongoBuilder.maxWaitTime(maxWaitTime);
        mongoBuilder.connectTimeout(connectTimeout);
        mongoBuilder.connectionsPerHost(connectionsPerHost);
        mongoBuilder.socketTimeout(socketTimeout);
        mongoBuilder.threadsAllowedToBlockForConnectionMultiplier(11);
        mongoBuilder.writeConcern(WriteConcern.JOURNALED);
        //mongoBuilder.readPreference(ReadPreference.secondary());
        MongoClientURI mongoClientURI = new MongoClientURI(
                mongoURI, mongoBuilder);
        SimpleMongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClientURI);;
        return mongoDbFactory;
    }
}
