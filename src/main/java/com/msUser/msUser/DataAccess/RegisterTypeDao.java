package com.msUser.msUser.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msUser.msUser.Entity.RegisterType;

public interface RegisterTypeDao extends JpaRepository<RegisterType, Integer> {
	
	RegisterType findByName(String typeName );
	
	
	RegisterType findByTypeCode(String typeCode );



}
