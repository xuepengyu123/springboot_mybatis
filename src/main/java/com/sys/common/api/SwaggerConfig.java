package com.sys.common.api;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("manageSys").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.sys.manage.controller")).paths(PathSelectors.any()).build();
	}
	// 预览地址:swagger-ui.html
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("manageSys系统swagger2文档").termsOfServiceUrl("git")
				.contact(new Contact("薛鹏宇 ", "git地址", null)).version("1.1").build();
	}
}