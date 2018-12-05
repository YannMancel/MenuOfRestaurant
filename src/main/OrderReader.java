package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class OrderReader {
	
	/**
	 * Displays the content of file thanks to a file path
	 * 
	 * @param pathFile String which corresponds to the file path
	 */
	public void readAllExceptFirstLine(String filePath) {
		
		Path path = Paths.get(filePath);
		
		// Contains the file content under shape of list
		List<String> lineList = null;
		
		try {
			lineList = Files.readAllLines(path);
		} catch (IOException e) {
			System.out.println("Une erreur est survenue, veuillez rééssayer plus tard!");
			return;
		}	
		
		/*
		 *  The file is correctly open to can perform these lines
		 *  The first line is excluded of the display
		 */
		if (lineList.size() > 1) {
			
			// Strings of summary
			String orderLine = null;
			String[] stringArray = null;
			
			String[] menus = {"Menu Poulet", "Menu Boeuf", "Menu Végétarien"};
			String[] side = {" avec des légumes frais", " avec des frites", " avec du riz"};
			String[] sideVegetarian = {" avec des légumes frais"," avec du riz", " sans riz"};
			String[] drink = {" et avec de l'eau plate", " et avec de l'eau gazeuse", " et avec du soda"};
			
			for (int i = 1 ; i < lineList.size() ; i++) {
				
				/* 
				 * For each line, the elements are put into a String array
				 * The format is:
				 * Menu,Side,Drink
				 * 
				 * stringArray[0] -> Menu
				 * stringArray[1] -> Side
				 * stringArray[2] -> Drink
				 */				
				stringArray = lineList.get(i).split(",");
				
				// Conversion String to integer
				int menuNumber = Integer.parseInt(stringArray[0]);
				int sideNumber = Integer.parseInt(stringArray[1]);
				int drinkNumber = Integer.parseInt(stringArray[2]);
				
				// MENU and SIDE: If the menu is the vegetarian menu
				if (menuNumber == 3)
					orderLine = menus[menuNumber-1] + sideVegetarian[sideNumber-1];
				else
					orderLine = menus[menuNumber-1] + side[sideNumber-1];

				// DRINK: For all the menus except the beef menu
				if (drinkNumber != -1 && menuNumber != 2) orderLine += drink[drinkNumber];
				
				// Display of the order line
				System.out.println(orderLine);
			}			
		}
		else
			System.out.println("Aucune commande");
	}
	
	/**
	 * Displays the content of file thanks to a file path
	 * 
	 * @param pathFile String which corresponds to the file path
	 */
	public void readAllExceptFirstLine_CommonsCSV(String filePath) {
		
		try {			
			// Integers which contain the choices
			int menuNumber = -1;
			int sideNumber = -1;
			int drinkNumber = -1;
			
			// String of summary
			String orderLine = null;
			
			// Various choices
			String[] menus = {"Menu Poulet", "Menu Boeuf", "Menu Végétarien"};
			String[] side = {" avec des légumes frais", " avec des frites", " avec du riz"};
			String[] sideVegetarian = {" avec des légumes frais"," avec du riz", " sans riz"};
			String[] drink = {" et avec de l'eau plate", " et avec de l'eau gazeuse", " et avec du soda"};
			
			Reader in = new FileReader(filePath);
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
						
			for (CSVRecord record : records) {
				
				// Conversion String to integer
				menuNumber = Integer.parseInt(record.get("menu"));
				sideNumber = Integer.parseInt(record.get("accompagnement"));
				drinkNumber = Integer.parseInt(record.get("boisson"));

				// MENU and SIDE: If the menu is the vegetarian menu
				if (menuNumber == 3)
					orderLine = menus[menuNumber-1] + sideVegetarian[sideNumber-1];
				else
					orderLine = menus[menuNumber-1] + side[sideNumber-1];

				// DRINK: For all the menus except the beef menu
				if (drinkNumber != -1 && menuNumber != 2) orderLine += drink[drinkNumber];
				
				// Display of the order line
				System.out.println(orderLine);
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println("Impossible de trouver le fichier order.csv");
			
		} catch (IOException e) {
			System.out.println("Une erreur est survenue, veuillez rééssayer plus tard!");
		}
	}
}
