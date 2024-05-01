package com.msUser.msUser.Core.Utilities.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	  @Autowired
	    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	  
	  private static final String[] SWAGGER_WHITELIST = {
		"/swagger-ui/**",
		"/v3/api/doc/**",
		"/swagger-resources/**",
		"/swagger-resources"
	  };
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		    .csrf().disable()
			.authorizeHttpRequests()
			
			.anyRequest().authenticated()
			.and()
			.oauth2Login().successHandler(customAuthenticationSuccessHandler);
		
		
		return http.build();
	}
}
