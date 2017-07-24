package com.minimerce.core.component.order.option.validator;

import com.minimerce.core.domain.order.option.OrderOption;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 25/06/2017.
 */
@Component
public class OrderStatusValidator {
    private final OrderStatusValidatorFactory validatorFactory;

    @Inject
    public OrderStatusValidator(OrderStatusValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    public void validate(List<OrderOption> options) {
        for (OrderOption option : options) {
            validatorFactory.getValidator(option.getType()).validate(option);
        }
    }
}
