package com.minimerce.domain.deal;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.option.DealOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gemini on 23/03/2017.
 */
//@Setter
//@Getter
@Entity
public class Deal extends BaseDomain {
    @Column(length = 200)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DealOption> getOptions() {
        return options;
    }

    public void setOptions(List<DealOption> options) {
        this.options = options;
    }
}
