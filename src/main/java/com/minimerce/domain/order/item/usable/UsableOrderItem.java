package com.minimerce.domain.order.item.usable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.item.UsableItem;
import com.minimerce.domain.order.item.OrderItem;
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
public class UsableOrderItem extends BaseDomain {
    @Column(nullable = false)
    private int usableCount;
    @Column(nullable = false)
    private int usedCount;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public UsableItem stockItem;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public OrderItem orderItem;
}
