package com.robot.toy.simulator.test;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.robot.toy.exception.CatostrophicException;
import com.robot.toy.simulation.Board;
import com.robot.toy.simulation.impl.ToyGameSimulator;
import com.robot.toy.simulation.impl.ToyRobot;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Test class for testing input using a file.
 */

public class InputFileBasedTest {

	private ToyGameSimulator gameSimulator;
	private String filePath;

	@Before
	public void setup() {
		Board board = new Board(5, 5);
		gameSimulator = new ToyGameSimulator(board, new ToyRobot(board));
		if (getClass().getClassLoader().getResource("input.txt") != null) {
			File file = new File(getClass().getClassLoader().getResource("input.txt").getFile());
			filePath = file.getAbsolutePath();
		}
	}

	@Test
	public void testInputFromInputFile() {

		try {
			gameSimulator.parseFromInputFileandExecute(filePath);
			assert (gameSimulator.getRobot().isToyOnBoard());
			assert (gameSimulator.getRobot().getXCoordinate() == 3);
			assert (gameSimulator.getRobot().getYCoordinate() == 3);
			assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		} catch (CatostrophicException e) {
			// fail the test case
			assert (false);
		} catch (IOException e) {
			// fail the test case
			assert (false);
		}

	}

}
