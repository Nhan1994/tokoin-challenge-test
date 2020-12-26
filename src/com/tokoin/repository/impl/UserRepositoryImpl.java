package com.tokoin.repository.impl;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;
import com.tokoin.model.User;
import com.tokoin.repository.UserRepository;
import com.tokoin.utils.JsonReader;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<User> loadUsers() {
		List<User> users = new ArrayList<>();
		try {
			Type collectionType = new TypeToken<Collection<User>>() {}.getType();
			users = JsonReader.readJsonFromFile("src\\com\\tokoin\\data\\users.json", collectionType);
		} catch (FileNotFoundException e) {
			System.out.println("Json file not found");
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
			System.out.println("The term you input doesn't exist");
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
