package com.robot.toy.simulation;

import com.robot.toy.exception.InvalidCommandException;
import com.robot.toy.exception.InvalidMovementException;

/**
 * 
 * @author Shyamant
 *
 */
public interface Robot {

	public void move() throws InvalidMovementException;

	public void turnLeft() throws InvalidCommandException;

	public void turnRight() throws InvalidCommandException;

	public void place(int x, int y, String direction) throws InvalidCommandException;

	public void report() throws InvalidCommandException;

}
