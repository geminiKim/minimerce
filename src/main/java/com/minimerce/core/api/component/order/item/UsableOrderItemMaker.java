package com.minimerce.core.api.component.order.item;

import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.item.UsableItem;
import com.minimerce.core.api.domain.order.item.OrderItem;
import com.minimerce.core.api.domain.order.item.usable.UsableOrderItem;
import com.minimerce.core.api.support.object.order.CancelStatus;
import com.minimerce.core.api.support.object.order.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by gemini on 15/04/2017.
 */
@Component
public class UsableOrderItemMaker {
    public List<OrderItem> make(DealOption option) {
        return option.getOptionItems().stream()
                .map(item -> buildOrderItem((UsableItem)item))
                .collect(toList());
    }

    private OrderItem buildOrderItem(UsableItem item) {
        UsableOrderItem orderItem = new UsableOrderItem();
        orderItem.setTitle(item.getName());
        orderItem.setType(item.getType());
        orderItem.setSalePrice(item.getSalePrice());
        orderItem.setCostPrice(item.getCostPrice());
        orderItem.setStatus(OrderStatus.ORDERED);
        orderItem.setCancelStatus(CancelStatus.NOT_CANCEL);
        orderItem.setUsableCount(item.getUsableCount());
        orderItem.setUsedCount(0);
        orderItem.setAvailableStartAt(item.getAvailableStartAt());
        orderItem.setAvailableEndAt(item.getAvailableEndAt());
        orderItem.setItem(item);
        return orderItem;
    }
}
