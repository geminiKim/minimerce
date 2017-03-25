package com.minimerce.domain.order.item;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.item.DealOptionItem;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class OrderItem extends BaseDomain {

    @Column
    private Long clientId;
    @Column
    private Long customerId;
    @Column(length = 100)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    public Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    public OrderDetail orderDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption dealOption;

    @ManyToOne(fetch = FetchType.LAZY)
    public DealOptionItem dealOptionItem;
}
