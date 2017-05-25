package com.minimerce.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * Created by gemini on 25/05/2017.
 */
@RestController
public class SwaggerController {
    @GetMapping(path = "/v2/api-docs", produces = APPLICATION_JSON_VALUE)
    public Resource apiDocs() {
        return new ClassPathResource("swagger.json");
    }
    @GetMapping(path = "/swagger-resources/configuration/ui", produces = APPLICATION_JSON_VALUE)
    public Object uiConfig() {
        return ImmutableMap.builder()
                .put("docExpansion", "none")
                .put("apisSorter", "alpha")
                .put("defaultModelRendering", "schema")
                .put("jsonEditor", Boolean.FALSE)
                .put("showRequestHeaders", Boolean.TRUE)
                .put("supportedSubmitMethods", ImmutableList.of("get","post","put","delete"))
                .build();
    }
    @GetMapping(path = "/swagger-resources/configuration/security", produces = APPLICATION_JSON_VALUE)
    public Object securityConfig() {
        return ImmutableList.of(ImmutableMap.builder()
                .put("apiKeyVehicle", "header")
                .put("scopeSeparator", ",")
                .put("apiKeyName", "api_key")
                .build());
    }
    @GetMapping(path = "/swagger-resources", produces = APPLICATION_JSON_VALUE)
    public Object resources() {
        return ImmutableList.of(ImmutableMap.builder()
                .put("name", "default")
                .put("location", "/v2/api-docs")
                .put("swaggerVersion", "2.0")
                .build());
    }
}
