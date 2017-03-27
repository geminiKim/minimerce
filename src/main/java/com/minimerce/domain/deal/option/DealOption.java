package com.minimerce.domain.deal.option;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.item.DealOptionItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gemini on 23/03/2017.
 */
@Setter
@Getter
@Entity
public class DealOption extends BaseDomain {

    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<DealOptionItem> items = Lists.newArrayList();

    public void addItem(DealOptionItem item) {
        item.setOption(this);
        this.items.add(item);
    }
    public void addItems(List<DealOptionItem> items) {
        items.forEach(e -> e.setOption(this));
        this.items.addAll(items);
    }

}
