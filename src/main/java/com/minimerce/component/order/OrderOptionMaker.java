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


    public List<OrderOption> make(Long clientId, Long customerId, List<OrderRequestDetail> requestDetails) throws UnsaleableProductException {
        List<OrderOption> details = Lists.newArrayList();
        for(OrderRequestDetail each : requestDetails) {
            for (int i = 0; i < each.getQuantity(); i++) {
                Deal deal = saleDealReader.findBySaleDeal(clientId, each.getDealId());
                DealOption option = saleDealReader.findBySaleDealOption(clientId, each.getOptionId());
                if(option.getSalePrice() != each.getUnitPrice()) throw new UnsaleableProductException("단가 불일치");
                if(option.getSalePrice() * each.getQuantity() == each.getPrice()) throw new UnsaleableProductException("가격 불일치");

                OrderOption detail = new OrderOption();
                detail.setClientId(clientId);
                detail.setCustomerId(customerId);
                detail.setClientDetailId(each.getClientDetailId());
                detail.setTitle(option.getName());
                detail.setPrice(option.getSalePrice());
                detail.setStatus(OrderStatus.NONE);
                detail.setCancelStatus(CancelStatus.NONE);
                detail.setDeal(deal);
                detail.setDealOption(option);
                detail.addItems(orderItemMaker.make(option));
                details.add(detail);
            }
        }
        return details;
    }
}
