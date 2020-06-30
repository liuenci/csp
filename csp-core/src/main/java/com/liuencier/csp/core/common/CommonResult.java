package com.liuencier.csp.core.common;

import lombok.Data;

import java.io.Serializable;

import static com.liuencier.csp.core.constants.CommonConst.CODE_SUCCESS;

/**
 * @program: csp
 * @description: 公用返回类
 * @author: liuenci
 * @create: 2020-06-23 19:35
 **/
@Data
public final class CommonResult<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = CODE_SUCCESS;
        result.data = data;
        return result;
    }

    public static <T> CommonResult<T> success(String msg, T data) {
        CommonResult<T> result = success(data);
        result.msg = msg;
        return result;
    }

    public static <T> CommonResult<T> error(String code, String msg) {
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = msg;
        return result;
    }
}
