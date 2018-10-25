package com.robot.toy.simulation;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * This class is a Board class and defines the characteristics of the Board on
 * which the toy runs.
 * 
 */

public class Board {

	private int height;
	private int width;

	/*
	 * Construct the board with given height and width
	 * 
	 * @param height
	 * 
	 * @param width
	 * 
	 */

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public boolean checkValidCoordinate(int x, int y) {
		if (x >= 0 && x < width && y >= 0 && y < height)
			return true;
		return false;
	}

}
