package com.minimerce.component.order;

import com.google.common.collect.Lists;
import com.minimerce.component.deal.SaleDealReader;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.detail.OrderDetail;
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
public class OrderDetailMaker {
    private final SaleDealReader saleDealReader;
    private final OrderItemMaker orderItemMaker;

    public OrderDetailMaker(SaleDealReader saleDealReader, OrderItemMaker orderItemMaker) {
        this.saleDealReader = saleDealReader;
        this.orderItemMaker = orderItemMaker;
    }


    public List<OrderDetail> make(Long clientId, Long customerId, List<OrderRequestDetail> requestDetails) throws UnsaleableProductException {
        List<OrderDetail> details = Lists.newArrayList();
        for(OrderRequestDetail each : requestDetails) {
            Deal deal = saleDealReader.findBySaleDeal(clientId, each.getDealId());
            DealOption option = saleDealReader.findBySaleDealOption(clientId, each.getOptionId());
            if(false == option.compareSalePrice(each.getPrice())) throw new UnsaleableProductException("가격 불일치");

            OrderDetail detail = new OrderDetail();
            detail.setClientId(clientId);
            detail.setCustomerId(customerId);
            detail.setClientDetailId(each.getClientDetailId());
            detail.setTitle(option.getName());
            detail.setUnitPrice(option.getSalePrice());
            detail.setQuantity(each.getQuantity());
            detail.setPrice(detail.getUnitPrice() * detail.getQuantity());
            detail.setCancelableQuantity(each.getQuantity());
            detail.setStatus(OrderStatus.NONE);
            detail.setCancelStatus(CancelStatus.NONE);
            detail.setType(option.getType());
            detail.setDeal(deal);
            detail.setDealOption(option);
            detail.addItems(orderItemMaker.make(option));
            details.add(detail);
        }
        return details;
    }
}