package com.quickbase.trigger.configuration;

import com.quickbase.trigger.util.swagger.TriggerServiceSwaggerIgnore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

/**
 * Created by xhe on 6/10/17.
 */
@Configuration
public class SwaggerConfig {
    private final String swagger_doc_title = "Quickbase Automation Trigger Service";
    private final String swagger_doc_description = "Trigger service executes an automation based on data changes.";
    private final String swagger_doc_version = "0.1";
    private final String swagger_contact_name = "XJ";
    private final String swagger_doc_termsOfServiceUrl = "Quick Base License Terms";
    private final String swagger_doc_license = "The Apache License, Version 2.0";
    private final String swagger_doc_licenseUrl = "www.quickbase.com";

    @Bean
    public Docket triggerServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("internal-api")
            .genericModelSubstitutes(DeferredResult.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(true)
            .pathMapping("/")
            .select()
            .apis(not(withClassAnnotation(TriggerServiceSwaggerIgnore.class)))
            .paths(or(regex("/api/.*")))
            .build()
            .apiInfo(withTriggerServiceApiInfo());
    }

    private ApiInfo withTriggerServiceApiInfo() {
        ApiInfo apiInfo = new ApiInfo(swagger_doc_title,
            swagger_doc_description,
            swagger_doc_version,
            swagger_doc_termsOfServiceUrl,
            swagger_contact_name,
            swagger_doc_license,
            swagger_doc_licenseUrl);

        return apiInfo;
    }

    private Contact withTriggerServiceContactInfo() {
        Contact swagger_doc_contact =
            new Contact("XJ",
                "https://quickbase.atlassian.net/wiki/pages/viewpage.action?pageId=56146675",
                "xhe@quickbase.com");
        return swagger_doc_contact;
    }
}
