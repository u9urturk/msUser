package com.msUser.msUser.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msUser.msUser.Business.Abstracts.RegisterTypeService;
import com.msUser.msUser.Core.Utilities.Results.DataResult;
import com.msUser.msUser.Core.Utilities.Results.Result;
import com.msUser.msUser.Core.Utilities.Results.SuccessDataResult;
import com.msUser.msUser.Core.Utilities.Results.SuccessResult;
import com.msUser.msUser.DataAccess.RegisterTypeDao;
import com.msUser.msUser.Entity.RegisterType;

@Service
public class RegisterTypeManager implements RegisterTypeService {
	
	RegisterTypeDao dao;
	
	@Autowired
	public RegisterTypeManager(RegisterTypeDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Result add(RegisterType registerType) {
		dao.save(registerType);
		return new SuccessResult("Başarıyla Eklendi : " + registerType.getName());
	}

	@Override
	public Result delete(RegisterType registerType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(RegisterType registerType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<RegisterType>> getAll() {
		return new SuccessDataResult<List<RegisterType>>(dao.findAll(), "Veriler Getirildi");
	}

	@Override
	public DataResult<RegisterType> getByTypeName(String typeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<RegisterType> getByTypeCode(String typeCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
