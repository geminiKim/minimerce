package com.minimerce.core.domain.deal.option.delivery;

import com.minimerce.core.domain.deal.option.Option;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by gemini on 15/07/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("DELIVERY")
public class DeliveryOption extends Option {
    @Column
    private int normalPrice;
    @Column
    private int salePrice;
    @Column
    private int costPrice;
    @Column
    private int stock;
    @Column
    private LocalDateTime saleStartAt;
    @Column
    private LocalDateTime saleEndAt;
}
