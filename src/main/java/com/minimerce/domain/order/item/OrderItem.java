package com.minimerce.domain.order.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import com.minimerce.domain.type.DealType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class OrderItem extends BaseDomain {
    @Column
    private Long clientId;
    @Column(length = 100)
    private String title;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealType type;
    @Column(nullable = false)
    private int salePrice;
    @Column(nullable = false)
    private int costPrice;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private CancelStatus cancelStatus;
    @Column(nullable = false)
    private int groupId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Order order;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public OrderDetail detail;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption dealOption;
}
