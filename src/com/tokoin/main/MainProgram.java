package com.tokoin.main;

import java.util.Scanner;

public class MainProgram {
	
	public static void main(String[] args) {
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
