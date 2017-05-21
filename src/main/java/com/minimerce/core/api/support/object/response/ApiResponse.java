package com.minimerce.core.api.support.object.response;

/**
 * Created by gemini on 21/05/2017.
 */
public class ApiResponse {
    private final ApiResult result;
    private final Object data;

    private ApiResponse(ApiResult result, Object data) {
        this.result = result;
        this.data = data;
    }

    public static ApiResponse of(ApiResult result, Object data) {
        return new ApiResponse(result, data);
    }

    public ApiResult getResult() {
        return result;
    }

    public Object getData() {
        return data;
    }
}
