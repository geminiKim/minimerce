package com.minimerce.configuration;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by gemini on 20/06/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket swagger() {


        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("minimerce-v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.minimerce.controller.api"))
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .securitySchemes(Lists.newArrayList(new ApiKey("api-key", "minimerce-api-key", "header")));
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Minimerce")
                .description("Minimerce is an E-Commerce API Platform.<br/>Provides product registration and ordering, state management, and external API creation.")
                .termsOfServiceUrl("")
                .version("0.0.1")
                .contact(new Contact("","", "geminikims@gmail.com"))
                .build();
    }
}
