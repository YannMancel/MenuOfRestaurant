package main;

public class Main {

	public static void main(String[] args) {

		// Ask the menu choices
		/*
		Order myOrder = new Order();		
		myOrder.runSeveralMenus();
		*/
		
		// Read the CSV file which summaries the menu choices
		OrderReader myOrderReader = new OrderReader();
		myOrderReader.readAllExceptFirstLine("Other/Order.csv");
	}
}
