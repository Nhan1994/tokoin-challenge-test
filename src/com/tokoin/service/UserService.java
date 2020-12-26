package com.tokoin.service;

import java.util.List;

import com.tokoin.model.Organization;
import com.tokoin.model.Ticket;
import com.tokoin.model.User;
import com.tokoin.repository.impl.OrganizationRepositoryImpl;
import com.tokoin.repository.impl.TicketRepositoryImpl;
import com.tokoin.repository.impl.UserRepositoryImpl;

public class UserService {
	
	private OrganizationRepositoryImpl organizationRepositoryImpl;
	private TicketRepositoryImpl ticketRepositoryImpl;
	private UserRepositoryImpl userRepositoryImpl;

	public UserService(OrganizationRepositoryImpl organizationRepositoryImpl,
			TicketRepositoryImpl ticketRepositoryImpl, UserRepositoryImpl userRepositoryImpl) {
		this.organizationRepositoryImpl = organizationRepositoryImpl;
		this.ticketRepositoryImpl = ticketRepositoryImpl;
		this.userRepositoryImpl = userRepositoryImpl;
	}
	
	public void searchUser(String term, String value) {
		List<User> users = userRepositoryImpl.findUserByTerm(term, value);

		if (users != null && !users.isEmpty()) {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(users.toString());
			users.forEach(user -> {
				List<Ticket> assigneeTickets = ticketRepositoryImpl.findTicketByAssigneeId(user.getId());
				if (assigneeTickets != null && !assigneeTickets.isEmpty()) {
					for (int i = 0 ; i < assigneeTickets.size() ; i++) {
						strBuilder.append("\n assignee_ticket_" + i + "    " +  assigneeTickets.get(i).getSubject());
					}
				}
				List<Ticket> submitterTickets = ticketRepositoryImpl.findTicketBySubmitterId(user.getId());
				if (submitterTickets != null && !submitterTickets.isEmpty()) {
					for (int i = 0 ; i < submitterTickets.size() ; i++) {
						strBuilder.append("\n submitter_ticket_" + i + "    " +  submitterTickets.get(i).getSubject());
					}
				}
				List<Organization> organizations = organizationRepositoryImpl.findOrganizationById(user.getOrganizationId());
				if (organizations != null && !organizations.isEmpty()) {
					for (int i = 0 ; i < organizations.size() ; i++) {
						strBuilder.append("\n organization_" + i + "    " +  organizations.get(i).getName());
					}
				}
			});
			System.out.println(strBuilder.toString());
		} else {
			System.out.println("No result found");
		}
	}
}
