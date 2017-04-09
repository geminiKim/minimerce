package com.minimerce.component.deal;

import javax.persistence.EntityNotFoundException;

/**
 * Created by gemini on 10/04/2017.
 */
public class EntityReader {
    protected void validate(Object one) throws EntityNotFoundException {
        if(one == null) throw new EntityNotFoundException();
    }
}
