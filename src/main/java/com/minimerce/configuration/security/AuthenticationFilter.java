package com.minimerce.configuration.security;

import com.minimerce.core.api.support.object.response.ApiResponse;
import com.minimerce.core.api.support.object.response.HttpResult;
import com.minimerce.core.api.support.util.Json;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by gemini on 11/05/2017.
 */
public class AuthenticationFilter extends GenericFilterBean {
    private final AuthenticationService authenticationService;

    public AuthenticationFilter(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            authenticationService.authentication((HttpServletRequest) request);
            chain.doFilter(request, response);
        } catch (AccessDeniedException e) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(Json.toJson(ApiResponse.httpError(HttpResult.UNAUTHORIZED)));
        } catch (Exception e) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(Json.toJson(ApiResponse.httpError(HttpResult.BAD_REQUEST)));
        }
    }
}
