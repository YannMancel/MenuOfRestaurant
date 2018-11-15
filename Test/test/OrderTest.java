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
	@DisplayName("displayMenuSelected -> Poulet (1)")
	final void Given_Chicken_When_DisplayMenuSelected_DisplayCorrectSentence() {
		myOrder.displayMenuSelected(1);	
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme menu : Poulet\n", output);
    }	
	@Test
	@DisplayName("displayMenuSelected -> Boeuf (2)")
	final void Given_Beef_When_DisplayMenuSelected_DisplayCorrectSentence() {
		myOrder.displayMenuSelected(2);	
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme menu : Boeuf\n", output);
	}
	@Test
	@DisplayName("displayMenuSelected -> Végétarien (3)")
	final void Given_Vegetarian_When_DisplayMenuSelected_DisplayCorrectSentence() {
		myOrder.displayMenuSelected(3);
		String output = outContent.toString().replace("\r\n", "\n");
	    assertEquals("Vous avez choisi comme menu : Végétarien\n", output);
	}
	@Test
	@DisplayName("displayMenuSelected -> Mauvais choix (<1 ou >3)")
	final void Given_BadChoice_When_DisplayMenuSelected_DisplayCorrectSentence() {
		myOrder.displayMenuSelected(0);	
		String output = outContent.toString().replace("\r\n", "\n");	
	    assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés\n=>", output);
	}
	
	
	private static Order myOrder;
	private static ByteArrayOutputStream outContent;
}
