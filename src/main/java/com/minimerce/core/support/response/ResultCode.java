package com.minimerce.core.support.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

/**
 * Created by gemini on 25/06/2017.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultCode implements ApiResult {
    SUCCESS(200, "SUCCESS", false),
    FAIL(500, "FAIL", true);

    private int code;
    private String message;
    private boolean error;

    ResultCode(int code, String message, boolean error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    @Override
    public int getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean getIsError() {
        return error;
    }
}
