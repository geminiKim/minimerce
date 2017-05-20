package com.minimerce.core.api.support.exception;

/**
 * Created by gemini on 11/04/2017.
 */
public class MinimerceException extends Exception {
    public MinimerceException() {
        super();
    }

    public MinimerceException(String message) {
        super(message);
    }

    public MinimerceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinimerceException(Throwable cause) {
        super(cause);
    }

    protected MinimerceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
