package com.minimerce.domain.order.item;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import com.minimerce.domain.type.DealType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
    @Column
    private Long detailId;
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
}
