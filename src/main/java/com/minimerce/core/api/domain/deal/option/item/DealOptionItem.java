package com.minimerce.core.api.domain.deal.option.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.api.domain.BaseDomain;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.item.Item;
import com.minimerce.core.api.support.util.Yn;
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public DealOption option;
    @JsonIgnore
    @ManyToOne
    public Item item;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn deleted;

    @JsonIgnore
    public void delete() {
        deleted = Yn.Y;
    }
}
