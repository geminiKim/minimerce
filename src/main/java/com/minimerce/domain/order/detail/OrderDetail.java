package com.minimerce.domain.order.detail;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.Order;
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
public class OrderDetail extends BaseDomain {

    @Column
    private Long clientId;
    @Column
    private Long clientDetailId;
    @Column
    private Long customerId;
    @Column(length = 100)
    private String title;
    @Column(nullable = false)
    private int price;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private CancelStatus cancelStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    public Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption dealOption;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealType type;
}
