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

	public StringBuilder searchOrganization(String term, String value) {
		List<Organization> organizations = organizationRepositoryImpl.findOrganizationByTerm(term, value);
		
		StringBuilder strBuilder = new StringBuilder();
		if (organizations != null && !organizations.isEmpty()) {	
			organizations.forEach(organization -> {
				PrintObject.appendObjectResult(organization, strBuilder);
				searchAndPrintOrganizationTickets(strBuilder, organization);
				searchAndPrintOrganizationUsers(strBuilder, organization);
			});
		} else {
			PrintObject.printNoResultFound("organization", term, value, strBuilder);
		}
		return strBuilder;
	}

	private void searchAndPrintOrganizationUsers(StringBuilder strBuilder, Organization organization) {
		List<User> users = userRepositoryImpl.findUserByOrganizationId(organization.getId());
		if (users != null && !users.isEmpty()) {
			for (int i = 0; i < users.size(); i++) {
				strBuilder.append("\nuser_" + i + "        " + users.get(i).getName());
			}
		}
	}

	private void searchAndPrintOrganizationTickets(StringBuilder strBuilder, Organization organization) {
		List<Ticket> tickets = ticketRepositoryImpl.findTicketByOrganizationId(organization.getId());
		if (tickets != null && !tickets.isEmpty()) {
			for (int i = 0; i < tickets.size(); i++) {
				strBuilder.append("\nticket_" + i + "        " + tickets.get(i).getSubject());
			}
		}
	}
}
