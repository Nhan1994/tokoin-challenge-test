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
import com.tokoin.model.Organization;
import com.tokoin.repository.OrganizationRepository;

public class OrganizationRepositoryImpl implements OrganizationRepository{

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> findOrganizationByTerm() {
		List<Organization> organizations = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\com\\tokoin\\resources\\organizations.json"));
			Type collectionType = new TypeToken<Collection<Organization>>(){}.getType(); 
			organizations = (List<Organization>) new Gson().fromJson(br, collectionType); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return organizations;
	}

}
