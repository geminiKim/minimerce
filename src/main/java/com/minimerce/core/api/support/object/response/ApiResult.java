package com.minimerce.core.api.support.object.response;

import org.springframework.http.HttpStatus;

/**
 * Created by gemini on 21/05/2017.
 */
public class ApiResult {
    private HttpStatus status;
    private ApiCode code;

    private ApiResult(HttpStatus status, ApiCode code) {
        this.status = status;
        this.code = code;
    }

    public static ApiResult of(HttpStatus status, ApiCode code) {
        return new ApiResult(status, code);
    }

    public static ApiResult ok() {
        return ApiResult.of(HttpStatus.OK, ApiCode.OK);
    }

    public int getStatus() {
        return status.value();
    }
    public int getCode() {
        return code.getCode();
    }
    public String getMessage() {
        return code.getMessage();
    }
    public boolean getIsError() {
        return code.isError();
    }
}
