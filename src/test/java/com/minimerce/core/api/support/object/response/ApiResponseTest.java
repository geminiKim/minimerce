package com.minimerce.core.api.support.object.response;

import com.minimerce.core.api.support.util.Json;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 21/05/2017.
 */
public class ApiResponseTest {

    @Test
    public void testApiResponseOkJsonFormat() {
        ApiResponse response = ApiResponse.of(ApiResult.ok(), new Object());
        System.out.println(Json.toJson(response));
        assertThat(Json.toJson(response), is("{\"result\":{\"status\":200,\"code\":200,\"message\":\"OK\",\"isError\":false},\"data\":{}}"));
    }
}