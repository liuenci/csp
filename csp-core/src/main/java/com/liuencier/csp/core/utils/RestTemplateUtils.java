package com.liuencier.csp.core.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @program: csp
 * @description: RestTemplate工具类
 * @author: liuenci
 * @create: 2020-07-09 20:16
 **/
@Slf4j
public class RestTemplateUtils {

    private static String BEAN_NAME = "restTemplate";
    /**
     * @Description: 发送Post请求，获取String返回
     * @Author: liuenci
     * @Params: [url, requestBody]
     * @Date: 2020/3/4
     * @return: java.lang.String
     */
    public static String postForStringResponse(String url, String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = SpringUtils.getBean(BEAN_NAME, RestTemplate.class);
        String response = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
        return response;
    }

    /**
     * @Description: 发送Get请求携带参数，获取String返回
     * @Author: liuenci
     * @Params: [url, params]
     * @Date: 2020/4/24
     * @return: java.lang.String
     */
    public static String getForStringResponse(String url, Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(headers);
        RestTemplate restTemplate = SpringUtils.getBean(BEAN_NAME, RestTemplate.class);
        String response = restTemplate.exchange(url, HttpMethod.GET, request, String.class, params).getBody();
        return response;
    }

    /**
     * @Description: 发送Get请求，获取String返回
     * @Author: liuenci
     * @Params: [url]
     * @Date: 2020/4/24
     * @return: java.lang.String
     */
    public static String getForStringResponse(String url) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(headers);
        RestTemplate restTemplate = SpringUtils.getBean(BEAN_NAME, RestTemplate.class);
        String response = restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
        return response;
    }

    /**
     * @Description: 请求EBS通过form-data的形式
     * @Author: liuenci
     * @Params: [url, requestBody, token]
     * @Date: 2020/4/24
     * @return: java.lang.String
     */
    public static String postByFormData(String url, MultiValueMap<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        RestTemplate restTemplate = SpringUtils.getBean(BEAN_NAME, RestTemplate.class);
        String response = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
        return response;
    }
}
