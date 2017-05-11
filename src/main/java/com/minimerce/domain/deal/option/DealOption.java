package com.minimerce.domain.deal.option;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealStatus;
import com.minimerce.domain.deal.option.item.DealOptionItem;
import com.minimerce.object.type.CancelType;
import com.minimerce.object.type.DealType;
import com.minimerce.support.util.Yn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by gemini on 23/03/2017.
 */
@Setter
@Getter
@Entity
public class DealOption extends BaseDomain {
    @Column(length = 200)
    private String name;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealType type;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private DealStatus status;
    @Column(length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Yn display;
    @Column(nullable = false)
    private int salePrice;
    @Column(nullable = false)
    private int displayPrice;
    @Column(length = 5, nullable = false)
    private String priceUnit;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private CancelType cancelType;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String informationJson;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String imageJson;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String thumbnailJson;
    @Column(nullable = false)
    private int sort;
    @Column(length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Yn deleted;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "option")
    public List<DealOptionItem> items = Lists.newArrayList();

    public List<Long> getItemIds() {
        return items.stream().map(e -> e.getItemId()).collect(toList());
    }

    public void addItem(DealOptionItem item) {
        item.setOption(this);
        this.items.add(item);
    }
    public void addItems(List<DealOptionItem> items) {
        items.forEach(e -> addItem(e));
    }

    public void delete() {
        deleted = Yn.Y;
    }
}
