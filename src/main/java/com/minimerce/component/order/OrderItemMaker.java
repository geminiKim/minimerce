package com.minimerce.component.order;

import com.google.common.collect.Lists;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.item.UsableItem;
import com.minimerce.domain.item.UsableItemRepository;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import com.minimerce.domain.type.DealType;
import com.minimerce.support.exception.UnsupportedItemTypeException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderItemMaker {
    private final UsableItemRepository usableOrderItemRepository;

    @Inject
    public OrderItemMaker(UsableItemRepository usableOrderItemRepository) {
        this.usableOrderItemRepository = usableOrderItemRepository;
    }

    public List<OrderItem> make(DealOption option) throws UnsupportedItemTypeException {
        if(DealType.USABLE == option.getType()) return buildUsableOrderItem(option);
        throw new UnsupportedItemTypeException("지원하지 않는 상품 타입입니다.");
    }

    private List<OrderItem> buildUsableOrderItem(DealOption option) {
        List<OrderItem> items = Lists.newArrayList();
        for (UsableItem usableItem : usableOrderItemRepository.findByIdIn(option.getItemIds())) {
            OrderItem item = new OrderItem();
            item.setTitle(usableItem.getName());
            item.setType(DealType.USABLE);
            item.setSalePrice(usableItem.getSalePrice());
            item.setCostPrice(usableItem.getCostPrice());
            item.setStatus(OrderStatus.ORDERED);
            item.setCancelStatus(CancelStatus.NOT_CANCEL);
            items.add(item);
        }
        return items;
    }
}
