package com.liuencier.csp.core.entity.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @program: csp
 * @description: 用户类
 * @author: liuenci
 * @create: 2020-06-29 09:24
 **/
@Data
@Document("mongo_user")
public class User implements Serializable {
    @Id
    private String userId;

    @Field("user_name")
    private String userName;
}
