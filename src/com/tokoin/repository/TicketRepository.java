package com.tokoin.repository;

import java.util.List;

import com.tokoin.model.Ticket;

public interface TicketRepository {
	
	public List<Ticket> loadTickets();
	
	public List<Ticket> findTicketByTerm(String term, String value);
	
	public List<Ticket> findTicketByOrganizationId(int organizationId);
	
	public List<Ticket> findTicketByAssigneeId(int assigneeId);
	
	public List<Ticket> findTicketBySubmitterId(int submitterId);
}
