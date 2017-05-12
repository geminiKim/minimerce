package com.minimerce.domain.item;

import com.minimerce.domain.BaseDomain;
import com.minimerce.support.util.Yn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

/**
 * Created by gemini on 25/03/2017.
 */
@Setter
@Getter
@Entity
public class UsableItem extends BaseDomain {
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private int stock;
    @Column
    private int usableCount;
    @Column
    private LocalDateTime availableStartAt;
    @Column
    private LocalDateTime availableEndAt;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn deleted;

    public void delete() {
        deleted = Yn.Y;
    }
}
