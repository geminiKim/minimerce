package com.minimerce.core.api.support.object.response;

/**
 * Created by gemini on 21/05/2017.
 */
public enum ApiCode {
    OK(200, "OK", false),
    UNKNOWN(-1, "UNKNOWN ERROR", true);

    private int code;
    private String message;
    private boolean error;

    ApiCode(int code, String message, boolean error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isError() {
        return error;
    }

    public static ApiCode of(int code) {
        for (ApiCode apiCode : ApiCode.values()) {
            if(apiCode.getCode() == code) return apiCode;
        }
        return ApiCode.UNKNOWN;
    }
}
