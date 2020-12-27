package com.tokoin.service;

import java.util.List;

import com.tokoin.model.Organization;
import com.tokoin.model.Ticket;
import com.tokoin.model.User;
import com.tokoin.repository.impl.OrganizationRepositoryImpl;
import com.tokoin.repository.impl.TicketRepositoryImpl;
import com.tokoin.repository.impl.UserRepositoryImpl;
import com.tokoin.utils.PrintObject;

public class UserService {

	private OrganizationRepositoryImpl organizationRepositoryImpl;
	private TicketRepositoryImpl ticketRepositoryImpl;
	private UserRepositoryImpl userRepositoryImpl;

	public UserService(OrganizationRepositoryImpl organizationRepositoryImpl, TicketRepositoryImpl ticketRepositoryImpl,
			UserRepositoryImpl userRepositoryImpl) {
		this.organizationRepositoryImpl = organizationRepositoryImpl;
		this.ticketRepositoryImpl = ticketRepositoryImpl;
		this.userRepositoryImpl = userRepositoryImpl;
	}

	public StringBuilder searchUser(String term, String value) {
		List<User> users = userRepositoryImpl.findUserByTerm(term, value);
		
		StringBuilder strBuilder = new StringBuilder();
		if (users != null && !users.isEmpty()) {	
			users.forEach(user -> {
				PrintObject.appendObjectResult(user, strBuilder);
				searchAndPrintUserTicketSubmitters(strBuilder, user);
				searchAndPrintUserTicketAssignees(strBuilder, user);
				searchAndPrintUserOrganizations(strBuilder, user);
			});
		} else {
			PrintObject.printNoResultFound("users", term, value, strBuilder);
		}
		return strBuilder;
	}

	private void searchAndPrintUserOrganizations(StringBuilder strBuilder, User user) {
		List<Organization> organizations = organizationRepositoryImpl.findOrganizationById(user.getOrganizationId());
		if (organizations != null && !organizations.isEmpty()) {
			for (int i = 0; i < organizations.size(); i++) {
				strBuilder.append("\norganization_" + i + "    " + organizations.get(i).getName());
			}
		}
	}

	private void searchAndPrintUserTicketAssignees(StringBuilder strBuilder, User user) {
		List<Ticket> submitterTickets = ticketRepositoryImpl.findTicketBySubmitterId(user.getId());
		if (submitterTickets != null && !submitterTickets.isEmpty()) {
			for (int i = 0; i < submitterTickets.size(); i++) {
				strBuilder.append("\nsubmitter_ticket_" + i + "    " + submitterTickets.get(i).getSubject());
			}
		}
	}

	private void searchAndPrintUserTicketSubmitters(StringBuilder strBuilder, User user) {
		List<Ticket> assigneeTickets = ticketRepositoryImpl.findTicketByAssigneeId(user.getId());
		if (assigneeTickets != null && !assigneeTickets.isEmpty()) {
			for (int i = 0; i < assigneeTickets.size(); i++) {
				strBuilder.append("\nassignee_ticket_" + i + "    " + assigneeTickets.get(i).getSubject());
			}
		}
	}
}
