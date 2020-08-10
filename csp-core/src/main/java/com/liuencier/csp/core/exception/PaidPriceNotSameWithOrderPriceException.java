package com.liuencier.csp.core.exception;

import static com.google.common.collect.ImmutableMap.of;
import static com.liuencier.csp.core.exception.OrderErrorCode.PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE;

public class PaidPriceNotSameWithOrderPriceException extends AppException {
    public PaidPriceNotSameWithOrderPriceException(String id) {
        super(PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE, of("orderId", id));
    }
}
