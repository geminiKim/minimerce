package com.minimerce.core.component.order;

import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.deal.type.ProductType;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 25/06/2017.
 */
@Component
public class OrderStatusValidator {
    private final UsableOrderStatusValidator usableOrderStatusValidator;

    @Inject
    public OrderStatusValidator(UsableOrderStatusValidator usableOrderStatusValidator) {
        this.usableOrderStatusValidator = usableOrderStatusValidator;
    }

    public void validate(List<OrderOption> options) {
        for (OrderOption option : options) {
            if(ProductType.USABLE == option.getType()) usableOrderStatusValidator.validate(option);
        }
    }
}
