package com.robot.toy.simulation.impl;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.robot.toy.exception.CatostrophicException;
import com.robot.toy.simulation.Board;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * The main class for starting the simulation.
 * 
 */
public class Mainclass {
	private static final Logger logger = LogManager.getLogger(Mainclass.class);

	public static void main(String... args) throws IOException {

		// Create the board and the robot
		Board board = new Board(5, 5);
		ToyGameSimulator gameSimulator = new ToyGameSimulator(board, new ToyRobot(board));
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the option for input type.Valid inputs are 1 or 2");
		System.out.println("1:Input file");
		System.out.println("2:Standard Input");
		int input = scan.nextInt();
		if (input == 1) {
			System.out.println("Please enter the input file name");
			scan = new Scanner(System.in);
			String filepath = scan.nextLine();
			try {
				gameSimulator.parseFromInputFileandExecute(filepath);
			} catch (CatostrophicException ce) {
				// Serious failure and application has to halt.
				System.out.println("File could not be found");
				logger.error(ce.getMessage());
				System.exit(1);
			}

		} else if (input == 2) {
			System.out.println("Valid commands for Robot simualtion are");
			System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\'");
			System.out.println("MOVE");
			System.out.println("LEFT");
			System.out.println("RIGHT");
			System.out.println("REPORT");
			System.out.println("Enter EXIT to end the simulation");
			scan = new Scanner(System.in);
			while (true) {
				String inputCommand = scan.nextLine();
				if (inputCommand == null || inputCommand.equals("EXIT"))
					break;
				gameSimulator.parseFromStandardInputandExecute(inputCommand);

			}
		} else
			System.out.println("Please enter 1 or 2");

	}

}
