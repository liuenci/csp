package com.liuencier.csp.core.common;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @program: csp
 * @description: 公共属性
 * @author: liuenci
 * @create: 2020-06-29 11:57
 **/
@Data
public class CommonProperty {
    private String createUserId;
    private String createUserName;
    private String createDate;
    private String updateUserId;
    private String updateUserName;
    private String updateDate;
}
