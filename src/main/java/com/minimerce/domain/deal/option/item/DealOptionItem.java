package com.minimerce.domain.deal.option.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.option.DealOption;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by gemini on 29/03/2017.
 */
@Setter
@Getter
@Entity
public class DealOptionItem extends BaseDomain {
    @Column
    private Long clientId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption option;

    @Column
    private Long itemId;
}
