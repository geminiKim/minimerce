package com.minimerce.core.domain.order.option;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.domain.BaseDomain;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.support.object.order.CancelStatus;
import com.minimerce.core.support.object.order.OrderStatus;
import com.minimerce.core.support.object.type.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorColumn(name = "type")
public class OrderOption extends BaseDomain {
    @Column
    private Long clientId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Order order;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Option option;
    @Column
    private String title;
    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column
    @Enumerated(EnumType.STRING)
    private CancelStatus cancelStatus;
    @Column
    private int price;
}
