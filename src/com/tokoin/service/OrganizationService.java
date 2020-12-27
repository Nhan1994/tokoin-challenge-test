package com.tokoin.service;

import java.util.List;

import com.tokoin.model.Organization;
import com.tokoin.model.Ticket;
import com.tokoin.model.User;
import com.tokoin.repository.impl.OrganizationRepositoryImpl;
import com.tokoin.repository.impl.TicketRepositoryImpl;
import com.tokoin.repository.impl.UserRepositoryImpl;
import com.tokoin.utils.PrintObject;

public class OrganizationService {
	private OrganizationRepositoryImpl organizationRepositoryImpl;
	private TicketRepositoryImpl ticketRepositoryImpl;
	private UserRepositoryImpl userRepositoryImpl;

	public OrganizationService(OrganizationRepositoryImpl organizationRepositoryImpl,
			TicketRepositoryImpl ticketRepositoryImpl, UserRepositoryImpl userRepositoryImpl) {
		this.organizationRepositoryImpl = organizationRepositoryImpl;
		this.ticketRepositoryImpl = ticketRepositoryImpl;
		this.userRepositoryImpl = userRepositoryImpl;
	}

	public List<Organization> findOrganization() {
		return organizationRepositoryImpl.loadOrganization();
	}

	public void searchOrganization(String term, String value) {
		List<Organization> organizations = organizationRepositoryImpl.findOrganizationByTerm(term, value);

		if (organizations != null && !organizations.isEmpty()) {
			StringBuilder strBuilder = new StringBuilder();
			organizations.forEach(organization -> {
				PrintObject.printObjectResult(organization);
				searchAndPrintOrganizationTickets(strBuilder, organization);
				searchAndPrintOrganizationUsers(strBuilder, organization);
				System.out.println(strBuilder.toString());
			});
		} else {
			PrintObject.printNoResultFound("organization", term, value);
		}
	}

	private void searchAndPrintOrganizationUsers(StringBuilder strBuilder, Organization organization) {
		List<User> users = userRepositoryImpl.findUserByOrganizationId(organization.getId());
		if (users != null && !users.isEmpty()) {
			for (int i = 0; i < users.size(); i++) {
				strBuilder.append("\n user_" + i + "    " + users.get(i).getName());
			}
		}
	}

	private void searchAndPrintOrganizationTickets(StringBuilder strBuilder, Organization organization) {
		List<Ticket> tickets = ticketRepositoryImpl.findTicketByOrganizationId(organization.getId());
		if (tickets != null && !tickets.isEmpty()) {
			for (int i = 0; i < tickets.size(); i++) {
				strBuilder.append("\n ticket_" + i + "    " + tickets.get(i).getSubject());
			}
		}
	}
}
