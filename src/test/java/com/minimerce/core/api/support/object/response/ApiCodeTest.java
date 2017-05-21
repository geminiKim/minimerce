package com.minimerce.core.api.support.object.response;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 21/05/2017.
 */
public class ApiCodeTest {

    @Test
    public void testFindApiCode200() {
        ApiCode code = ApiCode.of(200);
        assertThat(code.getCode(), is(200));
        assertThat(code.getMessage(), is("OK"));
        assertThat(code.isError(), is(false));
    }

    @Test
    public void testFindUnknownApiCode() {
        ApiCode code = ApiCode.of(-24140124);
        assertThat(code.getCode(), is(-1));
        assertThat(code.getMessage(), is("UNKNOWN ERROR"));
        assertThat(code.isError(), is(true));
    }
}