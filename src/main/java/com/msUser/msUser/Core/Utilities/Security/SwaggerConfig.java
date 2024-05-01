package com.msUser.msUser.Core.Utilities.Security;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {
	@Bean
	GroupedOpenApi  api() {
		return GroupedOpenApi.builder()
				.group("public-apis")
				.pathsToMatch("/**")
				.build();
	}
	
	
}
