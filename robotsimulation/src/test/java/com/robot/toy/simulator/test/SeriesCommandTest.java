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
 * This class tests different combinations of valid and invalid commands.
 */
public class SeriesCommandTest {

	private ToyGameSimulator gameSimulator;

	@Before
	public void setup() {
		Board board = new Board(5, 5);
		gameSimulator = new ToyGameSimulator(board, new ToyRobot(board));
	}

	@Test
	public void testCommandsBeforeValidPlaceCommand() {
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("PLACE 5,50,NORTH");
		gameSimulator.parseFromStandardInputandExecute("PLACE -45,50,NORTH");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		gameSimulator.parseFromStandardInputandExecute("PLACE 4,4,SOUTHERN");
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		gameSimulator.parseFromStandardInputandExecute("REPORT");
		Assert.assertNull(gameSimulator.getRobot().getDirection());
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (!gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testCommandsBeforeAndAfterValidPlaceCommand() {
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("PLACE 5,50,NORTH");
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		gameSimulator.parseFromStandardInputandExecute("PLACE 4,4,SOUTHERN");
		gameSimulator.parseFromStandardInputandExecute("REPORT");
		Assert.assertNull(gameSimulator.getRobot().getDirection());
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (!gameSimulator.getRobot().isToyOnBoard());
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,NORTH");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		gameSimulator.parseFromStandardInputandExecute("RIGHT");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("REPORT");
		// so after these moves the robot should be on [0,2] facing West.
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 2);
		assert (gameSimulator.getRobot().isToyOnBoard());
		assert (gameSimulator.getRobot().getDirection().toString().equals("WEST"));
		gameSimulator.parseFromStandardInputandExecute("LEFT");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// so after these moved the robot should be on [0,1] facing South.
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 1);
		assert (gameSimulator.getRobot().isToyOnBoard());
		assert (gameSimulator.getRobot().getDirection().toString().equals("SOUTH"));
		gameSimulator.parseFromStandardInputandExecute("REPORT");

	}

}
