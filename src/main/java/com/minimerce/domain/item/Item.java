package com.minimerce.domain.item;

import com.minimerce.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class Item extends BaseDomain {

    @Column
    private Long clientId;


    @Column
    private int salePrice;

    @Column
    private int costPrice;


    @Column
    private int stock;




    @Column(length = 200)
    private String name;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;
}
