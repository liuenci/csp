package com.liuencier.csp.core.exception;

import static com.google.common.collect.ImmutableMap.of;
import static com.liuencier.csp.core.exception.OrderErrorCode.ORDER_NOT_FOUND;

public class OrderNotFoundException extends AppException {
    public OrderNotFoundException(String orderId) {
        super(ORDER_NOT_FOUND, of("orderId", orderId));
    }
}
