package com.tokoin.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tokoin.model.Organization;
import com.tokoin.model.Ticket;
import com.tokoin.model.User;
import com.tokoin.repository.impl.OrganizationRepositoryImpl;
import com.tokoin.repository.impl.TicketRepositoryImpl;
import com.tokoin.repository.impl.UserRepositoryImpl;
import com.tokoin.service.OrganizationService;

public class OrganizationUnitTest {
	private UserRepositoryImpl userRepositoryTest;
	private OrganizationRepositoryImpl organizationRepositoryTest;
	private TicketRepositoryImpl ticketRepositoryTest;

	private OrganizationService organizationService;
	private List<Organization> organizations= new ArrayList<Organization>();
	
	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		userRepositoryTest = mock(UserRepositoryImpl.class);
		organizationRepositoryTest = mock(OrganizationRepositoryImpl.class);
		ticketRepositoryTest = mock(TicketRepositoryImpl.class);
		Type collectionType = new TypeToken<Collection<Organization>>() {}.getType();
		organizations = (List<Organization>) new Gson().fromJson(SetUpData.ORGANIZATION, collectionType);
		
		organizationService = new OrganizationService(organizationRepositoryTest, ticketRepositoryTest, userRepositoryTest);
	}
	
	@Test
	public void testLoadOrganizations() {
		when(organizationRepositoryTest.loadOrganization()).thenReturn(organizations);
		assertEquals(organizationRepositoryTest.loadOrganization(), organizations);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindOrganizationId() {
		Type collectionType = new TypeToken<Collection<Organization>>() {}.getType();
		List<Organization> organizationById = (List<Organization>) new Gson().fromJson(SetUpMockReturnData.ORGANIZATION_ID_124, collectionType);
		when(organizationRepositoryTest.findOrganizationById(124)).thenReturn(organizationById);
		assertEquals(organizationRepositoryTest.findOrganizationById(124), organizationById);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindOrganizationWithUserAndTicket() {
		Type collectionTypeUser = new TypeToken<Collection<User>>() {}.getType();
		List<User> userById = (List<User>) new Gson().fromJson(SetUpMockReturnData.USER_BY_ID_54, collectionTypeUser);
		when(userRepositoryTest.findUserByOrganizationId(124)).thenReturn(userById);
		
		Type collectionTypeTicket = new TypeToken<Collection<Ticket>>() {}.getType();
		List<Ticket> ticketByOrganizationId = (List<Ticket>) new Gson().fromJson(SetUpMockReturnData.TICKET_BY_ORGANIZATION_124, collectionTypeTicket);
		when(ticketRepositoryTest.findTicketByOrganizationId(124)).thenReturn(ticketByOrganizationId);
		
		Type collectionTypeOrganization = new TypeToken<Collection<Organization>>() {}.getType();
		List<Organization> organizationById = (List<Organization>) new Gson().fromJson(SetUpMockReturnData.ORGANIZATION_ID_124, collectionTypeOrganization);
		when(organizationRepositoryTest.findOrganizationByTerm("_id","124")).thenReturn(organizationById);
		assertTrue(organizationService.searchOrganization("_id", "124").toString().equals(SetUpMockReturnData.ORGANIZATION_ID_124_RESULT));
	}
	
	@Test
	public void testFindOrganizationNotFound() {
		when(organizationRepositoryTest.findOrganizationByTerm("_id", "90")).thenReturn(null);
		assertTrue(organizationService.searchOrganization("_id", "90").toString().equals(SetUpMockReturnData.ORGANIZATION_NOT_FOUND));
	}
}
