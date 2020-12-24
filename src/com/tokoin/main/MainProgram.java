package com.tokoin.main;

import java.util.List;
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

public class MainProgram {
	private UserRepositoryImpl userRepositoryImpl;
	private OrganizationRepositoryImpl organizationRepositoryImpl;
	private TicketRepositoryImpl ticketRepositoryImpl;
	
	private UserService userService;
	private OrganizationService organizationService;
	private TicketService ticketService;
	
	private List<User> loadResult() {
		userRepositoryImpl = new UserRepositoryImpl();
		organizationRepositoryImpl = new OrganizationRepositoryImpl();
		ticketRepositoryImpl = new TicketRepositoryImpl();
		
		userService = new UserService(userRepositoryImpl);
		organizationService = new OrganizationService(organizationRepositoryImpl);
		ticketService = new TicketService(ticketRepositoryImpl);
		List<User> users = userService.getUsers();
		List<Organization> organizations = organizationService.findOrganization();
		List<Ticket> tickets = ticketService.findTicket();
		return users;
	}
	
	public static void main(String[] args) {
		MainProgram main = new MainProgram();
		main.loadResult();
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Type 'quit' to exit any time, Press 'Enter' to continue ");  
		String enterOrQuit = sc.nextLine();              //input enter key 
		if (enterOrQuit.equals("")) {
			System.out.println("\n\n    Select search options:");
			System.out.println("         * Press 1 to search");
			System.out.println("         * Press 2 to view a list of searchable fields");
			System.out.println("         * Type 'quit' to exit");
			String searchOptions = sc.nextLine();
			if (searchOptions.equals("1")) {
				System.out.println("Select 1) Users or 2) Tickets or 3) Organization");
				String typeOfSearch = sc.nextLine();
				if (searchOptions.equals("1")) {
					System.out.println("Enter search term");
					System.out.println("Enter search value");
					//main.loadResult();
				} else if (searchOptions.equals("2")) {
					System.out.println("Enter search term");
					System.out.println("Enter search value");
				} else if (searchOptions.equals("3")) {
					System.out.println("Enter search term");
					System.out.println("Enter search value");
				}
			} else if (searchOptions.equals("2")){
				System.out.println("List of searchable fields");
			} else if (searchOptions.equals("quit")) {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}
}
