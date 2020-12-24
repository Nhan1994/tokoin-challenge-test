package com.tokoin.service;

import java.util.List;

import com.tokoin.model.Organization;
import com.tokoin.repository.impl.OrganizationRepositoryImpl;

public class OrganizationService {
	private OrganizationRepositoryImpl organizationRepositoryImpl;

	public OrganizationService(OrganizationRepositoryImpl organizationRepositoryImpl) {
		super();
		this.organizationRepositoryImpl = organizationRepositoryImpl;
	}
	
	public List<Organization> findOrganization(){
		return organizationRepositoryImpl.findOrganizationByTerm();
	}
}
