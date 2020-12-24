package com.tokoin.repository.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tokoin.model.User;
import com.tokoin.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserByTerm() {
		List<User> users = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\com\\tokoin\\resources\\users.json"));
			Type collectionType = new TypeToken<Collection<User>>(){}.getType(); 
			users = (List<User>) new Gson().fromJson(br, collectionType); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
