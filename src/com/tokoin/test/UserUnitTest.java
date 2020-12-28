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
import com.tokoin.service.UserService;

public class UserUnitTest {
	
	private UserRepositoryImpl userRepositoryTest;
	private OrganizationRepositoryImpl organizationRepositoryTest;
	private TicketRepositoryImpl ticketRepositoryTest;

	private UserService userService;
	private List<User> users= new ArrayList<User>();

	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		userRepositoryTest = mock(UserRepositoryImpl.class);
		organizationRepositoryTest = mock(OrganizationRepositoryImpl.class);
		ticketRepositoryTest = mock(TicketRepositoryImpl.class);
		Type collectionType = new TypeToken<Collection<User>>() {}.getType();
		users = (List<User>) new Gson().fromJson(SetUpData.USER, collectionType);
		
		userService = new UserService(organizationRepositoryTest, ticketRepositoryTest, userRepositoryTest);
	}
	
	@Test
	public void testLoadUsers() {
		when(userRepositoryTest.loadUsers()).thenReturn(users);
		assertEquals(userRepositoryTest.loadUsers(), users);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindUserById() {
		Type collectionType = new TypeToken<Collection<User>>() {}.getType();
		List<User> userById = (List<User>) new Gson().fromJson(SetUpMockReturnData.USER_BY_ID, collectionType);
		when(userRepositoryTest.findUserById(1)).thenReturn(userById);
		assertEquals(userRepositoryTest.findUserById(1), userById);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindUserWithOrganizationAndTicket() {
		Type collectionTypeUser = new TypeToken<Collection<User>>() {}.getType();
		List<User> userById = (List<User>) new Gson().fromJson(SetUpMockReturnData.USER_BY_ID_54, collectionTypeUser);
		when(userRepositoryTest.findUserByTerm("_id", "54")).thenReturn(userById);
		
		Type collectionTypeTicket = new TypeToken<Collection<Ticket>>() {}.getType();
		List<Ticket> ticketByAssignee = (List<Ticket>) new Gson().fromJson(SetUpMockReturnData.TICKET_BY_ASSIGNEE_54, collectionTypeTicket);
		when(ticketRepositoryTest.findTicketByAssigneeId(54)).thenReturn(ticketByAssignee);
		List<Ticket> ticketBySubmitter = (List<Ticket>) new Gson().fromJson(SetUpMockReturnData.TICKET_BY_SUBMITTER_54, collectionTypeTicket);
		when(ticketRepositoryTest.findTicketBySubmitterId(54)).thenReturn(ticketBySubmitter);
		
		Type collectionTypeOrganization = new TypeToken<Collection<Organization>>() {}.getType();
		List<Organization> organizationById = (List<Organization>) new Gson().fromJson(SetUpMockReturnData.ORGANIZATION_ID_124, collectionTypeOrganization);
		when(organizationRepositoryTest.findOrganizationById(124)).thenReturn(organizationById);
		
		assertTrue(userService.searchUser("_id", "54").toString().equals(SetUpMockReturnData.USER_ID_54_RESULT));
	}
	
	@Test
	public void testFindUserButNotFound() {
		when(userRepositoryTest.findUserByTerm("_id", "54")).thenReturn(null);
		assertTrue(userService.searchUser("_id", "90").toString().equals(SetUpMockReturnData.USER_NOT_FOUND));
	}
	
	@Test
	public void testFindUserInputWrongTerm() {
		List<User> emptyUser = new ArrayList<User>();
		assertEquals(userRepositoryTest.findUserByTerm("_id1", "54"),emptyUser);
	}
}
