package com.liuencier.csp.core.mq.Kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 23:16
 **/
@Data
@ConfigurationProperties("ecommerce.rabbit")
@Validated
public class EcommerceRabbitProperties {
    @NotBlank
    private String publishX;

    @NotBlank
    private String publishDlx;

    @NotBlank
    private String publishDlq;

    @NotBlank
    private String receiveQ;

    @NotBlank
    private String receiveDlx;

    @NotBlank
    private String receiveDlq;

    @NotBlank
    private String receiveRecoverX;

}
