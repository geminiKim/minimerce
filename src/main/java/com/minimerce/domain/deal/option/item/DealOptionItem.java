package com.minimerce.domain.deal.option.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.support.util.Yn;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption option;

    @Column
    private Long itemId;

    @Column(length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Yn deleted;
}
