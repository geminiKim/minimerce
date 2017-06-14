package com.minimerce.core.domain.deal.option.usable;

import com.minimerce.core.domain.deal.option.Option;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by gemini on 13/06/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("USABLE")
public class UsableOption extends Option {
    @Column
    private int normalPrice;
    @Column
    private int salePrice;
    @Column
    private int costPrice;
    @Column
    private int stock;
    @Column
    private int usableCount;
    @Column
    private LocalDateTime saleStartAt;
    @Column
    private LocalDateTime saleEndAt;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;
}
