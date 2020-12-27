package com.tokoin.service;

import java.util.List;

import com.tokoin.model.Organization;
import com.tokoin.model.Ticket;
import com.tokoin.model.User;
import com.tokoin.repository.impl.OrganizationRepositoryImpl;
import com.tokoin.repository.impl.TicketRepositoryImpl;
import com.tokoin.repository.impl.UserRepositoryImpl;
import com.tokoin.utils.PrintObject;

public class TicketService {

	private OrganizationRepositoryImpl organizationRepositoryImpl;
	private TicketRepositoryImpl ticketRepositoryImpl;
	private UserRepositoryImpl userRepositoryImpl;

	public TicketService(OrganizationRepositoryImpl organizationRepositoryImpl,
			TicketRepositoryImpl ticketRepositoryImpl, UserRepositoryImpl userRepositoryImpl) {
		this.organizationRepositoryImpl = organizationRepositoryImpl;
		this.ticketRepositoryImpl = ticketRepositoryImpl;
		this.userRepositoryImpl = userRepositoryImpl;
	}
	
	public StringBuilder searchTicket(String term, String value) {
		List<Ticket> tickets = ticketRepositoryImpl.findTicketByTerm(term, value);

		StringBuilder strBuilder = new StringBuilder();
		if (tickets != null && !tickets.isEmpty()) {
			tickets.forEach(ticket -> {
				PrintObject.appendObjectResult(ticket, strBuilder);
				searchAndPrintTicketAssignees(strBuilder, ticket);
				searchAndPrintTicketSubmitters(strBuilder, ticket);
				searchAndPrintTicketOrganizations(strBuilder, ticket);
			});
		} else {
			PrintObject.printNoResultFound("tickets", term, value, strBuilder);
		}
		return strBuilder;
	}

	private void searchAndPrintTicketOrganizations(StringBuilder strBuilder, Ticket ticket) {
		List<Organization> organizations = organizationRepositoryImpl.findOrganizationById(ticket.getOrganizationId());
		if (organizations != null && !organizations.isEmpty()) {
			for (int i = 0 ; i < organizations.size() ; i++) {
				strBuilder.append("\norganization_" + i + "    " +  organizations.get(i).getName());
			}
		}
	}

	private void searchAndPrintTicketSubmitters(StringBuilder strBuilder, Ticket ticket) {
		List<User> submitterUsers = userRepositoryImpl.findUserById(ticket.getSubmitterId());
		if (submitterUsers != null && !submitterUsers.isEmpty()) {
			for (int i = 0 ; i < submitterUsers.size() ; i++) {
				strBuilder.append("\nsubmitter_user_" + i + "    " +  submitterUsers.get(i).getName());
			}
		}
	}

	private void searchAndPrintTicketAssignees(StringBuilder strBuilder, Ticket ticket) {
		List<User> assigneeUsers = userRepositoryImpl.findUserById(ticket.getAssigneeId());
		if (assigneeUsers != null && !assigneeUsers.isEmpty()) {
			for (int i = 0 ; i < assigneeUsers.size() ; i++) {
				strBuilder.append("\nassignee_user_" + i + "    " +  assigneeUsers.get(i).getName());
			}
		}
	}
}
