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
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2Login().successHandler(customAuthenticationSuccessHandler);
			;
		
		
		return httpSecurity.build();
	}
}
