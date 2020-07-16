package com.tz.leo.swagge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Author: tz_wl
 * Date: 2020/7/16 19:55
 * Content:   通用的swagger 配置文件
 */

@Configuration
@EnableSwagger2         //开启swagger2 注解扫描
public class SwaggerConfig {


    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)    //接口文档规范
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tz.leo.swagge.controller")) //扫描哪个接口的包，*Controller
                .build();
    }

    /**
     * 该套 API 说明，包含作者、简介、版本、host、服务URL
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("标题： springboot 整合 swagger 使用 ")        //标题
                .description("springboot 整合 swagger  详细信息")
                .version("0.1")
                .contact(new Contact("苟声","www.gousheng.com","name@example.com"))   //联系人
                .license("The GouSheng License")
                .licenseUrl("http://www.licenseTest.com")
                .termsOfServiceUrl("localhost:8080/demo1/")
                .build();
    }
}
