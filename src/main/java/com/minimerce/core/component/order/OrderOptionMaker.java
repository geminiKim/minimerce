package com.minimerce.core.component.order;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.minimerce.core.component.deal.SaleDealReader;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.domain.order.item.OrderItem;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.object.order.CancelStatus;
import com.minimerce.core.support.object.order.OrderRequestDetail;
import com.minimerce.core.support.object.order.OrderStatus;
import com.minimerce.core.support.object.response.ErrorCode;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderOptionMaker {
    private final SaleDealReader saleDealReader;
    private final OrderItemMaker orderItemMaker;

    @Inject
    public OrderOptionMaker(SaleDealReader saleDealReader, OrderItemMaker orderItemMaker) {
        this.saleDealReader = saleDealReader;
        this.orderItemMaker = orderItemMaker;
    }

    public List<OrderOption> make(Long clientId, List<OrderRequestDetail> requestDetails) {
        List<OrderOption> orders = Lists.newArrayList();
        for(OrderRequestDetail each : requestDetails) {
            Deal deal = saleDealReader.findBySaleDeal(each.getDealId());
            DealOption option = saleDealReader.findBySaleDealOption(each.getOptionId());

            List<OrderItem> items = orderItemMaker.make(option);
            int unitPrice = buildUnitPrice(items);
            if(unitPrice != each.getUnitPrice()) throw new MinimerceException(ErrorCode.NOT_EQUAL_UNIT_PRICE);
            if(unitPrice * each.getQuantity() != each.getPrice()) throw new MinimerceException(ErrorCode.NOT_EQUAL_ORDER_PRICE);

            for (int i = 0; i < each.getQuantity(); i++) {
                OrderOption order = new OrderOption();
                order.setClientId(clientId);
                order.setTitle(option.getName());
                order.setStatus(OrderStatus.ORDERED);
                order.setCancelStatus(CancelStatus.NOT_CANCEL);
                order.setDeal(deal);
                order.setDealOption(option);
                order.setPrice(unitPrice);
                order.addItems(ImmutableList.copyOf(items));
                orders.add(order);
            }
        }
        return orders;
    }

    private int buildUnitPrice(List<OrderItem> items) {
        return items.stream().mapToInt(e -> e.getSalePrice()).sum();
    }
}
