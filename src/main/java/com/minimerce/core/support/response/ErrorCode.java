package com.minimerce.core.support.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

/**
 * Created by gemini on 21/05/2017.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements ApiResult {
    NOT_EQUAL_ORDER_PRICE(10000, "Not equal order price"),
    NOT_EQUAL_UNIT_PRICE(10001, "Not equal unit price"),
    NOT_SUPPORTED_PRODUCT_TYPE(10002, "Not supported product type"),
    NOT_FOUND_ORDER(10003, "Not found order"),
    ALREADY_USE_COMPLETED_ORDER(10004, "Already use complete order"),
    ALREADY_RESTORED_ORDER(10004, "Already restored order"),
    SHORTAGE_STOCK(10005, "Shortage stock"),
    ALREADY_CANCELED_ORDER(10005, "Already canceled order"),
    DELIVERY_STARTED_ORDER(10006, "Delivery started order"),
    DELIVERY_FINISHED_ORDER(10007, "Delivery finished order"),

    NOT_FOUND_DEAL(20000, "Not found deal"),
    NOT_SALE_DEAL(20001, "Not sale deal"),
    NOT_DISPLAYED_DEAL(20002, "Not displayed deal"),

    NOT_FOUND_OPTION(20003, "Not found option"),
    NOT_SALE_OPTION(20004, "Not sale option"),
    NOT_DISPLAYED_OPTION(20005, "Not displayed option"),


    UNKNOWN(-1, "Unknown Error");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
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
        return true;
    }

    public static ErrorCode of(int code) {
        for (ErrorCode apiCode : ErrorCode.values()) {
            if(apiCode.getCode() == code) return apiCode;
        }
        return ErrorCode.UNKNOWN;
    }
}
