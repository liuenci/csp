package com.liuencier.csp.core.entity.mybatis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

@ApiModel(value="com-liuencier-csp-core-entity-mybatis-CspUser")
@Data
public class User implements Serializable {
    /**
    * 用户ID
    */
    @Id
    @ApiModelProperty(value="用户ID")
    private Long userId;

    /**
    * 用户名称
    */
    @ApiModelProperty(value="用户名称")
    private String userName;

    private static final long serialVersionUID = 1L;
}