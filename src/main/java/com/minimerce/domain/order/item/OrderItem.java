package com.minimerce.domain.order.item;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.order.option.OrderOption;
import com.minimerce.object.order.CancelStatus;
import com.minimerce.object.order.OrderStatus;
import com.minimerce.object.type.DealType;
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

    @ManyToOne(fetch = FetchType.LAZY)
    public OrderOption option;
}
