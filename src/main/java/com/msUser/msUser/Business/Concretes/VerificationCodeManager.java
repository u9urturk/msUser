package com.msUser.msUser.Business.Concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msUser.msUser.Business.Abstracts.VerificationCodeService;
import com.msUser.msUser.Core.Utilities.Results.ErrorResult;
import com.msUser.msUser.Core.Utilities.Results.Result;
import com.msUser.msUser.Core.Utilities.Results.SuccessResult;
import com.msUser.msUser.Core.Utilities.Security.VerificationCodeGenerator;
import com.msUser.msUser.DataAccess.UserDao;
import com.msUser.msUser.Entity.User;

@Service
public class VerificationCodeManager implements VerificationCodeService {
	
	private UserDao dao;
	private VerificationCodeGenerator codeGenerator;
	
	@Autowired
	public VerificationCodeManager(UserDao dao, VerificationCodeGenerator codeGenerator) {
		super();
		this.dao = dao;
		this.codeGenerator = codeGenerator;
	}

	@Override
	public Result getVerificationCode(Long userId) {
		User user = new User();
	   String code = new String();
	   code= this.codeGenerator.generateVerificationCode();
	   
	   User existingUser = dao.findById(userId).orElse(null);
		if(existingUser == null) {
			return new ErrorResult("User not found with id  : " + user.getId());
		}
		
		existingUser.setFirstName(user.getFirstName()==null?existingUser.getFirstName():user.getFirstName());
		existingUser.setLastName(user.getLastName()==null?existingUser.getLastName():user.getLastName());
		existingUser.setVerificationCode(code==null?existingUser.getVerificationCode():code);
		
		dao.save(existingUser);
	  return new SuccessResult("Doğrulama kodu gönderildi.  : " + code);
	}

	@Override
	public Result verifyAccount(Long userId, String code) {
		User existingUser = dao.findById(userId).orElse(null);

		if(existingUser == null) {
			return new ErrorResult("User not found with id  : " + userId);
		}else if(!code.equals(existingUser.getVerificationCode())) {
			return new ErrorResult("Hesap doğrulanamadı");
		}
		
		
		existingUser.setValid(true);
		
		dao.save(existingUser);
	  return new SuccessResult("Hesap doğrulandı");
	}

	

}
