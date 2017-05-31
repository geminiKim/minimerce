package com.minimerce.core.support.exception;

import com.minimerce.core.support.object.response.ErrorCode;

/**
 * Created by gemini on 11/04/2017.
 */
public class MinimerceException extends RuntimeException {
    private final ErrorCode error;

    @Override
    public String getMessage() {
        return error.getMessage();
    }

    public MinimerceException(ErrorCode error) {
        super(error.getMessage());
        this.error = error;
    }

    public MinimerceException(ErrorCode error, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
    }

    public ErrorCode getError() {
        return error;
    }
}
