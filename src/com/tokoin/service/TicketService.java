package com.tokoin.service;

import java.util.List;

import com.tokoin.model.Ticket;
import com.tokoin.repository.impl.TicketRepositoryImpl;

public class TicketService {

	private TicketRepositoryImpl ticketRepositoryImpl;

	public TicketService(TicketRepositoryImpl ticketRepositoryImpl) {
		super();
		this.ticketRepositoryImpl = ticketRepositoryImpl;
	}
	
	public List<Ticket> findTicket(){
		return ticketRepositoryImpl.findTicketByTerm();
	}
}
