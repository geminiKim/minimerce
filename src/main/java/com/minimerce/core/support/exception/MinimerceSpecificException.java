package com.minimerce.core.support.exception;

import com.minimerce.core.support.response.ErrorCode;

/**
 * Created by gemini on 11/04/2017.
 */
public class MinimerceSpecificException extends RuntimeException {
    private final ErrorCode error;
    private final Object data;

    @Override
    public String getMessage() {
        return error.getMessage();
    }

    public MinimerceSpecificException(ErrorCode error, Object data) {
        super(error.getMessage());
        this.error = error;
        this.data = data;
    }

    public MinimerceSpecificException(ErrorCode error, Object data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        this.data = data;
    }

    public ErrorCode getError() {
        return error;
    }

    public Object getData() {
        return data;
    }
}
