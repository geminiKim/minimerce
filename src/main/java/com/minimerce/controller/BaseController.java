package com.minimerce.controller;

import com.minimerce.core.object.response.HttpResult;
import com.minimerce.core.object.response.MinimerceApiResponse;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.exception.MinimerceSpecificException;
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
    public MinimerceApiResponse handleBadRequestException(TypeMismatchException e) {
        return MinimerceApiResponse.httpError(HttpResult.BAD_REQUEST);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MinimerceApiResponse handleRequestParameterException(MissingServletRequestParameterException e) {
        return MinimerceApiResponse.httpError(HttpResult.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public MinimerceApiResponse handleUnauthorized() {
        return MinimerceApiResponse.httpError(HttpResult.UNAUTHORIZED);
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public MinimerceApiResponse handleForbidden() {
        return MinimerceApiResponse.httpError(HttpResult.FORBIDDEN);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MinimerceApiResponse handleNotFoundException() {
        return MinimerceApiResponse.httpError(HttpResult.NOT_FOUND);
    }
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public MinimerceApiResponse handleNotSupportes(HttpRequestMethodNotSupportedException e) {
        return MinimerceApiResponse.httpError(HttpResult.METHOD_NOT_ALLOWED);
    }
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public MinimerceApiResponse handleRequestTimeout() {
        return MinimerceApiResponse.httpError(HttpResult.REQUEST_TIMEOUT);
    }
    @ExceptionHandler(Throwable.class)
    public MinimerceApiResponse handleException(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return MinimerceApiResponse.httpError(HttpResult.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MinimerceSpecificException.class)
    public MinimerceApiResponse handleMinimerceSpecificException(MinimerceSpecificException exception) {
        log.error(exception.getMessage(), exception);
        return MinimerceApiResponse.specificError(exception.getError(), exception.getData());
    }
    @ExceptionHandler(MinimerceException.class)
    public MinimerceApiResponse handleMinimerceException(MinimerceException exception) {
        log.error(exception.getMessage(), exception);
        return MinimerceApiResponse.error(exception.getError());
    }
}
