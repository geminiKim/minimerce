package com.minimerce.core.api.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("USABLE")
public class UsableItem extends Item {
    @Column
    private int stock;
    @Column
    private int usableCount;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;
}
