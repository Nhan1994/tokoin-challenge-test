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
import com.tokoin.service.TicketService;

public class TicketUnitTest {
	private UserRepositoryImpl userRepositoryTest;
	private OrganizationRepositoryImpl organizationRepositoryTest;
	private TicketRepositoryImpl ticketRepositoryTest;

	private TicketService ticketService;
	private List<Ticket> tickets= new ArrayList<Ticket>();

	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		userRepositoryTest = mock(UserRepositoryImpl.class);
		organizationRepositoryTest = mock(OrganizationRepositoryImpl.class);
		ticketRepositoryTest = mock(TicketRepositoryImpl.class);
		Type collectionType = new TypeToken<Collection<Ticket>>() {}.getType();
		tickets = (List<Ticket>) new Gson().fromJson(SetUpData.TICKET, collectionType);
		
		ticketService = new TicketService(organizationRepositoryTest, ticketRepositoryTest, userRepositoryTest);
	}
	
	@Test
	public void testLoadTickets() {
		when(ticketRepositoryTest.loadTickets()).thenReturn(tickets);
		assertEquals(ticketRepositoryTest.loadTickets(), tickets);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindTicketId() {
		Type collectionType = new TypeToken<Collection<Ticket>>() {}.getType();
		List<Ticket> ticketById = (List<Ticket>) new Gson().fromJson(SetUpMockReturnData.TICKET_BY_ASSIGNEE_54, collectionType);
		when(ticketRepositoryTest.findTicketById("828c158a-91e3-42b9-8aed-ac97407a150f")).thenReturn(ticketById);
		assertEquals(ticketRepositoryTest.findTicketById("828c158a-91e3-42b9-8aed-ac97407a150f"), ticketById);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindOrganizationWithUserAndTicket() {
		Type collectionTypeUser = new TypeToken<Collection<User>>() {}.getType();
		List<User> assigneeById = (List<User>) new Gson().fromJson(SetUpMockReturnData.USER_BY_ID_54, collectionTypeUser);
		when(userRepositoryTest.findUserById(54)).thenReturn(assigneeById);
		List<User> submitterById = (List<User>) new Gson().fromJson(SetUpMockReturnData.USER_BY_ID_72, collectionTypeUser);
		when(userRepositoryTest.findUserById(72)).thenReturn(submitterById);
		
		Type collectionType = new TypeToken<Collection<Ticket>>() {}.getType();
		List<Ticket> ticketById = (List<Ticket>) new Gson().fromJson(SetUpMockReturnData.TICKET_BY_ASSIGNEE_54, collectionType);
		when(ticketRepositoryTest.findTicketByTerm("_id","828c158a-91e3-42b9-8aed-ac97407a150f")).thenReturn(ticketById);
		
		Type collectionTypeOrganization = new TypeToken<Collection<Organization>>() {}.getType();
		List<Organization> organizationById = (List<Organization>) new Gson().fromJson(SetUpMockReturnData.ORGANIZATION_ID_116, collectionTypeOrganization);
		when(organizationRepositoryTest.findOrganizationById(116)).thenReturn(organizationById);
		assertTrue(ticketService.searchTicket("_id", "828c158a-91e3-42b9-8aed-ac97407a150f").toString().equals(SetUpMockReturnData.TICKET_RESULT));
	}
	
	@Test
	public void testFindOrganizationNotFound() {
		when(ticketRepositoryTest.findTicketByTerm("_id", "ba4feaec-47ac-483f-bc3d-2604f797e6f0")).thenReturn(null);
		assertTrue(ticketService.searchTicket("_id", "ba4feaec-47ac-483f-bc3d-2604f797e6f0").toString().equals(SetUpMockReturnData.TICKET_NOT_FOUND));
	}
	
	@Test
	public void testFindTicketInputWrongTerm() {
		List<Ticket> emptyTicket = new ArrayList<Ticket>();
		assertEquals(ticketRepositoryTest.findTicketByTerm("_id1", "5956549"),emptyTicket);
	}
}
