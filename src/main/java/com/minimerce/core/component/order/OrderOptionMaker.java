package com.minimerce.core.component.order;

import com.google.common.collect.Lists;
import com.minimerce.core.component.deal.SaleDealReader;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.support.object.order.CancelStatus;
import com.minimerce.core.support.object.order.OrderRequestDetail;
import com.minimerce.core.support.object.order.OrderStatus;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderOptionMaker {
    private final SaleDealReader saleDealReader;

    @Inject
    public OrderOptionMaker(SaleDealReader saleDealReader) {
        this.saleDealReader = saleDealReader;
    }

    public List<OrderOption> make(Long clientId, List<OrderRequestDetail> requestDetails) {
        List<OrderOption> orders = Lists.newArrayList();
        for(OrderRequestDetail each : requestDetails) {
            Deal deal = saleDealReader.findBySaleDeal(each.getDealId());
            Option option = saleDealReader.findBySaleOption(each.getOptionId());

//            List<OrderItem> items = orderItemMaker.make(option);
//            int unitPrice = buildUnitPrice(items);
//            if(unitPrice != each.getUnitPrice()) throw new MinimerceException(ErrorCode.NOT_EQUAL_UNIT_PRICE);
//            if(unitPrice * each.getQuantity() != each.getPrice()) throw new MinimerceException(ErrorCode.NOT_EQUAL_ORDER_PRICE);

            for (int i = 0; i < each.getQuantity(); i++) {
                OrderOption order = new OrderOption();
                order.setClientId(clientId);
                order.setTitle(option.getName());
                order.setStatus(OrderStatus.ORDERED);
                order.setCancelStatus(CancelStatus.NOT_CANCEL);
                order.setDeal(deal);
//                order.setPrice(option.getOptionItems().stream().mapToInt(e -> e.getSalePrice()));
//                order.addItems(ImmutableList.copyOf(items));
                orders.add(order);
            }
        }
        return orders;
    }
}
