package com.coding.exercise.game.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coding.exercise.game.impl.ChildrenGameImpl;

/**
 * 
 * @author Shyamant
 *
 */
public class ValidInputTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private ChildrenGameImpl cgi;

	@Before
	public void setup() {
		System.setOut(new PrintStream(outContent));
		cgi = new ChildrenGameImpl(10, 4);
	}

	@Test
	public void testSequenceStartingFrom1() {
		cgi.setUpTheSequenceNumber(1);
		cgi.playTheGame();
		// verify if child 5 won the game as child 5 is the winner with these sequence
		// of the game.
		assert (outContent.toString().contains("The winner of the game is Child5 with ID 5"));
	}

	@Test
	public void testSequenceStartingFrom6() {
		cgi.setUpTheSequenceNumber(6);
		cgi.playTheGame();
		// verify if child 10 won the game as child 10 is the winner with this sequence
		// of the game.
		assert (outContent.toString().contains("The winner of the game is Child10 with ID 10"));
	}

	@Test
	public void testSequenceStartingFrom10() {
		cgi.setUpTheSequenceNumber(10);
		cgi.playTheGame();
		// verify if child 4 won the game as child 4 is the winner with this sequence of
		// the game.
		assert (outContent.toString().contains("The winner of the game is Child4 with ID 4"));
	}

	@Test
	public void testSequenceWithKgreaterthanN() {
		cgi = new ChildrenGameImpl(10, 14);
		cgi.setUpTheSequenceNumber(10);
		cgi.playTheGame();
		// verify if child 4 won the game as child 4 is the winner with this sequence of
		// the game.
		assert (outContent.toString().contains("The winner of the game is Child4 with ID 4"));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
}
