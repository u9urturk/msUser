package com.msUser.msUser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msUser.msUser.Business.Abstracts.VerificationCodeService;
import com.msUser.msUser.Core.Utilities.Results.Result;

@RestController
@RequestMapping("/api/verificationcode")
public class VerificationCodeController {
	
	
	private VerificationCodeService codeService;
	@Autowired
	public VerificationCodeController(VerificationCodeService codeService) {
		super();
		this.codeService = codeService;
	}
	
	
	@PostMapping("/getcode")
	Result  getVerificationCode(Long userId) {
		return this.codeService.getVerificationCode(userId);
	}
	
	
	@PostMapping("/verifyaccount")
	Result verifyAccount(Long userId,String code) {
		return this.codeService.verifyAccount(userId, code);
	}

}
