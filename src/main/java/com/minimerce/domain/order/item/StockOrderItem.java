package com.minimerce.domain.order.item;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.item.StockItem;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class StockOrderItem extends BaseDomain {
    @Column
    private Long clientId;
    @Column(length = 100)
    private String title;
    @Column(nullable = false)
    private int salePrice;
    @Column(nullable = false)
    private int costPrice;
    @Column(nullable = false)
    private int usableCount;
    @Column(nullable = false)
    private int usedCount;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;

    @ManyToOne(fetch = FetchType.LAZY)
    public StockItem stockItem;

    @ManyToOne(fetch = FetchType.LAZY)
    public Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    public OrderDetail detail;

    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption dealOption;
}
