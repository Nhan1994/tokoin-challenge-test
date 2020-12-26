package com.tokoin.repository.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tokoin.model.Ticket;
import com.tokoin.repository.TicketRepository;

public class TicketRepositoryImpl implements TicketRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> loadTickets() {
		List<Ticket> tickets = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\com\\tokoin\\resources\\tickets.json"));
			Type collectionType = new TypeToken<Collection<Ticket>>() {
			}.getType();
			tickets = (List<Ticket>) new Gson().fromJson(br, collectionType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public List<Ticket> findTicketByTerm(String term, String value) {
		switch (term) {
		case "_id":
			return loadTickets().stream().filter(ticket -> ticket.getId().equals(value)).collect(Collectors.toList());
		case "external_id":
			return loadTickets().stream().filter(ticket -> ticket.getExternalId().equals(value))
					.collect(Collectors.toList());
		case "type":
			return loadTickets().stream().filter(ticket -> ticket.getType().equals(value)).collect(Collectors.toList());
		case "subject":
			return loadTickets().stream().filter(ticket -> ticket.getSubject().equals(value))
					.collect(Collectors.toList());
		case "description":
			return loadTickets().stream().filter(ticket -> ticket.getDescription().equals(value))
					.collect(Collectors.toList());
		case "priority":
			return loadTickets().stream().filter(ticket -> ticket.getPriority().equals(value))
					.collect(Collectors.toList());
		case "status":
			return loadTickets().stream().filter(ticket -> ticket.getStatus().equals(value))
					.collect(Collectors.toList());
		case "submitter_id":
			return loadTickets().stream().filter(ticket -> ticket.getSubmitterId() == Integer.parseInt(value))
					.collect(Collectors.toList());
		case "assignee_id":
			return loadTickets().stream().filter(ticket -> ticket.getAssigneeId() == Integer.parseInt(value))
					.collect(Collectors.toList());
		case "organization_id":
			return loadTickets().stream().filter(ticket -> ticket.getOrganizationId() == Integer.parseInt(value))
					.collect(Collectors.toList());
		case "via":
			return loadTickets().stream().filter(ticket -> ticket.getVia().equals(value)).collect(Collectors.toList());
		case "tags":
			return loadTickets().stream().filter(ticket -> ticket.getTags().stream().anyMatch(tag -> tag.equals(value)))
					.collect(Collectors.toList());
		default:
			return null;
		}
	}

	@Override
	public List<Ticket> findTicketByOrganizationId(int organizationId) {
		return loadTickets().stream().filter(ticket -> ticket.getOrganizationId() == organizationId)
				.collect(Collectors.toList());
	}

	@Override
	public List<Ticket> findTicketByAssigneeId(int assigneeId) {
		return loadTickets().stream().filter(ticket -> ticket.getAssigneeId() == assigneeId)
				.collect(Collectors.toList());
	}

	@Override
	public List<Ticket> findTicketBySubmitterId(int submitterId) {
		return loadTickets().stream().filter(ticket -> ticket.getSubmitterId() == submitterId)
				.collect(Collectors.toList());
	}

}
