package com.minimerce.domain.item;

import com.minimerce.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class StockItem extends BaseDomain {
    @Column
    private Long clientId;
    @Column(length = 200)
    private String name;
    @Column
    private int salePrice;
    @Column
    private int costPrice;
    @Column
    private int stock;
    @Column
    private int usableCount;
    @Column
    private LocalDate availableStartAt;
    @Column
    private LocalDate availableEndAt;


}
