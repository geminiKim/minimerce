package com.minimerce.core.domain.order.item.usable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.domain.item.usable.UsableItem;
import com.minimerce.core.domain.order.item.OrderItem;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.object.order.OrderStatus;
import com.minimerce.core.support.object.response.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("USABLE")
public class UsableOrderItem extends OrderItem {
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

    public void use() {
        if(usedCount + 1 > usableCount) throw new MinimerceException(ErrorCode.ALREADY_USE_COMPLETED_ORDER);
        usedCount++;
        setStatus(OrderStatus.USED);
        option.updateStatus();
    }

    public void restore() {
        if(usedCount - 1 < 0) throw new MinimerceException(ErrorCode.ALREADY_RESTORED_ORDER);
        usedCount--;
        setStatus(OrderStatus.ORDERED);
        option.updateStatus();
    }
}
