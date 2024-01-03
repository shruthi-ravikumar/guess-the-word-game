package guessthewordgame;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class GuessTheWordTest {

	// All Fail scenario
	@Test
	void testStartGameAllFailCase() {
	String input = "h\ni\ns\ny\nz\nw";
	System.setIn(new ByteArrayInputStream(input.getBytes()));
	GuessTheWord.startGame();
	}
	// Few 
	@Test
	void testStartGamePassAndFail() {
	String input = "p\nl\no\nt\na\nc\nd\nk\ne\nk\ng\nb";
	System.setIn(new ByteArrayInputStream(input.getBytes()));
	GuessTheWord.startGame();
	}

	//Asset statement for all fail scenario
	@Test
	    void testStartGameFailScenarioWithAssert() {
	        // Simulate user input to guess the incorrect letters 
	        String input = "z\nh\ns";
	        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
	        System.setIn(inputStream);

	        // Redirect System.out to capture console output
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	        
	        GuessTheWord.startGame();

	        // Check if the game win message is printed
	        assertTrue(outputStream.toString().contains("Enter a letter: Incorrect! 1 life lost. 2 remaining. The current word is"));
	    }
	@Test
	    void testStartGamewithOneCorrectScenarioWithAssert() {
	       //Input
	        String input = "p\nl\no\nt\na\nc\nd\nk\ne\nk\ng\nb";
	        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
	        System.setIn(inputStream);

	        // Redirect System.out to capture console output
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	        
	        GuessTheWord.startGame();

	        // Check if the game win message is printed
	        assertTrue(outputStream.toString().contains("Correct."));
	    }
	//Asset False statement for all fail scenario
	@Test
	    void testGameFailScenarioWithAssertFalse() {
	        // Simulate user input to guess the wrong letters
	        String input = "z\nh\ns";
	        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
	        System.setIn(inputStream);

	        // Redirect System.out to capture console output
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	        
	        GuessTheWord.startGame();

	        // Check if the game win message is printed
	        assertFalse(outputStream.toString().contains("Correct."));
	    }

}
