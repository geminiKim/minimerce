package com.minimerce.domain.order.option;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.object.order.CancelStatus;
import com.minimerce.object.order.OrderStatus;
import com.minimerce.object.type.DealType;
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
    public DealOption dealOption;
    @Column
    private String title;
    @Column
    @Enumerated(EnumType.STRING)
    private DealType type;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column
    @Enumerated(EnumType.STRING)
    private CancelStatus cancelStatus;
    @Column
    private int price;

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

}
