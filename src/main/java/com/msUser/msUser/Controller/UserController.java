package com.msUser.msUser.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msUser.msUser.Business.Abstracts.UserService;
import com.msUser.msUser.Core.Utilities.Results.DataResult;
import com.msUser.msUser.Core.Utilities.Results.Result;
import com.msUser.msUser.Entity.User;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.service.getAll();
	}
	@GetMapping("/getbyphonenumber")
	DataResult<User> findByPhoneNumber(@RequestParam String phoneNumber){
		return this.service.findByPhoneNumber(phoneNumber);
	}
	
	@PostMapping("/addUser")
	public 	Result add(@RequestBody User user) {
		return this.service.add(user);
	}
	
	@PostMapping("/updateUser")
	public 	Result update(@RequestBody User user) {
		return this.service.update(user);
	}
	
	@DeleteMapping("/deleteUser")
	Result delete(@RequestBody User user) {
		return this.service.delete(user);
	}

 
	
	

}
