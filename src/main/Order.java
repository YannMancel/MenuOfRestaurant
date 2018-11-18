package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {
	
	public Order() {
		
		this.scan = new Scanner(System.in);
		
		// Initialization of the menu array	
		this.menuList = new String[3];
		this.menuList[0] = "Poulet";
		this.menuList[1] = "Boeuf";
		this.menuList[2] = "Végétarien";
	}
	
	/**
	 * Displays the available choices for a given context
	 * 
	 * @param contextOfChoice String which defines the choice type
	 * @param choiceArray String array which stores the possible choices 
	 */
	public void displayChoice(String contextOfChoice, String[] choiceArray) {	
		
    	System.out.println("Choix " + contextOfChoice + ":");
    	
    	int i = 1;
    	
    	for(String str : choiceArray) {
    		System.out.println("\t" + i + " - " + str);
    		i++;
    	}
    	
    	System.out.println("Que souhaitez-vous comme " + contextOfChoice + " ?");	
    	System.out.print("=>");
	}
	
	/** 
	 * Display the selected choice in the given context
	 * 
	 * @param SelectedChoice Integer value which represents the number of selected choice
	 * @param contextOfChoice String which defines the choice type
	 * @param choiceArray String array which stores the possible choices
	 */
	public void displayChoiceSelected(int SelectedChoice, String contextOfChoice, String[] choiceArray) {	
		
		// Bad choice, the number is outside of array dimensions of choiceArray: [1 to choiceArray.length]
		if (SelectedChoice<1 || SelectedChoice>choiceArray.length) {
			System.out.println("Vous n'avez pas choisi de " + contextOfChoice + " parmi les choix proposés"); 	
			System.out.print("=>");
			return;
		}
		
		System.out.println("Vous avez choisi comme " + contextOfChoice + " : " + choiceArray[SelectedChoice - 1]);
	}
	
	/**
	 * Run of the order
	 */
	public void runMenu() {
	
		// Display the available menu
		this.displayChoice("Menu", this.menuList);
		
		int result = -1;
    		
		do {
			try {
				result = scan.nextInt();				
				this.displayChoiceSelected(result, "Menu", this.menuList);
			}
			catch (InputMismatchException e) {
				scan.next();				
				System.out.println("Veuilliez saisir un chiffre, s'il vous plaît");
				System.out.print("=>");
			}			
		} while (result<1 || result>3);	
	
	}
	
	private Scanner scan;
	private String[] menuList;
}
