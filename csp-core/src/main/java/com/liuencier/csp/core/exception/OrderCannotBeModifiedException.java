package com.liuencier.csp.core.exception;

import static com.google.common.collect.ImmutableMap.of;
import static com.liuencier.csp.core.exception.OrderErrorCode.ORDER_CANNOT_BE_MODIFIED;

public class OrderCannotBeModifiedException extends AppException {
    public OrderCannotBeModifiedException(String id) {
        super(ORDER_CANNOT_BE_MODIFIED, of("orderId", id));
    }
}
