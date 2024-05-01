package com.msUser.msUser.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msUser.msUser.Business.Abstracts.RegisterTypeService;
import com.msUser.msUser.Core.Utilities.Results.DataResult;
import com.msUser.msUser.Core.Utilities.Results.Result;
import com.msUser.msUser.Entity.RegisterType;

@RestController
@RequestMapping("/api/registertype")
public class RegisterTypeController {

	RegisterTypeService registerTypeService;

	public RegisterTypeController(RegisterTypeService registerTypeService) {
		super();
		this.registerTypeService = registerTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody RegisterType registerType ) {
		return registerTypeService.add(registerType);
	}
	
	@GetMapping("/getAll")
	DataResult<List<RegisterType>> getAll(){
		return registerTypeService.getAll();
	}
	
//	DataResult<RegisterType> getByTypeName(String typeName);
//	
//	DataResult<RegisterType> getByTypeCode(String typeCode);

}
