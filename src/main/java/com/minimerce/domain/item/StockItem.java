package com.minimerce.domain.item;

import com.minimerce.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

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
    @Column(nullable = false)
    private int salePrice;
    @Column(nullable = false)
    private int costPrice;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private int usableCount;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;


}
