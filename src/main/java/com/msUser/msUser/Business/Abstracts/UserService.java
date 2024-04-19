package com.msUser.msUser.Business.Abstracts;

import java.util.List;

import com.msUser.msUser.Core.Utilities.Results.DataResult;
import com.msUser.msUser.Core.Utilities.Results.Result;
import com.msUser.msUser.Entity.User;

public interface UserService {
	Result add(User user);

	Result delete(User user);

	Result update(User user);

	DataResult<List<User>> getAll();

	DataResult<User> findByPhoneNumber(String phoneNumber);
}
//