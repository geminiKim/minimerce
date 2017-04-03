package com.minimerce.component.order;

import com.minimerce.component.order.item.OptionItemReader;
import com.minimerce.domain.deal.option.DealOptionRepository;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.OrderRepository;
import com.minimerce.domain.order.detail.OrderDetail;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderMaker {
    private final OrderRepository mockOrderRepository;
    private final DealOptionRepository mockDealOptionRepository;
    private final OptionItemReader optionItemReader;

    @Inject
    public OrderMaker(OrderRepository mockOrderRepository, DealOptionRepository mockDealOptionRepository, OptionItemReader optionItemReader) {
        this.mockOrderRepository = mockOrderRepository;
        this.mockDealOptionRepository = mockDealOptionRepository;
        this.optionItemReader = optionItemReader;
    }

    public Order make(OrderRequest request) {
        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setTotalAmount(request.getTotalAmount());

        for(OrderRequestDetail each request.getDetails()) {
            OrderDetail detail = new OrderDetail();
            detail.set
        }
        return null;
    }
}
