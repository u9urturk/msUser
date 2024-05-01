package com.msUser.msUser.Business.Abstracts;

import com.msUser.msUser.Core.Utilities.Results.Result;

public interface VerificationCodeService {
	Result  getVerificationCode(Long userId);
	
	Result verifyAccount(Long userId,String code);

}
