package com.tokoin.repository;

import java.util.List;

import com.tokoin.model.User;

public interface UserRepository {
	public List<User> loadUsers();
	
	public List<User> findUserByTerm(String term, String value);
	
	public List<User> findUserByOrganizationId(int organizationId);
	
	public List<User> findUserById(int userId);
}
