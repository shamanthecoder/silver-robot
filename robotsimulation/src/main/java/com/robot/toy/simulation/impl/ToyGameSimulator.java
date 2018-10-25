package com.robot.toy.simulation.impl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.robot.toy.exception.CatostrophicException;
import com.robot.toy.exception.InvalidCommandException;
import com.robot.toy.exception.InvalidMovementException;
import com.robot.toy.simulation.Board;
import com.robot.toy.simulation.Command;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * The toy game simulator class which simulates different movement of the robot.
 */

public class ToyGameSimulator {
	private static final Logger logger = LogManager.getLogger(ToyGameSimulator.class);

	Board board;
	ToyRobot robot;

	private static final Pattern SUPPORTED_PATTERN = Pattern
			.compile("^\\s*PLACE\\s+(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\w+)\\s*");

	public ToyGameSimulator(Board board, ToyRobot robot) {
		this.board = board;
		this.robot = robot;
	}

	/*
	 * Parse from the file and execute the commands.
	 */
	public void parseFromInputFileandExecute(String filepath) throws CatostrophicException, IOException {
		if (filepath == null || "".equals(filepath))
			throw new CatostrophicException("File [" + filepath + "] does not exists");
		File file = new File(filepath);
		if (!file.exists()) {
			throw new CatostrophicException("File [" + filepath + "] does not exists");
		}
		if (!file.canRead()) {
			throw new IOException("File [" + filepath + "] cannot be read.");
		}
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			try {
				executeCommand(scanner.nextLine());
			} catch (InvalidMovementException e) {
				// log it and ignore the invalid movement.
				logger.info(e.getMessage());
			} catch (InvalidCommandException ie) {
				// log it and ignore the invalid command.
				logger.info(ie.getMessage());
			}
		}

	}

	/*
	 * Execute commands from the Standard Input
	 */
	public void parseFromStandardInputandExecute(String commandString) {
		try {
			executeCommand(commandString);
		} catch (InvalidMovementException e) {
			// log it and ignore the command as it is invalid movement.
			logger.info(e.getMessage());
		} catch (InvalidCommandException ie) {
			logger.info(ie.getMessage());
		}
	}

	/*
	 * Executes the command and produces the output
	 */
	private void executeCommand(String commandString) throws InvalidCommandException, InvalidMovementException {

		String[] commands = commandString.split(" ");

		Command command;
		try {
			command = Command.valueOf(commands[0]);
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandException("Invalid command in the input");
		}
		switch (command) {
		case PLACE:
			if (commands.length < 2) {
				throw new InvalidCommandException("Invalid Place command.");
			}
			try {
				// parse the place command according to the regex to take care of badly indented
				// but valid command.
				Matcher matcher = SUPPORTED_PATTERN.matcher(commandString);
				if (matcher.find() && matcher.hitEnd()) {
					int x = Integer.parseInt(matcher.group(1));
					int y = Integer.parseInt(matcher.group(2));
					String direction = matcher.group(3);
					robot.place(x, y, direction);
				}
			} catch (NumberFormatException e) {
				throw new InvalidCommandException(e.getMessage());
			}
			break;
		case MOVE:
			robot.move();
			break;
		case LEFT:
			robot.turnLeft();
			break;
		case RIGHT:
			robot.turnRight();
			break;
		case REPORT:
			robot.report();
			break;
		default:
			throw new InvalidCommandException("Invalid command in the input");
		}

	}

	public ToyRobot getRobot() {
		return this.robot;
	}

	public Board getBoard() {
		return this.board;
	}
}
