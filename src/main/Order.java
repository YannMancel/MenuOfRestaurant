package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {
	
	/**
	 * Constructor without argument
	 */
	public Order() {
		
		this.scan = new Scanner(System.in);
		
		// Initialization of the menu array	
		String[] menuTempArray = {"poulet", "Boeuf", "Végétarien"};
		this.menuArray = menuTempArray;
		
		// Initialization of the side array	
		this.sideArray = null;
		
		// Initialization of the drink array
		String[] drinkTempArray = {"Eau plate", "Eau gazeuse", "Soda"};
		this.drinkArray = drinkTempArray;
		
		// Add to the summary of the order (just a line break)
		summaryOfOrder = "Résumé de la commande:%n";
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
    	
    	System.out.print("Que souhaitez-vous comme " + contextOfChoice + " ? ");
	}
	
	/** 
	 * Displays the selected choice in the given context
	 * 
	 * @param SelectedChoice Integer value which represents the number of selected choice
	 * @param contextOfChoice String which defines the choice type
	 * @param choiceArray String array which stores the possible choices
	 */
	public void displayChoiceSelected(int SelectedChoice, String contextOfChoice, String[] choiceArray) {	
		
		// Bad choice, the number is outside of array dimensions of choiceArray: [1 to choiceArray.length]
		if (SelectedChoice<1 || SelectedChoice>choiceArray.length) {
			System.out.print("Vous n'avez pas choisi de " + contextOfChoice + " parmi les choix proposés! ");
			return;
		}
		
		System.out.println("Vous avez choisi comme " + contextOfChoice + " : " + choiceArray[SelectedChoice - 1]);
	}
	
	/**
	 * Displays the various steps in the user choice
	 * 
	 * @param contextOfChoice String which defines the choice type
	 * @param choiceArray String array which stores the possible choices
	 * 
	 * @return Integer value corresponding to the choice
	 */
	public int choiceAndSelection(String contextOfChoice, String[] choiceArray) {
		
		int result = -1;
		
		// Displays the available choices
		this.displayChoice(contextOfChoice, choiceArray);	
    		
		do {			
			try {
				result = this.scan.nextInt();
			}
			catch (InputMismatchException e) {
				this.scan.next();				
				System.out.print("Veuilliez saisir un chiffre, s'il vous plaît! ");
			}	
			
			// Displays the selected choice among the possibilities of choice array
			this.displayChoiceSelected(result, contextOfChoice, choiceArray);
			
		} while (result<1 || result>choiceArray.length);

		// Add to the summary of the order
		summaryOfOrder += "\t" + contextOfChoice + ": " + choiceArray[result - 1] + "%n";
		
		return result;
	}
	
	/**
	 * Run of the order (only one)
	 */
	public void runMenu() {
		
		/*
		 * Menu 1:
		 * 		Menu: Chicken
		 * 		Side: fresh vegetables or Chips or Rice
		 * 		Drink: Still water or Sparkling water or Soda
		 * 
		 * Menu 2:
		 * 		Menu: Beef
		 * 		Side: fresh vegetables or Chips or Rice
		 * 		Drink: No
		 * 
		 * Menu 3:
		 * 		Menu: Vegetarian
		 * 		Side: fresh vegetables or Rice or Not rice
		 * 		Drink: Still water or Sparkling water or Soda
		 */
			
		// Displays the various steps in the user choice for the menu
		// The choice is stored in menuResult
		int menuResult = this.choiceAndSelection("Menu", this.menuArray);
		
		//---------------------------------------------------------------------------------------
		
		switch (menuResult) {
		
			case 1:
				String[] side1Array = {"Légumes frais", "Frites", "Riz"};
				this.sideArray = side1Array;
				
				// SIDE: Displays the various steps in the user choice
				this.choiceAndSelection("Accompagnement", this.sideArray);
				
				// DRINK: Displays the various steps in the user choice
				this.choiceAndSelection("Boisson", this.drinkArray);
				
				break;			
			case 2:
				String[] side2Array = {"Légumes frais", "Frites", "Riz"};
				this.sideArray = side2Array;
				
				// SIDE: Displays the various steps in the user choice
				this.choiceAndSelection("Accompagnement", this.sideArray);
				
				break;
			case 3:
				String[] side3Array = {"Légumes frais", "Ris", "Pas de riz"};
				this.sideArray = side3Array;
				
				// SIDE: Displays the various steps in the user choice
				this.choiceAndSelection("Accompagnement", this.sideArray);
				
				// DRINK: Displays the various steps in the user choice
				this.choiceAndSelection("Boisson", this.drinkArray);
				
				break;	
		}	
	}
	
	/**
	 * Run of the several orders
	 */
	public void runSeveralMenus() {
		
		System.out.print("Combien de menu désirez-vous commander, s'il vous plaît ? ");
		
		int numberOfMenu = 0;

		try {
			numberOfMenu = this.scan.nextInt();
		}
		catch (InputMismatchException e) {
			this.scan.next();				
			System.out.print("Veuilliez saisir un chiffre, s'il vous plaît! ");
		}
		
		System.out.println("");
		
		int i = 0;
		
		while (i < numberOfMenu) {
			
			System.out.println("Num " + (i+1) + ":");
			
			// Add to the summary of the order
			summaryOfOrder += "Num " + (i+1) + ":%n";
			
			this.runMenu();
			
			System.out.println("");
			
			i++;
		}
		
		// Displays the summary of the order
		System.out.println(String.format(summaryOfOrder));
	}
	
	private Scanner scan;
	private String[] menuArray;
	private String[] sideArray;
	private String[] drinkArray;
	private String summaryOfOrder;
}
