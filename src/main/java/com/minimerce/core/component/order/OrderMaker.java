package com.minimerce.core.component.order;

import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.object.order.OrderRequest;
import com.minimerce.core.support.object.response.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public Order make(Long clientId, OrderRequest request) {
        List<OrderOption> options = orderDetailMaker.make(clientId, request.getDetails());
        if(request.getPrice() != getPrice(options)) throw new MinimerceException(ErrorCode.NOT_EQUAL_ORDER_PRICE);

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
        return details.stream().mapToInt(e -> e.getSalePrice()).sum();
    }

    private String buildTitle(List<OrderOption> details) {
        if(details.size() == 1) return details.get(0).getTitle();
        else return details.get(0).getTitle() + " more " + (details.size() - 1) + " options";
    }

    private String buildDealIds(List<OrderOption> details) {
        return StringUtils.join(details.stream().map(e -> e.getDeal().getId()).collect(toList()));
    }
}
