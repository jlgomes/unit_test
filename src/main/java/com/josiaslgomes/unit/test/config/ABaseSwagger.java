package com.josiaslgomes.unit.test.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Predicates;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;



public abstract class ABaseSwagger {
	
	public abstract String getTitle();
	public abstract String getSubTitle();
	public abstract String getTag();

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.ant("/**"))
				.build().pathMapping("/")
				.securitySchemes(Collections.singletonList(new ApiKey("APIKEY", HttpHeaders.AUTHORIZATION, "HEADER")))
				.securityContexts(Collections.singletonList(
						SecurityContext.builder().securityReferences(authorization()).forPaths(PathSelectors.ant("/**"))
								.forPaths(Predicates.not(PathSelectors.ant("/controller/authentication/**"))).build()))
				.apiInfo(new ApiInfo(getTitle(), getSubTitle(), getTag(),
						"Terms of Service: TODO",
						new Contact("Josias Gomes", "http://lattes.cnpq.br/4486583818819599", "josiaslgomes.jg@gmail.com"),
						"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0",
						Collections.singleton(new VendorExtension<String>() {
							@Override
							public String getName() {
								return "Josias Gomes Lima";
							}

							@Override
							public String getValue() {
								return "josiaslgomes";
							}
						})));
	}

	 
	private List<SecurityReference> authorization() {
		AuthorizationScope scope = new AuthorizationScope("REST", "Authorized REST Services");
		AuthorizationScope[] scopes = new AuthorizationScope[1];
		scopes[0] = scope;
		return Collections.singletonList(new SecurityReference("APIKEY", scopes));
	}
}
