package com.minimerce.component.order;

import com.google.common.collect.Lists;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealRepository;
import com.minimerce.domain.deal.DealStatus;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.DealOptionRepository;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import com.minimerce.object.order.OrderRequestDetail;
import com.minimerce.util.Yn;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderDetailMaker {
    private final DealRepository dealRepository;
    private final DealOptionRepository dealOptionRepository;
    private final OrderItemMaker orderItemMaker;

    public OrderDetailMaker(DealRepository dealRepository, DealOptionRepository dealOptionRepository, OrderItemMaker orderItemMaker) {
        this.dealRepository = dealRepository;
        this.dealOptionRepository = dealOptionRepository;
        this.orderItemMaker = orderItemMaker;
    }


    public List<OrderDetail> make(Long clientId, Long customerId, List<OrderRequestDetail> requestDetails) {
        List<OrderDetail> details = Lists.newArrayList();
        for(OrderRequestDetail each : requestDetails) {
            Deal deal = dealRepository.findByClientIdAndId(clientId, each.getOptionId());
            DealOption option = dealOptionRepository.findByClientIdAndId(clientId, each.getOptionId());
            if(null == option) continue;
            if(DealStatus.SALE != option.getStatus()) throw new RuntimeException("판매 금지 상품입니다.");
            if(Yn.N != option.getDisplay()) throw new RuntimeException("노출 안함 상품입니다.");
            if(each.getPrice() != option.getSalePrice() * each.getQuantity()) throw new RuntimeException("가격 불일치");

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
        }
        return details;
    }
}
