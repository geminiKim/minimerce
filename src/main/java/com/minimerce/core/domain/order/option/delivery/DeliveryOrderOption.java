package com.minimerce.core.domain.order.option.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.domain.deal.option.delivery.DeliveryOption;
import com.minimerce.core.domain.order.option.OrderOption;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gemini on 15/07/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("DELIVERY")
public class DeliveryOrderOption extends OrderOption {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private DeliveryOption option;

    @Column
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
