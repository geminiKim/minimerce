package com.minimerce.domain.deal;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.util.Yn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealType type;

    @Column(length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Yn display;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealStatus status;

    @Column(nullable = false)
    private LocalDate saleStartAt;

    @Column(nullable = false)
    private LocalDate saleEndAt;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String informationJson;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String imageJson;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String thumbnailJson;

    @Column
    private int price;

    @Column
    private int displayPrice;

    @Column(length = 5, nullable = false)
    private String priceUnit;

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
