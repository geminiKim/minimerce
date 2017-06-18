package com.minimerce.builder;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by gemini on 20/05/2017.
 */
public final class PageableBuilder {
    private int pageNumber = 0;
    private int pageSize = 25;

    private PageableBuilder() {
    }

    public static PageableBuilder aPageable() {
        return new PageableBuilder();
    }

    public PageableBuilder withPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public PageableBuilder withPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Pageable build() {
        return new Pageable() {
            @Override
            public int getPageNumber() {
                return pageNumber;
            }

            @Override
            public int getPageSize() {
                return pageSize;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
    }
}
