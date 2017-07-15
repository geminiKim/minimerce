package com.minimerce.core.domain.order.option.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.domain.order.option.OrderOption;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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
    private DeliveryOrderOption option;
}
