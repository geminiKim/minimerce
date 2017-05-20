package com.minimerce.core.api.domain.client;

import com.minimerce.core.api.domain.BaseDomain;
import com.minimerce.core.api.support.util.Yn;
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
    private ClientRole role;
    @Column
    @Enumerated(EnumType.STRING)
    private Yn deleted;
}
