package com.minimerce.component.order;

import com.google.common.collect.Lists;
import com.minimerce.component.deal.SaleDealReader;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.detail.OrderOption;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import com.minimerce.object.order.OrderRequestDetail;
import com.minimerce.support.exception.UnsaleableProductException;
import com.minimerce.support.exception.UnsupportedItemTypeException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderOptionMaker {
    private final SaleDealReader saleDealReader;
    private final OrderItemMaker orderItemMaker;

    public OrderOptionMaker(SaleDealReader saleDealReader, OrderItemMaker orderItemMaker) {
        this.saleDealReader = saleDealReader;
        this.orderItemMaker = orderItemMaker;
    }


    public List<OrderOption> make(Long clientId, List<OrderRequestDetail> requestDetails) throws UnsaleableProductException, UnsupportedItemTypeException {
        List<OrderOption> details = Lists.newArrayList();
        for(OrderRequestDetail each : requestDetails) {
            Deal deal = saleDealReader.findBySaleDeal(clientId, each.getDealId());
            DealOption option = saleDealReader.findBySaleDealOption(clientId, each.getOptionId());
            if(option.getSalePrice() != each.getUnitPrice()) throw new UnsaleableProductException("단가 불일치");
            if(option.getSalePrice() * each.getQuantity() == each.getPrice()) throw new UnsaleableProductException("가격 불일치");

            for (int i = 0; i < each.getQuantity(); i++) {
                OrderOption detail = new OrderOption();
                detail.setTitle(option.getName());
                detail.setPrice(option.getSalePrice());
                detail.setStatus(OrderStatus.ORDERED);
                detail.setCancelStatus(CancelStatus.NOT_CANCEL);
                detail.setDeal(deal);
                detail.setDealOption(option);
                detail.addItems(orderItemMaker.make(option));
                details.add(detail);
            }
        }
        return details;
    }
}
