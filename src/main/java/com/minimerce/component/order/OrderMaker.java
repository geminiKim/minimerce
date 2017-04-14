package com.minimerce.component.order;

import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderOption;
import com.minimerce.object.order.OrderRequest;
import com.minimerce.support.exception.UnsaleableProductException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderMaker {
    private final OrderOptionMaker orderDetailMaker;

    @Inject
    public OrderMaker(OrderOptionMaker orderDetailMaker) {
        this.orderDetailMaker = orderDetailMaker;
    }

    public Order make(Long clientId, OrderRequest request) throws UnsaleableProductException {
        List<OrderOption> options = orderDetailMaker.make(clientId, request.getCustomerId(), request.getDetails());
        if(request.getPrice() != getPrice(options)) throw new RuntimeException("상품의 가격이 일치하지 않습니다.");

        Order order = new Order();
        order.setClientId(clientId);
        order.setClientOrderId(request.getClientOrderId());
        order.setCustomerId(request.getCustomerId());
        order.setOrderedAt(request.getOrderedAt());
        order.setPrice(request.getPrice());
        order.setDealIds(buildDealIds(options));
        order.setTitle(buildTitle(options));
        order.addOptions(options);
        return order;
    }

    private int getPrice(List<OrderOption> details) {
        return details.stream().mapToInt(e -> e.getPrice()).sum();
    }

    private String buildTitle(List<OrderOption> details) {
        return null;
    }

    private String buildDealIds(List<OrderOption> details) {
        return null;
    }
}
