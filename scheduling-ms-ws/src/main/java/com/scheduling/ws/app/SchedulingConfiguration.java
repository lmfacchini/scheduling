package com.scheduling.ws.app;

import com.scheduling.bridge.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages="com.scheduling.core.repository")
@EnableConfigurationProperties
@ComponentScan("com.scheduling")
@EnableCaching
@EnableSwagger2
@Slf4j
public class SchedulingConfiguration {


    @RestControllerAdvice
    public class ExceptionHandlerControllerAdvice{

        @ExceptionHandler(BusinessException.class)
        public ResponseEntity<String> handle(BusinessException ex){
            log.debug(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        @ExceptionHandler(Throwable.class)
        public ResponseEntity<String> handle(Throwable ex){
            log.error(ex.getMessage(), ex);
            return ResponseEntity.internalServerError().build();
        }

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.scheduling.ws.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Scheduling")
                .licenseUrl(null)
                .termsOfServiceUrl(null)
                .description("Documentação dos endpoints da API do Scheduling")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .build();
    }

}
