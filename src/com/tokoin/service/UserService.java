package com.tokoin.service;

import java.util.List;

import com.tokoin.model.User;
import com.tokoin.repository.impl.UserRepositoryImpl;

public class UserService {
	
	private UserRepositoryImpl userRepositoryImpl;

	public UserService(UserRepositoryImpl userRepositoryImpl) {
		super();
		this.userRepositoryImpl = userRepositoryImpl;
	}
	
	public List<User> getUsers(){
		return userRepositoryImpl.findUserByTerm();
	}
}
