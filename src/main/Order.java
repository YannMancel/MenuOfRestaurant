package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {
	
	public Order() {
		scan = new Scanner(System.in);
	}
	
	/**
	 * Display the available menus
	 */
	public void displayAvailableMenu() {	
		
    	System.out.println("Choix menu:");
    	System.out.println("\t1 - Poulet");
    	System.out.println("\t2 - Boeuf");
    	System.out.println("\t3 - Végétarien");
    	System.out.println("Que souhaitez-vous comme menu ?");	
    	System.out.print("=>");
	}
	
	/**
	 * Display the menu selected
	 * @param menu Number of Menu selected
	 */
	public void displayMenuSelected(int menu) {	
		
		switch (menu) {
			case 1: 
				System.out.println("Vous avez choisi comme menu : Poulet");
				break;
			case 2:
				System.out.println("Vous avez choisi comme menu : Boeuf");
				break;
			case 3:
				System.out.println("Vous avez choisi comme menu : Végétarien");
				break;
			default:
				System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés"); 	
				System.out.print("=>");
		}	
	}
	
	/**
	 * Run of the order
	 */
	public void run() {
	
		this.displayAvailableMenu();
		
		int result = -1;
    		
		do {
			try {
				result = scan.nextInt();				
				this.displayMenuSelected(result);
			}
			catch (InputMismatchException e) {
				scan.next();				
				System.out.println("Veuilliez saisir un chiffre, s'il vous plaît");
				System.out.print("=>");
			}			
		} while (result<1 || result>3);		
    	
	}
	
	private Scanner scan;
}
