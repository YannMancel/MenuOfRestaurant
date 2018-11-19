package test;

import main.Order;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for Order class
 */
class OrderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {	
		myOrder = new Order();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		outContent.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void tearDown() throws Exception {
        System.setOut(System.out);
	}
	

	@Test
	@DisplayName("displayChoiceSelected -> Chicken (1)")
	final void Test_DisplayMenuSelected_1() {
				
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(1, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme Menu : Poulet\n", output);
    }	
	@Test
	@DisplayName("displayChoiceSelected -> Beef (2)")
	final void Test_DisplayMenuSelected_2() {
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(2, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme Menu : Boeuf\n", output);
	}	
	@Test
	@DisplayName("displayChoiceSelected -> Vegetarian (3)")
	final void Test_DisplayMenuSelected_3() {
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(3, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme Menu : Végétarien\n", output);
	}
	@Test
	@DisplayName("displayChoiceSelected -> Bad choice (<1 or >3)")
	final void Test_DisplayMenuSelected_4() {
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(0, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");		
	    assertEquals("Vous n'avez pas choisi de Menu parmi les choix proposés! ", output);
	}
	
	@Test
	@DisplayName("choiceAndSelection -> Good choice (between 1 and 3)")
	final void Test_choiceAndSelection_1() {	
		
		System.setIn(new ByteArrayInputStream(String.format("1%n").getBytes()));
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		
		myOrder = new Order();
		int result = myOrder.choiceAndSelection("Menu", choiceArray);		
		assertEquals(1, result);	
			
		//String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        //assertEquals("Vous avez choisi comme Menu : Poulet", output[3]);
	}

	
	private static Order myOrder;
	private static ByteArrayOutputStream outContent;
}
