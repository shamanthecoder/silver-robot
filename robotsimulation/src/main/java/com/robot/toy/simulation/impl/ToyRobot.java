package com.robot.toy.simulation.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.robot.toy.exception.InvalidCommandException;
import com.robot.toy.exception.InvalidMovementException;
import com.robot.toy.simulation.Board;
import com.robot.toy.simulation.Robot;
import com.robot.toy.simulation.ToyDirection;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * This class represents the toy robot. The position on the board and the state
 * of the robot is captured in this class.
 * 
 */

public class ToyRobot implements Robot {

	private static Logger logger = LogManager.getLogger(ToyRobot.class.getName());

	private Board board;

	/*
	 * Toy coordinates
	 */
	private int x;
	private int y;

	/*
	 * Toy status
	 */
	private boolean toyOnBoard;

	/*
	 * Direction of the toy
	 */
	private ToyDirection direction;

	/*
	 * Toy creation with a board
	 * 
	 * @param board
	 */
	public ToyRobot(Board board) {
		this.board = board;
		this.x = 0;
		this.y = 0;
		toyOnBoard = false;
	}

	public Board getBoard() {
		return this.board;
	}

	public int getXCoordinate() {
		return this.x;
	}

	public int getYCoordinate() {
		return this.y;
	}

	public void setXCoordinate(int x) {
		this.x = x;
	}

	public void setYCoordinate(int y) {
		this.y = y;
	}

	public ToyDirection getDirection() {
		return this.direction;
	}

	public boolean isToyOnBoard() {
		return this.toyOnBoard;
	}

	public void setToyOnBoard(boolean toyOnBoard) {
		this.toyOnBoard = toyOnBoard;
	}

	public void setDirection(ToyDirection direction) {
		this.direction = direction;
	}

	/*
	 * Move the toy by one unit to the next unit in the current direction of the
	 * toy.
	 */
	@Override
	public void move() throws InvalidMovementException {
		int X, Y;
		if (toyOnBoard) {
			switch (direction) {
			case NORTH:
				X = getXCoordinate();
				Y = getYCoordinate() + 1;
				break;
			case WEST:
				X = getXCoordinate() - 1;
				Y = getYCoordinate();
				break;
			case SOUTH:
				X = getXCoordinate();
				Y = getYCoordinate() - 1;
				break;
			case EAST:
				X = getXCoordinate() + 1;
				Y = getYCoordinate();
				break;
			default:
				throw new IllegalStateException("The toy is directionless and can't move, mate!!");
			}

		} else {
			throw new InvalidMovementException("The toy isn't on the board");
		}

		if (board.checkValidCoordinate(X, Y)) {
			logger.info("The toy robot is moving to new position with coordinates [" + X + "," + Y + "]");
			setXCoordinate(X);
			setYCoordinate(Y);
		} else {
			// toy can't move as the position is invalid.Ignore the move command.
			logger.info("The toy robot cannot move as the new postion is invalid");

		}

	}

	/*
	 * Turn left command to rotate the toy by 90 degrees to the right
	 */
	@Override
	public void turnLeft() throws InvalidCommandException {
		if (toyOnBoard) {
			switch (direction) {
			case NORTH:
				setDirection(ToyDirection.WEST);
				break;
			case WEST:
				setDirection(ToyDirection.SOUTH);
				break;
			case SOUTH:
				setDirection(ToyDirection.EAST);
				break;
			case EAST:
				setDirection(ToyDirection.NORTH);
				break;
			default:
				throw new IllegalStateException("\"The toy is directionless and can't turn left, mate!!\"");

			}
		} else {
			throw new InvalidCommandException("The toy isn't on the board");
		}

	}

	/*
	 * Turn right command to rotate the toy by 90 degrees to the
	 */
	@Override
	public void turnRight() throws InvalidCommandException {

		if (toyOnBoard) {
			switch (direction) {
			case NORTH:
				setDirection(ToyDirection.EAST);
				break;
			case WEST:
				setDirection(ToyDirection.NORTH);
				break;
			case SOUTH:
				setDirection(ToyDirection.WEST);
				break;
			case EAST:
				setDirection(ToyDirection.SOUTH);
				break;
			default:
				throw new IllegalStateException("\"The toy is directionless and can't turn right, mate!!\"");

			}
		} else {
			throw new InvalidCommandException("The toy isn't on the board");
		}

	}

	/*
	 * Place command to place the robot on the board.
	 */
	@Override
	public void place(int x, int y, String direction) throws InvalidCommandException {
		if (board.checkValidCoordinate(x, y) && checkValidDirecton(direction)) {

			setXCoordinate(x);
			setYCoordinate(y);
			setDirection(ToyDirection.valueOf(direction));
			this.toyOnBoard = true;

		} else {
			throw new InvalidCommandException(
					"The cooridnates [" + x + "," + y + "] not valid or the direction [" + direction + "] is invalid.");
		}
	}

	/*
	 * Report command reporting the current status of the robot on the board.
	 */
	@Override
	public void report() throws InvalidCommandException {
		if (toyOnBoard) {
			System.out.println("Output: " + x + "," + y + "," + direction.toString());
		} else {
			throw new InvalidCommandException("The toy isn't on the board hence cannot report the position");
		}
	}

	/*
	 * Check if the direction given is valid.
	 * 
	 */
	public boolean checkValidDirecton(String direction) {
		try {
			switch (ToyDirection.valueOf(direction)) {
			case NORTH:
				return true;
			case WEST:
				return true;
			case SOUTH:
				return true;
			case EAST:
				return true;
			default:
				return false;
			}
		} catch (IllegalArgumentException ie) {
			// invalid direction and hence this exception
			return false;
		}
	}

}
