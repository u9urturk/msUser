package com.msUser.msUser.Core.Utilities.Security;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.msUser.msUser.Business.Abstracts.UserService;
import com.msUser.msUser.Entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService service;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		OAuth2User oAuth2User = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Map<String, Object> attributes = oAuth2User.getAttributes();

		User user = new User();

		if (attributes.get("login") != null) {
			String fullName = oAuth2User.getAttribute("name");
			String[] nameParts = fullName.split(" ");

			String firstName = "";
			String lastName = "";

			if (nameParts.length > 0) {
				firstName = nameParts[0];
			}

			if (nameParts.length > 1) {
				lastName = nameParts[nameParts.length - 1];
			}
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setRegisterType(2);
		} else if (attributes.get("sub") != null) {
			user.setFirstName(attributes.get("given_name").toString());
			user.setLastName(attributes.get("family_name").toString());
			user.setRegisterType(3);

		} else {
			System.out.println("diğer");
		}
		
//		service.add(user);
		
		 response.sendRedirect("/swagger-ui.html");

	}

}
