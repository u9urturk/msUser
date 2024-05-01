package com.msUser.msUser.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msUser.msUser.Core.Utilities.Results.DataResult;
import com.msUser.msUser.Core.Utilities.Results.SuccessDataResult;

@RestController
@RequestMapping("/api/login")
public class AuthController {
	
	@GetMapping()
	public DataResult<String> hello(){
		return new SuccessDataResult<String>("Hello from secure endpoint");
	}

}
