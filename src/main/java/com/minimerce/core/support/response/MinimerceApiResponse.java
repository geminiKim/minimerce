package com.minimerce.core.support.response;

import java.time.LocalDateTime;

/**
 * Created by gemini on 21/05/2017.
 */
public class MinimerceApiResponse {
    private final ApiResult result;
    private final Object data;
    private final LocalDateTime timestamp;

    private MinimerceApiResponse(ApiResult result, Object data) {
        this.result = result;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    private static MinimerceApiResponse of(ApiResult result, Object data) {
        return new MinimerceApiResponse(result, data);
    }

    public static MinimerceApiResponse ok(Object data) {
        return of(HttpResult.OK, data);
    }

    public static MinimerceApiResponse ok() {
        return of(HttpResult.OK, null);
    }

    public static MinimerceApiResponse httpError(HttpResult httpResult) {
        return of(httpResult, null);
    }

    public static MinimerceApiResponse error(ErrorCode errorCode) {
        return of(errorCode, null);
    }

    public static MinimerceApiResponse specificError(ErrorCode errorCode, Object data) {
        return of(errorCode, data);
    }

    public ApiResult getResult() {
        return result;
    }

    public Object getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
