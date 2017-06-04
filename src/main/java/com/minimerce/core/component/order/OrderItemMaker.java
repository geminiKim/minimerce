package com.minimerce.core.component.order;

import com.minimerce.core.component.order.item.UsableOrderItemMaker;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.domain.order.item.OrderItem;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.object.response.ErrorCode;
import com.minimerce.core.support.object.type.ProductType;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderItemMaker {
    private final UsableOrderItemMaker usableOrderItemMaker;

    @Inject
    public OrderItemMaker(UsableOrderItemMaker usableOrderItemMaker) {
        this.usableOrderItemMaker = usableOrderItemMaker;
    }

    public List<OrderItem> make(DealOption option) {
        if(ProductType.USABLE == option.getType()) return usableOrderItemMaker.make(option);
        throw new MinimerceException(ErrorCode.NOT_SUPPORTED_PRODUCT_TYPE);
    }
}
