package com.minimerce.domain.deal;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.option.DealOption;
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
public class Deal extends BaseDomain {
    @Column(length = 200)
    private String name;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<DealOption> options = Lists.newArrayList();

    public void addOption(DealOption option) {
        option.setDeal(this);
        this.options.add(option);
    }
    public void addOptions(List<DealOption> options) {
        options.forEach(e -> e.setDeal(this));
        this.options.addAll(options);
    }
}
