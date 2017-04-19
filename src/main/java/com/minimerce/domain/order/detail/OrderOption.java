package com.minimerce.domain.order.detail;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class OrderOption extends BaseDomain {
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Order order;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "option")
    public List<OrderItem> items = Lists.newArrayList();

    public void addItem(OrderItem item) {
        item.setOption(this);
        this.items.add(item);
    }
    public void addItems(List<OrderItem> items) {
        items.forEach(e -> addItem(e));
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption dealOption;
}
