package com.github.dadiyang.bestpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 相关配置
 *
 * @author dadiyang
 * @since 2019-06-02
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 我们只
                .apis(RequestHandlerSelectors.basePackage("com.github.dadiyang.bestpractice"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring最佳实践")
                .description("本项目用于展示个人开发过程中总结的一些最佳实践")
                .contact(
                        new Contact("dadiyang", "https://www.github.com/dadiyang", "dadiyang@aliyun.com")
                )
                .version("1.0.0")
                .build();
    }
}