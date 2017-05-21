package com.minimerce.core.api.domain.deal;

import com.google.common.collect.Lists;
import com.minimerce.core.api.domain.BaseDomain;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.support.object.type.DealType;
import com.minimerce.core.api.support.util.Yn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 23/03/2017.
 */
@Setter
@Getter
@Entity
public class Deal extends BaseDomain {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    @Enumerated(EnumType.STRING)
    private DealType type;
    @Column
    @Enumerated(EnumType.STRING)
    private DealStatus status;
    @Column
    private int displayPrice;
    @Column
    private int price;
    @Column
    private String priceUnit;
    @Column
    private LocalDateTime saleStartAt;
    @Column
    private LocalDateTime saleEndAt;
    @Column
    private String informationJson;
    @Column
    private String imageJson;
    @Column
    private String thumbnailJson;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn display;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn deleted;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deal")
    public List<DealOption> options = Lists.newArrayList();

    public void addOption(DealOption option) {
        option.setDeal(this);
        this.options.add(option);
    }
    public void addOptions(List<DealOption> options) {
        options.forEach(e -> addOption(e));
    }

    public void delete() {
        deleted = Yn.Y;
    }
}
