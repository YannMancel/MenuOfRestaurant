package test;

import main.Order;

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
		//outContent.close();
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
	final void Given_Chicken_When_DisplayMenuSelected_Then_DisplayCorrectSentence() {
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(1, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme Menu : Poulet\n", output);
    }		
	
	@Test
	@DisplayName("displayChoiceSelected -> Beef (2)")
	final void Given_Beef_When_DisplayMenuSelected_Then_DisplayCorrectSentence() {
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(2, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme Menu : Boeuf\n", output);
	}	
	
	@Test
	@DisplayName("displayChoiceSelected -> Vegetarian (3)")
	final void Given_Vegetarian_When_DisplayMenuSelected_Then_DisplayCorrectSentence() {
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(3, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme Menu : Végétarien\n", output);
	}
	
	@Test
	@DisplayName("displayChoiceSelected -> Bad choice (<1 or >3)")
	final void Given_BadChoice_When_DisplayMenuSelected_Then_DisplayCorrectSentence() {
		
		String[] choiceArray = {"Poulet", "Boeuf", "Végétarien"};
		myOrder.displayChoiceSelected(0, "Menu", choiceArray);
		
		String output = outContent.toString().replace("\r\n", "\n");		
	    assertEquals("Vous n'avez pas choisi de Menu parmi les choix proposés\n=>", output);
	}
	
	private static Order myOrder;
	private static ByteArrayOutputStream outContent;
}
