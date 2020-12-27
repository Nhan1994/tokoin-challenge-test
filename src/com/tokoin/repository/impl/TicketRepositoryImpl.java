package com.tokoin.repository.impl;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;
import com.tokoin.model.Ticket;
import com.tokoin.repository.TicketRepository;
import com.tokoin.utils.JsonReader;

public class TicketRepositoryImpl implements TicketRepository {

	@Override
	public List<Ticket> loadTickets() {
		List<Ticket> tickets = new ArrayList<>();
		try {
			Type collectionType = new TypeToken<Collection<Ticket>>() {}.getType();
			JsonReader.getJsonPath();
			tickets = JsonReader.readJsonFromFile(JsonReader.TICKET_PATH, collectionType);
		} catch (FileNotFoundException e) {
			System.out.println("Json file not found");
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
			System.out.println("The term you input doesn't exist");
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
