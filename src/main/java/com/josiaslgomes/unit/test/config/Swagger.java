package com.josiaslgomes.unit.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger extends ABaseSwagger{
	
	@RequestMapping("/")
	public String greeting() {
		return "index";
	}
	
	public  String getTitle() {
		return "Unit Test";
	}
	
	public String getSubTitle(){
		return "Documentação para as apis do projeto unit test";
	}
	
	public String getTag(){
		return "DEVELOPMENT";
	}
	
}
