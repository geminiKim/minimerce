package com.minimerce.configuration;

import com.minimerce.core.support.object.response.ApiResponse;
import com.minimerce.core.support.object.response.HttpResult;
import com.minimerce.core.support.util.Json;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * Created by gemini on 13/06/2017.
 */
@Configuration(value = "errorAttributes")
public class ErrorAttributesConfiguration extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        try {
            HttpStatus statusCode = HttpStatus.valueOf((Integer) requestAttributes.getAttribute("javax.servlet.error.status_code", RequestAttributes.SCOPE_REQUEST));
            return Json.toMap(ApiResponse.httpError(HttpResult.of(statusCode, true)));
        } catch (Exception e) {
            return Json.toMap(ApiResponse.httpError(HttpResult.INTERNAL_SERVER_ERROR));
        }
    }
}
