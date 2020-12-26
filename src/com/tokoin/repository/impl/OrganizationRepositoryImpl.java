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
import com.tokoin.model.Organization;
import com.tokoin.repository.OrganizationRepository;

public class OrganizationRepositoryImpl implements OrganizationRepository{

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> loadOrganization() {
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

	@Override
	public List<Organization> findOrganizationByTerm(String term, String value) {
		switch (term) {
		case "_id":
			return loadOrganization().stream()
					 .filter(organization -> organization.getId() == Integer.parseInt(value))
					 .collect(Collectors.toList());
		case "external_id":
			return loadOrganization().stream()
					 .filter(organization -> organization.getExternalId().equals(value))
					 .collect(Collectors.toList());
		case "name":
			return loadOrganization().stream()
					 .filter(organization -> organization.getName().equals(value))
					 .collect(Collectors.toList());
		case "domain_names":
			return loadOrganization().stream()
					 .filter(organization -> organization.getDomainNames().stream()
							 .anyMatch(domainName -> domainName.equals(value)))
					 .collect(Collectors.toList());
		case "details":
			return loadOrganization().stream()
					 .filter(organization -> organization.getDetails().equals(value))
					 .collect(Collectors.toList());
		case "tags":
			return loadOrganization().stream()
					 .filter(organization -> organization.getTags().stream()
							 .anyMatch(tag -> tag.equals(value)))
					 .collect(Collectors.toList());
		default:
			return null;
		}
	}

	@Override
	public List<Organization> findOrganizationById(int organizationId) {
		return loadOrganization().stream()
				 .filter(organization -> organization.getId() == organizationId)
				 .collect(Collectors.toList());
	}

}
