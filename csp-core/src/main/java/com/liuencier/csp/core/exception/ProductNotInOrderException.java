package com.liuencier.csp.core.exception;

import static com.google.common.collect.ImmutableMap.of;
import static com.liuencier.csp.core.exception.OrderErrorCode.PRODUCT_NOT_IN_ORDER;

public class ProductNotInOrderException extends AppException {
    public ProductNotInOrderException(String productId, String orderId) {
        super(PRODUCT_NOT_IN_ORDER, of("productId", productId,
                "orderId", orderId));
    }
}
