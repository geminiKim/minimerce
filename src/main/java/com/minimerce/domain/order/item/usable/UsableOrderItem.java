package com.minimerce.domain.order.item.usable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.item.UsableItem;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.object.order.OrderStatus;
import com.minimerce.support.exception.MinimerceException;
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public OrderItem orderItem;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public UsableItem item;
    @Column
    private int usableCount;
    @Column
    private int usedCount;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;

    public void use() throws MinimerceException {
        if(usedCount + 1 > usableCount) throw new MinimerceException("already use complete order");
        usedCount++;
        orderItem.setStatus(OrderStatus.USED);
    }

    public void restore() throws MinimerceException {
        if(usedCount - 1 < 0) throw new MinimerceException("already restore");
        usedCount--;
        orderItem.setStatus(OrderStatus.ORDERED);
    }
}
