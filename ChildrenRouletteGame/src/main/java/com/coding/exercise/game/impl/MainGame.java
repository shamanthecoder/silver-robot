package com.coding.exercise.game.impl;

import java.util.Scanner;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Main class for the game.Takes input from the user to kick off the elimination
 * game.
 */

public class MainGame {

	public static void main(String[] args) {

		System.out.println("Enter value for n and k");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		ChildrenGameImpl cgi = new ChildrenGameImpl(n, k);
		System.out.println("Enter the child ID where the game should start. Value must be 0<childId<=n");
		scan = new Scanner(System.in);
		int childId = scan.nextInt();
		// set the Id from where you want to begin the game of elimination.
		cgi.setUpTheSequenceNumber(childId);
		// play the game
		cgi.playTheGame();
		System.exit(0);

	}

}
