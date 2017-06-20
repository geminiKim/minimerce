package com.minimerce.core.domain.order.option.usable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.object.order.OrderStatus;
import com.minimerce.core.support.object.response.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by gemini on 13/06/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("USABLE")
public class UsableOrderOption extends OrderOption {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private UsableOption option;
    @Column
    private int usedCount;
    @Column
    private int usableCount;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;

    public void use() {
        if(usedCount + 1 > usableCount) throw new MinimerceException(ErrorCode.ALREADY_USE_COMPLETED_ORDER);
        usedCount++;
        setStatus(OrderStatus.USED);
    }

    public void restore() {
        if(usedCount - 1 < 0) throw new MinimerceException(ErrorCode.ALREADY_RESTORED_ORDER);
        usedCount--;
        setStatus(OrderStatus.ORDERED);
    }
}
