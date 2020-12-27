package com.tokoin.repository.impl;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;
import com.tokoin.model.Organization;
import com.tokoin.repository.OrganizationRepository;
import com.tokoin.utils.JsonReader;

public class OrganizationRepositoryImpl implements OrganizationRepository{

	@Override
	public List<Organization> loadOrganization() {
		List<Organization> organizations = new ArrayList<>();
		try {
			Type collectionType = new TypeToken<Collection<Organization>>() {}.getType();
			JsonReader.getJsonPath();
			organizations = JsonReader.readJsonFromFile(JsonReader.ORGANIZATION_PATH, collectionType);
		} catch (FileNotFoundException e) {
			System.out.println("Json file not found");
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
			System.out.println("The term you input doesn't exist");
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
