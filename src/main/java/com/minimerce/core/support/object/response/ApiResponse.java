package com.minimerce.core.support.object.response;

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

    private static ApiResponse of(ApiResult result, Object data) {
        return new ApiResponse(result, data);
    }

    public static ApiResponse ok(Object data) {
        return of(HttpResult.OK, data);
    }

    public static ApiResponse ok() {
        return of(HttpResult.OK, null);
    }

    public static ApiResponse httpError(HttpResult httpResult) {
        return of(httpResult, null);
    }

    public static ApiResponse error(ErrorCode errorCode) {
        return of(errorCode, null);
    }

    public static ApiResponse specificError(ErrorCode errorCode, Object data) {
        return of(errorCode, data);
    }

    public ApiResult getResult() {
        return result;
    }

    public Object getData() {
        return data;
    }
}
