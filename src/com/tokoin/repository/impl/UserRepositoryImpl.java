package com.tokoin.repository.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tokoin.model.User;
import com.tokoin.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> loadUsers() {
		List<User> users = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\com\\tokoin\\resources\\users.json"));
			Type collectionType = new TypeToken<Collection<User>>() {}.getType();
			users = (List<User>) new Gson().fromJson(br, collectionType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<User> findUserByTerm(String term, String value) {
		switch (term) {
		case "_id":
			return loadUsers().stream().filter(user -> user.getId() == Integer.parseInt(value))
					.collect(Collectors.toList());
		case "external_id":
			return loadUsers().stream().filter(user -> user.getExternalId().equals(value)).collect(Collectors.toList());
		case "name":
			return loadUsers().stream().filter(user -> user.getName().equals(value)).collect(Collectors.toList());
		case "alias":
			return loadUsers().stream().filter(user -> user.getAlias().equals(value)).collect(Collectors.toList());
		case "active":
			return loadUsers().stream().filter(user -> user.isActive() == Boolean.parseBoolean(value))
					.collect(Collectors.toList());
		case "verified":
			return loadUsers().stream().filter(user -> user.isVerified() == Boolean.parseBoolean(value))
					.collect(Collectors.toList());
		case "shared":
			return loadUsers().stream().filter(user -> user.isShared() == Boolean.parseBoolean(value))
					.collect(Collectors.toList());
		case "locale":
			return loadUsers().stream().filter(user -> user.getLocale().equals(value))
					.collect(Collectors.toList());	
		case "timezone":
			return loadUsers().stream().filter(user -> user.getTimezone().equals(value)).collect(Collectors.toList());
		case "email":
			return loadUsers().stream().filter(user -> user.getEmail().equals(value)).collect(Collectors.toList());
		case "phone":
			return loadUsers().stream().filter(user -> user.getPhone().equals(value)).collect(Collectors.toList());
		case "signature":
			return loadUsers().stream().filter(user -> user.getSignature().equals(value)).collect(Collectors.toList());
		case "organization_id":
			return loadUsers().stream().filter(user -> user.getOrganizationId() == Integer.parseInt(value))
					.collect(Collectors.toList());
		case "tags":
			return loadUsers().stream().filter(user -> user.getTags().stream().anyMatch(tag -> tag.equals(value)))
					.collect(Collectors.toList());
		case "role":
			return loadUsers().stream().filter(user -> user.getRole().equals(value)).collect(Collectors.toList());
		default:
			return null;
		}
	}

	@Override
	public List<User> findUserByOrganizationId(int organizationId) {
		return loadUsers().stream().filter(user -> user.getOrganizationId() == organizationId)
				.collect(Collectors.toList());
	}

	@Override
	public List<User> findUserById(int userId) {
		return loadUsers().stream().filter(user -> user.getId() == userId)
				.collect(Collectors.toList());
	}
}
