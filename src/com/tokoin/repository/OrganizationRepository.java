package com.tokoin.repository;

import java.util.List;

import com.tokoin.model.Organization;

public interface OrganizationRepository {
	
	public List<Organization> findOrganizationByTerm();
}
