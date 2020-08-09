package com.liuencier.csp.admin.vo;

import lombok.Value;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 22:10
 **/
@Value
public class AboutRepresentation {
    private String appName;
    private String buildNumber;
    private String buildTime;
    private String deployTime;
    private String gitRevision;
    private String gitBranch;
    private String environment;
}
