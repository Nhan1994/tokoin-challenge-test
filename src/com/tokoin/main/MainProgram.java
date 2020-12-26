package com.tokoin.main;

import java.util.Scanner;

import com.tokoin.repository.impl.OrganizationRepositoryImpl;
import com.tokoin.repository.impl.TicketRepositoryImpl;
import com.tokoin.repository.impl.UserRepositoryImpl;
import com.tokoin.service.OrganizationService;
import com.tokoin.service.TicketService;
import com.tokoin.service.UserService;

public class MainProgram {
	private UserRepositoryImpl userRepositoryImpl;
	private OrganizationRepositoryImpl organizationRepositoryImpl;
	private TicketRepositoryImpl ticketRepositoryImpl;

	private UserService userService;
	private OrganizationService organizationService;
	private TicketService ticketService;

	private void init() {
		userRepositoryImpl = new UserRepositoryImpl();
		organizationRepositoryImpl = new OrganizationRepositoryImpl();
		ticketRepositoryImpl = new TicketRepositoryImpl();
	}

	public static void main(String[] args) {
		MainProgram main = new MainProgram();
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.print("Type 'quit' to exit any time, Press 'Enter' to continue ");
		String enterOrQuit = sc.nextLine(); // input enter key
		if (enterOrQuit.equals("")) {
			System.out.println("\n\n    Select search options:");
			System.out.println("         * Press 1 to search");
			System.out.println("         * Press 2 to view a list of searchable fields");
			System.out.println("         * Type 'quit' to exit");
			String searchOptions = sc.next();
			if (searchOptions.equals("1")) {
				System.out.println("Select 1) Users or 2) Tickets or 3) Organization");
				String typeSearch = sc.next();
				if (typeSearch.equals("1")) {
					System.out.println("Enter search term");
					String term = sc.next();
					System.out.println("Enter search value");
					String value = sc.next();
					main.searchUsers(term, value);
				} else if (typeSearch.equals("2")) {
					System.out.println("Enter search term");
					String term = sc.next();
					System.out.println("Enter search value");
					String value = sc.next();
					main.searchTicket(term, value);
				} else if (typeSearch.equals("3")) {
					System.out.println("Enter search term");
					String term = sc.next();
					System.out.println("Enter search value");
					String value = sc.next();
					main.searchOrganization(term, value);
				}
			} else if (searchOptions.equals("2")) {
				System.out.println("List of searchable fields");
			} else if (searchOptions.equals("quit")) {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}

	private void searchUsers(String term, String value) {
		init();
		userService = new UserService(organizationRepositoryImpl, ticketRepositoryImpl, userRepositoryImpl);
		userService.searchUser(term, value);
	}
	
	private void searchOrganization(String term, String value) {
		init();
		organizationService = new OrganizationService(organizationRepositoryImpl, ticketRepositoryImpl,
				userRepositoryImpl);
		organizationService.searchOrganization(term, value);
	}
	
	private void searchTicket(String term, String value) {
		init();
		ticketService = new TicketService(organizationRepositoryImpl, ticketRepositoryImpl,
				userRepositoryImpl);
		ticketService.searchTicket(term, value);
	}
}
