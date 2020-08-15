package com.liuencier.csp.core.exception;

import com.google.common.collect.Maps;

import java.util.Map;

import static org.apache.commons.collections4.MapUtils.isEmpty;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-08-08 23:27
 **/
public abstract class AppException extends RuntimeException {
    private final ErrorCode error;
    private final Map<String, Object> data = Maps.newHashMap();

    protected AppException(ErrorCode error, Map<String, Object> data) {
        super(format(error.getCode(), error.getMessage(), data));
        this.error = error;
        if (!isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    private static String format(String code, String message, Map<String, Object> data) {
        return String.format("[%s]%s:%s.", code, message, isEmpty(data) ? "" : data.toString());
    }

    public ErrorCode getError() {
        return error;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
