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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;
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
    @Enumerated(EnumType.STRING)
    private CancelType cancelType;
    @Column
    private int displayPrice;
    @Column
    private String priceUnit;
    @Column
    private String informationJson;
    @Column
    private String imageJson;
    @Column
    private String thumbnailJson;
    @Column
    private int sort;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn display;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn deleted;

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
