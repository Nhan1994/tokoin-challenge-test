package com.tokoin.main;

import java.util.Scanner;

import com.tokoin.model.Organization;
import com.tokoin.model.Ticket;
import com.tokoin.model.User;
import com.tokoin.repository.impl.OrganizationRepositoryImpl;
import com.tokoin.repository.impl.TicketRepositoryImpl;
import com.tokoin.repository.impl.UserRepositoryImpl;
import com.tokoin.service.OrganizationService;
import com.tokoin.service.TicketService;
import com.tokoin.service.UserService;
import com.tokoin.utils.PrintObject;

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
		Scanner sc = new Scanner(System.in);
		System.out.print("Type 'quit' to exit any time, Press 'Enter' to continue ");
		String enterOrQuit = sc.nextLine();
		if (enterOrQuit.equals("")) {
			printOptions();
			String searchOptions = sc.next();
			if (searchOptions.equals("1")) {
				main.search(main, sc);
			} else if (searchOptions.equals("2")) {
				main.printSearchableFields();
			} else if (searchOptions.equals("quit")) {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}

	private void search(MainProgram main, Scanner sc) {
		System.out.println("Select 1) Users or 2) Tickets or 3) Organizations");
		String term = "";
		String value = "";
		String typeSearch = sc.next();
		switch (typeSearch) {
		case "1":
			main.searchUsers(term, value, sc);
			break;
		case "2":
			main.searchTicket(term, value, sc);
			break;
		case "3":
			main.searchOrganization(term, value, sc);
			break;
		default:
			break;
		}
	}

	private static void printOptions() {
		System.out.println("\n\n    Select search options:");
		System.out.println("         * Press 1 to search");
		System.out.println("         * Press 2 to view a list of searchable fields");
		System.out.println("         * Type 'quit' to exit");
	}

	private void searchUsers(String term, String value, Scanner sc) {
		System.out.println("Enter search term");
		term = sc.next();
		System.out.println("Enter search value");
		value = sc.next();
		init();
		userService = new UserService(organizationRepositoryImpl, ticketRepositoryImpl, userRepositoryImpl);
		userService.searchUser(term, value);
	}

	private void searchOrganization(String term, String value, Scanner sc) {
		System.out.println("Enter search term");
		term = sc.next();
		System.out.println("Enter search value");
		value = sc.next();
		init();
		organizationService = new OrganizationService(organizationRepositoryImpl, ticketRepositoryImpl,
				userRepositoryImpl);
		organizationService.searchOrganization(term, value);
	}

	private void searchTicket(String term, String value, Scanner sc) {
		System.out.println("Enter search term");
		term = sc.next();
		System.out.println("Enter search value");
		value = sc.next();
		init();
		ticketService = new TicketService(organizationRepositoryImpl, ticketRepositoryImpl, userRepositoryImpl);
		ticketService.searchTicket(term, value);
	}

	private void printSearchableFields() {
		System.out.println("List of searchable fields");
		PrintObject.printHyphen();
		System.out.println("Search Users with");
		PrintObject.printStructureObject(User.class);
		
		PrintObject.printHyphen();
		System.out.println("Search Tickets with");
		PrintObject.printStructureObject(Ticket.class);
		
		PrintObject.printHyphen();
		System.out.println("Search Organization with");
		PrintObject.printStructureObject(Organization.class);
	}
}
