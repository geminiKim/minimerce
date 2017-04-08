package com.minimerce.domain.deal;

import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.type.DealType;
import com.minimerce.util.Yn;
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
    private Long clientId;

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
    private LocalDateTime saleStartAt;

    @Column(nullable = false)
    private LocalDateTime saleEndAt;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String informationJson;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String imageJson;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String thumbnailJson;

    @Column(nullable = false)
    private int salePrice;

    @Column(nullable = false)
    private int displayPrice;

    @Column(length = 5, nullable = false)
    private String priceUnit;

    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "dealId")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<DealOption> options = Lists.newArrayList();

    public void addOption(DealOption option) {
        option.setDealId(id);
        this.options.add(option);
    }
    public void addOptions(List<DealOption> options) {
        options.forEach(e -> addOption(e));
    }
}
