package com.minimerce.core.api.support.object.response;

import org.springframework.http.HttpStatus;

/**
 * Created by gemini on 21/05/2017.
 */
public class HttpResult implements ApiResult {
    private HttpStatus status;
    private boolean error;

    private HttpResult(HttpStatus status, boolean error) {
        this.status = status;
        this.error = error;
    }

    @Override
    public int getStatus() {
        return status.value();
    }

    @Override
    public int getCode() {
        return status.value();
    }

    @Override
    public String getMessage() {
        return status.name();
    }

    @Override
    public boolean getIsError() {
        return error;
    }

    public static HttpResult OK = new HttpResult(HttpStatus.OK, false);
    public static HttpResult BAD_REQUEST = new HttpResult(HttpStatus.BAD_REQUEST, true);
    public static HttpResult UNAUTHORIZED = new HttpResult(HttpStatus.UNAUTHORIZED, true);
    public static HttpResult FORBIDDEN = new HttpResult(HttpStatus.FORBIDDEN, true);
    public static HttpResult NOT_FOUND = new HttpResult(HttpStatus.NOT_FOUND, true);
    public static HttpResult METHOD_NOT_ALLOWED = new HttpResult(HttpStatus.METHOD_NOT_ALLOWED, true);
    public static HttpResult REQUEST_TIMEOUT = new HttpResult(HttpStatus.REQUEST_TIMEOUT, true);
    public static HttpResult INTERNAL_SERVER_ERROR = new HttpResult(HttpStatus.INTERNAL_SERVER_ERROR, true);
}
