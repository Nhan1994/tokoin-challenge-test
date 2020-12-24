package com.tokoin.repository;

import java.util.List;

import com.tokoin.model.Ticket;

public interface TicketRepository {
	
	public List<Ticket> findTicketByTerm();
}
