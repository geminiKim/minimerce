package com.minimerce.domain.client;

import com.minimerce.domain.BaseDomain;
import com.minimerce.support.util.Yn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by gemini on 11/05/2017.
 */
@Setter
@Getter
@Entity
public class Client extends BaseDomain {
    @Column
    private String name;
    @Column
    private String corporation;
    @Column
    private String apiKey;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn deleted;
}
