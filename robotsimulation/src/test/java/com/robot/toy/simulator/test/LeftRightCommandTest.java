package com.robot.toy.simulator.test;

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
 * This class has test cases which tests different usecases for turning left and
 * right.
 */
public class LeftRightCommandTest {

	private ToyGameSimulator gameSimulator;

	@Before
	public void setup() {
		Board board = new Board(5, 5);
		gameSimulator = new ToyGameSimulator(board, new ToyRobot(board));
	}

	@Test
	public void testLeftTurnStartFacingNorth() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,NORTH");
		// turn left
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		// check direction for WEST after left turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("WEST"));
		// turn left
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		// check direction for SOUTH after left turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("SOUTH"));
		// turn left
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		// check direction for EAST after left turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("EAST"));
		// turn left
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		// check direction for NORTH after left turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		// check if robot is in proper place after all the left turns.
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());

	}

	@Test
	public void testRightTurnStartFacingNorth() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,NORTH");
		// turn right
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		// check direction for EAST after right turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("EAST"));
		// turn right
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		// check direction for SOUTH after right turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("SOUTH"));
		// turn right
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		// check direction for WEST after right turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("WEST"));
		// turn right
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		// check direction for NORTH after right turn
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		// check if robot is in proper place after all the right turns.
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testInvalidLeftRightCommand() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,NORTH");

		// issue invalid left command
		gameSimulator.parseFromStandardInputandExecute("LEFTERRRR");
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		// issue invalid right command
		gameSimulator.parseFromStandardInputandExecute("RIGHTRRRR");
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));

	}

}
