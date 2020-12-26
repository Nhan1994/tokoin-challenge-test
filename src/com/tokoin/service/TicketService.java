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
	
	public void searchTicket(String term, String value) {
		List<Ticket> tickets = ticketRepositoryImpl.findTicketByTerm(term, value);

		if (tickets != null && !tickets.isEmpty()) {
			StringBuilder strBuilder = new StringBuilder();
			tickets.forEach(ticket -> {
				PrintObject.printObjectResult(ticket);
				searchAndPrintTicketAssignees(strBuilder, ticket);
				searchAndPrintTicketSubmitters(strBuilder, ticket);
				searchAndPrintTicketOrganizations(strBuilder, ticket);
			});
			System.out.println(strBuilder.toString());
		} else {
			System.out.println("Search organization for " + term + " with a value of " + value);
			System.out.println("No result found");
		}
	}

	private void searchAndPrintTicketOrganizations(StringBuilder strBuilder, Ticket ticket) {
		List<Organization> organizations = organizationRepositoryImpl.findOrganizationById(ticket.getOrganizationId());
		if (organizations != null && !organizations.isEmpty()) {
			for (int i = 0 ; i < organizations.size() ; i++) {
				strBuilder.append("\n organization_" + i + "    " +  organizations.get(i).getName());
			}
		}
	}

	private void searchAndPrintTicketSubmitters(StringBuilder strBuilder, Ticket ticket) {
		List<User> submitterUsers = userRepositoryImpl.findUserById(ticket.getSubmitterId());
		if (submitterUsers != null && !submitterUsers.isEmpty()) {
			for (int i = 0 ; i < submitterUsers.size() ; i++) {
				strBuilder.append("\n submitter_user_" + i + "    " +  submitterUsers.get(i).getName());
			}
		}
	}

	private void searchAndPrintTicketAssignees(StringBuilder strBuilder, Ticket ticket) {
		List<User> assigneeUsers = userRepositoryImpl.findUserById(ticket.getAssigneeId());
		if (assigneeUsers != null && !assigneeUsers.isEmpty()) {
			for (int i = 0 ; i < assigneeUsers.size() ; i++) {
				strBuilder.append("\n assignee_user_" + i + "    " +  assigneeUsers.get(i).getName());
			}
		}
	}
}
