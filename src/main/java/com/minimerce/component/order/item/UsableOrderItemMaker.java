package com.minimerce.component.order.item;

import com.google.common.collect.Lists;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.item.UsableItem;
import com.minimerce.domain.item.UsableItemRepository;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.domain.order.item.usable.UsableOrderItem;
import com.minimerce.domain.order.item.usable.UsableOrderItemRepository;
import com.minimerce.object.order.CancelStatus;
import com.minimerce.object.order.OrderStatus;
import com.minimerce.object.type.DealType;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 15/04/2017.
 */
@Component
public class UsableOrderItemMaker {
    private final UsableItemRepository usableItemRepository;
    private final UsableOrderItemRepository usableOrderItemRepository;

    @Inject
    public UsableOrderItemMaker(UsableItemRepository usableItemRepository, UsableOrderItemRepository usableOrderItemRepository) {
        this.usableItemRepository = usableItemRepository;
        this.usableOrderItemRepository = usableOrderItemRepository;
    }

    public List<OrderItem> make(DealOption option) {
        List<OrderItem> items = Lists.newArrayList();
        for (UsableItem usableItem : usableItemRepository.findByIdIn(option.getItemIds())) {
            OrderItem item = new OrderItem();
            item.setTitle(usableItem.getName());
            item.setType(DealType.USABLE);
            item.setSalePrice(usableItem.getSalePrice());
            item.setCostPrice(usableItem.getCostPrice());
            item.setStatus(OrderStatus.ORDERED);
            item.setCancelStatus(CancelStatus.NOT_CANCEL);
            items.add(item);

            UsableOrderItem usableOrderItem = new UsableOrderItem();
            usableOrderItem.setUsableCount(usableItem.getUsableCount());
            usableOrderItem.setUsedCount(0);
            usableOrderItem.setAvailableStartAt(usableItem.getAvailableStartAt());
            usableOrderItem.setAvailableEndAt(usableItem.getAvailableEndAt());
            usableOrderItem.setItem(usableItem);
            usableOrderItem.setOrderItem(item);
            usableOrderItemRepository.save(usableOrderItem);
        }
        return items;
    }
}
