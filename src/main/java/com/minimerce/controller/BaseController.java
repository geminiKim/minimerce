package com.minimerce.controller;

import com.minimerce.core.api.support.exception.MinimerceException;
import com.minimerce.core.api.support.object.response.ApiCode;
import com.minimerce.core.api.support.object.response.ApiResponse;
import com.minimerce.core.api.support.object.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by gemini on 21/05/2017.
 */
@Slf4j
@ControllerAdvice
public class BaseController {
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleBadRequestException(TypeMismatchException e) {
        return ApiResponse.error(ApiResult.of(HttpStatus.BAD_REQUEST, ApiCode.BAD_REQUEST));
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleRequestParameterException(MissingServletRequestParameterException e) {
        return ApiResponse.error(ApiResult.of(HttpStatus.BAD_REQUEST, ApiCode.BAD_REQUEST));
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse handleUnauthorized() {
        return ApiResponse.error(ApiResult.of(HttpStatus.UNAUTHORIZED, ApiCode.UNAUTHORIZED));
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse handleForbidden() {
        return ApiResponse.error(ApiResult.of(HttpStatus.FORBIDDEN, ApiCode.FORBIDDEN));
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse handleNotFoundException() {
        return ApiResponse.error(ApiResult.of(HttpStatus.NOT_FOUND, ApiCode.NOT_FOUND));
    }
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiResponse handleNotSupportes(Exception e) {
        return ApiResponse.error(ApiResult.of(HttpStatus.METHOD_NOT_ALLOWED, ApiCode.METHOD_NOT_ALLOWED));
    }
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ApiResponse handleRequestTimeout() {
        return ApiResponse.error(ApiResult.of(HttpStatus.REQUEST_TIMEOUT, ApiCode.REQUEST_TIMEOUT));
    }
    @ExceptionHandler(MinimerceException.class)
    public ApiResponse handleMinimerceException(MinimerceException apiException) {
        log.error(apiException.getMessage(), apiException);
        return ApiResponse.error(ApiResult.of(HttpStatus.INTERNAL_SERVER_ERROR, apiException.getCode()));
    }
    @ExceptionHandler(Throwable.class)
    public ApiResponse handleException(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return ApiResponse.error(ApiResult.of(HttpStatus.INTERNAL_SERVER_ERROR, ApiCode.UNKNOWN));
    }
}
