package com.minimerce.domain.deal.option.item;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class DealOptionItem extends BaseDomain {
    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption option;
}
