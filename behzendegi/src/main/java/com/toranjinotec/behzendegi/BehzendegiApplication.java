package com.toranjinotec.behzendegi;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.toranjinotec.behzendegi.controllers.HomeController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@EnableSwagger2WebFlux
@ComponentScan(basePackageClasses = { HomeController.class })
public class BehzendegiApplication {
	
	private static final String API_VERSION = "1.0.1";
	private static final String LICENSE_TEXT = "Toranjinotec.com License";
	private static final String TITLE = "Behzendegi API";
	private static final String DESCRIPTION = "Online Insurance Store API";

	public static void main(String[] args) {
		SpringApplication.run(BehzendegiApplication.class, args);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).version(API_VERSION).description(DESCRIPTION).license(LICENSE_TEXT)
				.build();
	}

	@Bean
	public Docket behzendegiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.toranjinotec.behzendegi.controllers"))
				.paths(PathSelectors.ant("/**")).build()
				.genericModelSubstitutes(Mono.class, Flux.class, Optional.class);
	}

}
