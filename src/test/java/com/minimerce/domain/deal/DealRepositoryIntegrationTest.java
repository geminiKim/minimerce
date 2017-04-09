package com.minimerce.domain.deal;

import com.minimerce.IntegrationTest;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertNull;

/**
 * Created by gemini on 10/04/2017.
 */
public class DealRepositoryIntegrationTest extends IntegrationTest {
    @Inject DealRepository dealRepository;

    @Test
    public void testShoudBeReturnNull() {
        assertNull(dealRepository.findAll());
    }
}