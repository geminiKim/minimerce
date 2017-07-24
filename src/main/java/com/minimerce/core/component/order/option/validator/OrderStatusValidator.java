package com.minimerce.core.component.order.option.validator;

import com.minimerce.core.domain.order.option.OrderOption;

public interface OrderStatusValidator<OPTION extends OrderOption>  {
    void validate(OPTION option);
}
