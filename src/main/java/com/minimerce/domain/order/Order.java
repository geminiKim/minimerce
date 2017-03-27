package com.minimerce.domain.order;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.domain.order.status.PaidStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
@Table(name = "`order`")
public class Order extends BaseDomain {
    @Column
    private Long clientId;
    @Column
    private Long clientOrderId;
    @Column
    private Long customerId;
    @Column(length = 100)
    private String title;
    @Column(nullable = false)
    private int totalAmount;
    @Column(nullable = false)
    private int paidAmount;
    @Column(nullable = false)
    private int discountAmount;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String dealIds;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String cartIds;
    @Column
    private LocalDateTime paidAt;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private PaidStatus paidStatus;


    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<OrderDetail> details = Lists.newArrayList();

    public void addDetail(OrderDetail detail) {
        detail.setOrder(this);
        this.details.add(detail);
    }
    public void addDetails(List<OrderDetail> details) {
        details.forEach(e -> e.setOrder(this));
        this.details.addAll(details);
    }
}
