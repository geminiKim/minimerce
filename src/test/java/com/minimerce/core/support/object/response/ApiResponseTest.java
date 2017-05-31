package com.minimerce.core.support.object.response;

import com.minimerce.core.support.util.Json;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 21/05/2017.
 */
public class ApiResponseTest {
    @Test
    public void testApiResponseBadRequestJsonFormat() {
        ApiResponse response = ApiResponse.httpError(HttpResult.BAD_REQUEST);
        System.out.println(Json.toJson(response));
        assertThat(response.getResult().getStatus(), is(400));
        assertThat(response.getResult().getCode(), is(400));
        assertThat(response.getResult().getIsError(), is(true));
        assertThat(response.getResult().getMessage(), is(HttpResult.BAD_REQUEST.getMessage()));
    }
    @Test
    public void testApiResponseUnknownErrorJsonFormat() {
        ApiResponse response = ApiResponse.error(ErrorCode.UNKNOWN);
        System.out.println(Json.toJson(response));
        assertThat(response.getResult().getStatus(), is(500));
        assertThat(response.getResult().getCode(), is(-1));
        assertThat(response.getResult().getIsError(), is(true));
        assertThat(response.getResult().getMessage(), is(ErrorCode.UNKNOWN.getMessage()));
    }
    @Test
    public void testApiResponseOkJsonFormat() {
        ApiResponse response = ApiResponse.ok(new Object());
        System.out.println(Json.toJson(response));
        assertThat(response.getResult().getStatus(), is(200));
        assertThat(response.getResult().getCode(), is(200));
        assertThat(response.getResult().getIsError(), is(false));
        assertThat(response.getResult().getMessage(), is(HttpResult.OK.getMessage()));
    }
}