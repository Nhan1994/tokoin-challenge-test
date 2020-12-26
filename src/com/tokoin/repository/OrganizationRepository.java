package com.tokoin.repository;

import java.util.List;

import com.tokoin.model.Organization;

public interface OrganizationRepository {
	
	public List<Organization> loadOrganization();
	
	public List<Organization> findOrganizationById(int organizationId); 
	
	public List<Organization> findOrganizationByTerm(String key, String value);
	
}
