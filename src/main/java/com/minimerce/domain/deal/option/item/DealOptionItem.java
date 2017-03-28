package com.minimerce.domain.deal.option.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.type.DealType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gemini on 29/03/2017.
 */
@Setter
@Getter
@Entity
public class DealOptionItem extends BaseDomain {
    @Column
    private Long clientId;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealType type;

    @Column
    private Long itemId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption option;

}
