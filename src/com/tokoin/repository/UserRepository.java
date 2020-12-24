package com.tokoin.repository;

import java.util.List;

import com.tokoin.model.User;

public interface UserRepository {
	public List<User> findUserByTerm();
}
