package com.minimerce.core.admin.deal;

import com.minimerce.IntegrationTest;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.api.domain.deal.Deal;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.inject.Inject;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 20/05/2017.
 */
public class DealAdminServiceIntegrationTest extends IntegrationTest {
    @Inject DealAdminService dealService;

    @Test
    public void testSholudBeFindDealsResultSizeGreaterThen1() {
        Pageable pageable = PageableBuilder.aPageable().withPageNumber(0).withPageSize(25).build();
        Page<Deal> result = dealService.findAll(pageable);
        assertThat(result.getContent().size(), is(greaterThan(0)));
    }
}