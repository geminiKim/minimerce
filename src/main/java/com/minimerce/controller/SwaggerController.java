package com.minimerce.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by gemini on 25/05/2017.
 */
@Controller
public class SwaggerController {
    @GetMapping(value = "/docs")
    public String docs() {
        return "redirect:swagger-ui.html";
    }
    @ResponseBody
    @GetMapping(path = "/v2/api-docs")
    public Resource apiDocs() {
        return new ClassPathResource("swagger.json");
    }
    @ResponseBody
    @GetMapping(path = "/swagger-resources/configuration/ui")
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
    @ResponseBody
    @GetMapping(path = "/swagger-resources/configuration/security")
    public Object securityConfig() {
        return ImmutableList.of(ImmutableMap.builder()
                .put("apiKeyVehicle", "header")
                .put("scopeSeparator", ",")
                .put("apiKeyName", "api_key")
                .build());
    }
    @ResponseBody
    @GetMapping(path = "/swagger-resources")
    public Object resources() {
        return ImmutableList.of(ImmutableMap.builder()
                .put("name", "default")
                .put("location", "/v2/api-docs")
                .put("swaggerVersion", "2.0")
                .build());
    }
}
