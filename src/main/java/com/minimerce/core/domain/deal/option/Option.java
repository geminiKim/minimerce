package com.minimerce.core.domain.deal.option;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimerce.core.domain.BaseDomain;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.object.deal.type.ProductType;
import com.minimerce.core.object.order.type.CancelType;
import com.minimerce.core.support.util.Yn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gemini on 23/03/2017.
 */
@Setter
@Getter
@Entity
@Table(name = "`option`")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
public class Option extends BaseDomain {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Deal deal;
    @Column
    private String name;
    @Column
    private String description;
    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Column
    @Enumerated(EnumType.STRING)
    private DealStatus status;
    @Column
    @Enumerated(EnumType.STRING)
    private CancelType cancelType;
    @Column
    private String priceUnit;
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

    public void delete() {
        deleted = Yn.Y;
    }
}
