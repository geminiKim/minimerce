package com.minimerce.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by gemini on 23/03/2017.
 */
@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@MappedSuperclass
public class BaseDomain implements Serializable {
    @Id
    @GeneratedValue
    protected Long id;

    @Column
    protected LocalDateTime createdAt;

    @Column
    protected LocalDateTime updatedAt;

    @PrePersist
    protected void onPersist() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
