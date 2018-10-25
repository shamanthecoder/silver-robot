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
 * This class tests Move command under different scenario.
 */
public class MoveCommandTest {

	private ToyGameSimulator gameSimulator;

	@Before
	public void setup() {
		Board board = new Board(5, 5);
		gameSimulator = new ToyGameSimulator(board, new ToyRobot(board));
	}

	@Test
	public void testIfValidMoveCommandAfterPlacedToNORTH() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,NORTH");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// 2 moves done in NORTH
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 2);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfValidMoveCommandAfterPlacedToWEST() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 4,0,WEST");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// 2 moves done to WEST after being placed at [4,0]
		assert (gameSimulator.getRobot().getDirection().toString().equals("WEST"));
		assert (gameSimulator.getRobot().getXCoordinate() == 2);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfValidMoveCommandAfterPlacedToSOUTH() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 4,4,SOUTH");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// 2 moves done to SOUTH after being placed at [4,4]
		assert (gameSimulator.getRobot().getDirection().toString().equals("SOUTH"));
		assert (gameSimulator.getRobot().getXCoordinate() == 4);
		assert (gameSimulator.getRobot().getYCoordinate() == 2);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfValidMoveCommandAfterPlacedToEAST() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,EAST");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// 2 moves done to EAST after being placed at [0,0]
		assert (gameSimulator.getRobot().getDirection().toString().equals("EAST"));
		assert (gameSimulator.getRobot().getXCoordinate() == 2);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfRobotdoesntFallWithEdgeMoveWEST() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,WEST");
		// should ignore this move as the robot is on the edge
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// robot should be where it was when placed.
		assert (gameSimulator.getRobot().getDirection().toString().equals("WEST"));
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfRobotdoesntFallWithEdgeMoveNORTH() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,4,NORTH");
		// should ignore this move as the robot is on the edge
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// robot should be where it was when placed.
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 4);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfRobotdoesntFallWithEdgeMoveEAST() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 4,4,EAST");
		// should ignore this move as the robot is on the edge
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// robot should be where it was when placed.
		assert (gameSimulator.getRobot().getDirection().toString().equals("EAST"));
		assert (gameSimulator.getRobot().getXCoordinate() == 4);
		assert (gameSimulator.getRobot().getYCoordinate() == 4);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testIfRobotdoesntFallWithEdgeMoveSOUTH() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 4,0,SOUTH");
		// should ignore this move as the robot is on the edge
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// robot should be where it was when placed.
		assert (gameSimulator.getRobot().getDirection().toString().equals("SOUTH"));
		assert (gameSimulator.getRobot().getXCoordinate() == 4);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testForconsecutiveMovesgoingbeyondEdgeOnX() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,EAST");
		// move more than 5 times which is beyond the board dimensions.
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// these 2 should be ignored as the robot is on the edge
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		assert (gameSimulator.getRobot().getDirection().toString().equals("EAST"));
		assert (gameSimulator.getRobot().getXCoordinate() == 4);
		assert (gameSimulator.getRobot().getYCoordinate() == 0);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

	@Test
	public void testForconsecutiveMovesgoingbeyondEdgeOnY() {
		gameSimulator.parseFromStandardInputandExecute("PLACE 0,0,NORTH");
		// move more than 5 times which is beyond the board dimensions.
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		// these 2 should be ignored as the robot is on the edge
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		gameSimulator.parseFromStandardInputandExecute("MOVE");
		assert (gameSimulator.getRobot().getDirection().toString().equals("NORTH"));
		assert (gameSimulator.getRobot().getXCoordinate() == 0);
		assert (gameSimulator.getRobot().getYCoordinate() == 4);
		assert (gameSimulator.getRobot().isToyOnBoard());
	}

}
