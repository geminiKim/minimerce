package com.minimerce.core.component.order.option.validator;

import com.minimerce.core.object.deal.type.ProductType;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class OrderStatusValidatorFactory {
    private final UsableOrderStatusValidator usableOrderStatusValidator;
    private final DeliveryOrderStatusValidator deliveryOrderStatusValidator;

    @Inject
    public OrderStatusValidatorFactory(UsableOrderStatusValidator usableOrderStatusValidator, DeliveryOrderStatusValidator deliveryOrderStatusValidator) {
        this.usableOrderStatusValidator = usableOrderStatusValidator;
        this.deliveryOrderStatusValidator = deliveryOrderStatusValidator;
    }

    public OrderStatusValidatorComponent getValidator(ProductType type) {
        if(ProductType.USABLE == type) return usableOrderStatusValidator;
        if(ProductType.DELIVERY == type) return deliveryOrderStatusValidator;
        throw new MinimerceException(ErrorCode.NOT_SUPPORTED_PRODUCT_TYPE);
    }
}
