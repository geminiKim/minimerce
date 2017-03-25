package com.minimerce.domain.order.detail;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class OrderDetail extends BaseDomain {

    @Column
    private Long clientId;
    @Column
    private Long customerId;
    @Column(length = 100)
    private String title;
    @Column
    private Integer price;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column
    @Enumerated(EnumType.STRING)
    private CancelStatus cancelStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    public Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption dealOption;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<OrderItem> orderDetails = Lists.newArrayList();
}
