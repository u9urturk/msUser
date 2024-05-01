package com.msUser.msUser.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msUser.msUser.Business.Abstracts.UserService;
import com.msUser.msUser.Core.Utilities.Results.DataResult;
import com.msUser.msUser.Core.Utilities.Results.ErrorResult;
import com.msUser.msUser.Core.Utilities.Results.Result;
import com.msUser.msUser.Core.Utilities.Results.SuccessDataResult;
import com.msUser.msUser.Core.Utilities.Results.SuccessResult;
import com.msUser.msUser.DataAccess.UserDao;
import com.msUser.msUser.Entity.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new 	SuccessResult("Veri eklendi.");
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult("Silindi.");
	}

	@Override
	public Result update(User user) {
		User existingUser = userDao.findById(user.getId()).orElse(null);
		if(existingUser == null) {
			return new ErrorResult("User not found with id  : " + user.getId());
		}
		
		existingUser.setFirstName(user.getFirstName()==null?existingUser.getFirstName():user.getFirstName());
		existingUser.setLastName(user.getLastName()==null?existingUser.getLastName():user.getLastName());
		
		userDao.save(existingUser);	
		return new SuccessResult("Güncellendi");


	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Başarılı");
	}

	

	

}
