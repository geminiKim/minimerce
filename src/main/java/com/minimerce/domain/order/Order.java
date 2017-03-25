package com.minimerce.domain.order;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.domain.order.status.PaidStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class Order extends BaseDomain {
    @Column
    private Long clientId;
    @Column
    private Long customerId;
    @Column(length = 100)
    private String title;
    @Column
    private Integer totalAmount;
    @Column
    private Integer paidAmount;
    @Column
    private Integer discountAmount;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String dealIds;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String cartIds;
    @Column
    private LocalDate paidAt;
    @Column
    @Enumerated(EnumType.STRING)
    private PaidStatus paidStatus;


    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<OrderDetail> orderDetails = Lists.newArrayList();
}
