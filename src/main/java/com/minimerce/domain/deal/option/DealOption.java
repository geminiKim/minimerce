package com.minimerce.domain.deal.option;

import com.minimerce.domain.BaseDomain;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealStatus;
import com.minimerce.domain.type.CancelType;
import com.minimerce.domain.type.DealType;
import com.minimerce.util.Yn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gemini on 23/03/2017.
 */
@Setter
@Getter
@Entity
public class DealOption extends BaseDomain {
    @Column
    private Long clientId;

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

    @Column
    private int salePrice;

    @Column
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

    @Column
    private int sort;

    @ManyToOne(fetch = FetchType.LAZY)
    public Deal deal;
}
