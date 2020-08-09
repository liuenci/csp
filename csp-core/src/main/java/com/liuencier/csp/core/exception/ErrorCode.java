package com.liuencier.csp.core.exception;

public interface ErrorCode {
    int getStatus();
    String getMessage();
    String getCode();
}
