package com.minimerce.core.domain.order.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.domain.BaseDomain;
import com.minimerce.core.domain.item.Item;
import com.minimerce.core.domain.order.option.OrderOption;
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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderItem extends BaseDomain {
    @Column
    private Long clientId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public OrderOption option;
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
    private int salePrice;
    @Column
    private int costPrice;

    public abstract Item getItem();
}
