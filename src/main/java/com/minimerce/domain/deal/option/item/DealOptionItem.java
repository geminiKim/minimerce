package com.minimerce.domain.deal.option.item;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.type.DealType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by gemini on 29/03/2017.
 */
@Setter
@Getter
@Entity
public class DealOptionItem extends BaseDomain {
    @Column
    private Long clientId;

    @Column
    private Long optionId;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealType type;

    @Column
    private Long itemId;
}
