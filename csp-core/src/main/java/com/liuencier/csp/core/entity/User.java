package com.liuencier.csp.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ApiModel(value="com-liuencier-csp-core-entity-mybatis-CspUser")
@Data
public class User implements Serializable {
    /**
    * 用户ID
    */
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value="用户ID")
    private Long userId;

    /**
    * 用户名称
    */
    @ApiModelProperty(value="用户名称")
    private String userName;

    private static final long serialVersionUID = 1L;
}