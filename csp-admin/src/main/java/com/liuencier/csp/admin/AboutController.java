package com.liuencier.csp.admin;

import com.liuencier.csp.admin.vo.AboutRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 22:07
 **/
@RestController
@RequestMapping(value = "/about")
public class AboutController {
    private ZonedDateTime deployTime = ZonedDateTime.now();
    @Autowired
    private Environment environment;

    @GetMapping
    public AboutRepresentation about() {
        String buildNumber = environment.getProperty("buildNumber");
        String buildTime = environment.getProperty("buildTime");
        String gitRevision = environment.getProperty("gitRevision");
        String gitBranch = environment.getProperty("gitBranch");
        String appName = environment.getProperty("appName");

        String activeProfiles = Arrays.toString(environment.getActiveProfiles());
        String depolyTime = this.deployTime.toString();
        return new AboutRepresentation(appName,
                buildNumber,
                buildTime,
                depolyTime,
                gitRevision,
                gitBranch,
                activeProfiles);
    }
}
