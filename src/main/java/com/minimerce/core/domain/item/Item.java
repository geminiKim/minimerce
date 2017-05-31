package com.minimerce.core.domain.item;

import com.minimerce.core.domain.BaseDomain;
import com.minimerce.core.support.object.type.DealType;
import com.minimerce.core.support.util.Yn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item extends BaseDomain {
    @Column
    private String name;
    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private DealType type;
    @Column
    private int salePrice;
    @Column
    private int costPrice;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn deleted;

    public void delete() {
        deleted = Yn.Y;
    }
}
