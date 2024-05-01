package com.msUser.msUser.Business.Abstracts;

import java.util.List;

import com.msUser.msUser.Core.Utilities.Results.DataResult;
import com.msUser.msUser.Core.Utilities.Results.Result;
import com.msUser.msUser.Entity.RegisterType;

public interface RegisterTypeService {

	Result add(RegisterType registerType );

	Result delete(RegisterType registerType);

	Result update(RegisterType registerType);

	DataResult<List<RegisterType>> getAll();
	
	DataResult<RegisterType> getByTypeName(String typeName);
	
	DataResult<RegisterType> getByTypeCode(String typeCode);



}
