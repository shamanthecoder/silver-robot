package com.robot.toy.simulator.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.robot.toy.simulation.Board;
import com.robot.toy.simulation.impl.ToyGameSimulator;
import com.robot.toy.simulation.impl.ToyRobot;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * This class tests different scenarios of Place command.
 * 
 */
public class PlaceCommandTest {

	private ToyGameSimulator gameSimulator;

	@Before
	public void setup() {
		Board board = new Board(5, 5);
		gameSimulator = new ToyGameSimulator(board, new ToyRobot(board));
	}

	@Test
	public void testIfPlaceisInvokedforValidCommand() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,NORTH");
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
		gameSimulator.parseFromStandardInputandExecute("PLACE 2,2,EAST");
		assert (gameSimulator.getRobot().getDirection().toString().equals("EAST"));
		assert (gameSimulator.getRobot().getXCoordinate() == 2);
		assert (gameSimulator.getRobot().getYCoordinate() == 2);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfPlaceisIgnoredIfNegativeXCoordinates() {
		gameSimulator.parseFromStandardInputandExecute("PLACE -4,0,NORTH");
		Assert.assertNull(gameSimulator.getRobot().getDirection());
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (!gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfPlaceisIgnoredIfNegativeYCoordinates() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,-5,NORTH");
		Assert.assertNull(gameSimulator.getRobot().getDirection());
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (!gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfPlaceisIgnoredIfOutofBoundXCoordinates() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 40,4,NORTH");
		Assert.assertNull(gameSimulator.getRobot().getDirection());
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (!gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfPlaceisIgnoredIfOutofBoundYCoordinates() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 5,50,NORTH");
		Assert.assertNull(gameSimulator.getRobot().getDirection());
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (!gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfPlaceisIgnoredIfInvalidDirection() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,4,SOUTHERN");
		Assert.assertNull(gameSimulator.getRobot().getDirection());
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (!gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfPlaceworksForValidButBadlyIndentedCommand() {
		gameSimulator.parseFromStandardInputandExecute("PLACE            3,  0,    NORTH");
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		assert (gameSimulator.getRobot().getXCoordinate() == 3);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}
}
