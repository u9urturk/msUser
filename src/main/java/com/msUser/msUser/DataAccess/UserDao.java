package com.msUser.msUser.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msUser.msUser.Entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByPhoneNumber(String phoneNumber);
}
