package com.coding.exercise.game.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.Permission;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coding.exercise.game.impl.ChildrenGameImpl;

/**
 * 
 * @author Shyamant
 *
 */
public class InvalidInputTest {

	protected static class ExitException extends SecurityException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public final int status;

		public ExitException(int status) {
			super("Handling exit!");
			this.status = status;
		}
	}

	private static class NoExitSecurityManager extends SecurityManager {
		@Override
		public void checkPermission(Permission perm) {
			// allow anything.
		}

		@Override
		public void checkPermission(Permission perm, Object context) {
			// allow anything.
		}

		@Override
		public void checkExit(int status) {
			super.checkExit(status);
			throw new ExitException(status);
		}
	}

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setup() {
		System.setOut(new PrintStream(outContent));
		System.setSecurityManager(new NoExitSecurityManager());
	}

	@Test
	public void testWhenKisZero() {
		try {
			ChildrenGameImpl cgi = new ChildrenGameImpl(10, 0);
			cgi.setUpTheSequenceNumber(1);
			cgi.playTheGame();
		} catch (ExitException e) {
			assert (outContent.toString().contains("Invalid input"));
			assert (1 == e.status);
		}
	}

	@Test
	public void testWhenNisNegative() {
		try {
			ChildrenGameImpl cgi = new ChildrenGameImpl(-5, 4);
			cgi.setUpTheSequenceNumber(1);
			cgi.playTheGame();
		} catch (ExitException e) {
			assert (outContent.toString().contains("Invalid input"));
			assert (1 == e.status);
		}
	}

	@Test
	public void testWhenKisNegative() {
		try {
			ChildrenGameImpl cgi = new ChildrenGameImpl(4, -4);
			cgi.setUpTheSequenceNumber(1);
			cgi.playTheGame();
		} catch (ExitException e) {
			assert (outContent.toString().contains("Invalid input"));
			assert (1 == e.status);
		}
	}

	@Test
	public void testWhenGivenChildisZero() {
		try {
			ChildrenGameImpl cgi = new ChildrenGameImpl(4, 2);
			cgi.setUpTheSequenceNumber(0);
			cgi.playTheGame();
		} catch (ExitException e) {
			assert (outContent.toString().contains("Invalid input"));
			assert (1 == e.status);
		}
	}

	@Test
	public void testWhenGivenChildisgreaterThanN() {
		try {
			ChildrenGameImpl cgi = new ChildrenGameImpl(4, 2);
			cgi.setUpTheSequenceNumber(5);
			cgi.playTheGame();
		} catch (ExitException e) {
			assert (outContent.toString().contains("Invalid input"));
			assert (1 == e.status);
		}
	}
	
	@Test
	public void testWhenKisMultipleofN() {
		try {
			ChildrenGameImpl cgi = new ChildrenGameImpl(2, 4);
			cgi.setUpTheSequenceNumber(5);
			cgi.playTheGame();
		} catch (ExitException e) {
			assert (outContent.toString().contains("Invalid input"));
			assert (1 == e.status);
		}
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setSecurityManager(null);
	}

}
