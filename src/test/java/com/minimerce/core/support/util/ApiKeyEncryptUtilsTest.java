package com.minimerce.core.support.util;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 09/06/2017.
 */
public class ApiKeyEncryptUtilsTest {
    @Test
    public void testEncode() throws Exception {
        assertThat(ApiKeyEncryptUtils.encode("test"), is("OQf+Z7xwRUmkKmdlLyaBBw"));
    }
    @Test
    public void testDecode() throws Exception {
        assertThat(ApiKeyEncryptUtils.decode("OQf+Z7xwRUmkKmdlLyaBBw"), is("test"));
    }
}