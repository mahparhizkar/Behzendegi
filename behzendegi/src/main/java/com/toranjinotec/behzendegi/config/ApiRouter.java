package com.toranjinotec.behzendegi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ApiRouter {

	@Bean
	  public RouterFunction<ServerResponse> route(ApiHandler exampleHandler) {
	    return RouterFunctions
	        .route(RequestPredicates.GET("/api").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), exampleHandler::hello);
	  }
}
