package com.minimerce.controller;

import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.exception.MinimerceSpecificException;
import com.minimerce.core.support.object.response.ApiResponse;
import com.minimerce.core.support.object.response.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
        return ApiResponse.httpError(HttpResult.BAD_REQUEST);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleRequestParameterException(MissingServletRequestParameterException e) {
        return ApiResponse.httpError(HttpResult.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse handleUnauthorized() {
        return ApiResponse.httpError(HttpResult.UNAUTHORIZED);
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse handleForbidden() {
        return ApiResponse.httpError(HttpResult.FORBIDDEN);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse handleNotFoundException() {
        return ApiResponse.httpError(HttpResult.NOT_FOUND);
    }
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiResponse handleNotSupportes(HttpRequestMethodNotSupportedException e) {
        return ApiResponse.httpError(HttpResult.METHOD_NOT_ALLOWED);
    }
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ApiResponse handleRequestTimeout() {
        return ApiResponse.httpError(HttpResult.REQUEST_TIMEOUT);
    }
    @ExceptionHandler(Throwable.class)
    public ApiResponse handleException(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return ApiResponse.httpError(HttpResult.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MinimerceSpecificException.class)
    public ApiResponse handleMinimerceSpecificException(MinimerceSpecificException exception) {
        log.error(exception.getMessage(), exception);
        return ApiResponse.specificError(exception.getError(), exception.getData());
    }
    @ExceptionHandler(MinimerceException.class)
    public ApiResponse handleMinimerceException(MinimerceException exception) {
        log.error(exception.getMessage(), exception);
        return ApiResponse.error(exception.getError());
    }
}
