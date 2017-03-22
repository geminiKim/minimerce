package com.minimerce.domain.deal.option;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by gemini on 23/03/2017.
 */
//@Setter
//@Getter
@Entity
public class DealOption extends BaseDomain {
    @Column(length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }
}
