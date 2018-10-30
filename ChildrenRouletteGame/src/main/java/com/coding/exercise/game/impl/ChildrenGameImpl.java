package com.coding.exercise.game.impl;

import java.util.ArrayList;

import com.coding.exercise.game.model.Child;
import com.coding.exercise.game.model.Game;

/**
 * 
 * @author Shyamant
 *
 */

public class ChildrenGameImpl implements Game {

	private int noOfChildren;
	private int eliminatingNumberK;

	private ArrayList<Child> children;

	@Override
	public Integer playTheGame() {
		// Eliminate Kth child in every iteration.
		int eliminateKth = 0;

		System.out.println("Elimination order: ");
		while (children.size() > 1) {
			eliminateKth = (eliminateKth + eliminatingNumberK - 1) % children.size();
			System.out.println(children.get(eliminateKth).getChildName() + " with ID "
					+ children.get(eliminateKth).getChildId() + " is eliminated");
			children.remove(eliminateKth);
		}
		System.out.println();
		System.out.println("The winner of the game is " + children.get(0).getChildName() + " with ID "
				+ children.get(0).getChildId());
		return children.get(0).getChildId();
	}

	public ChildrenGameImpl(int noOfChildren, int eliminatingNumberK) {
		this.noOfChildren = noOfChildren;
		this.eliminatingNumberK = eliminatingNumberK % noOfChildren;
		if (this.noOfChildren < 0 || this.eliminatingNumberK <= 0) {
			System.out.println("Invalid input");
			System.exit(1);
		}
	}

	/*
	 * Given child where the game starts
	 */
	public void setUpTheSequenceNumber(int givenChildId) {
		if (givenChildId < 1 || givenChildId > noOfChildren) {
			System.out.println("Invalid input");
			System.exit(1);
		}
		children = new ArrayList<Child>(noOfChildren);
		for (int i = givenChildId, j = 0; i <= noOfChildren && j < noOfChildren; i = ((i + 1) % noOfChildren), j++) {
			if (i == 0) {
				i = noOfChildren;
			}
			Child child = new Child("Child" + (i), i);
			children.add(child);
		}
	}

	/*
	 * Set the no of children playing this game.
	 */
	public void setnoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	/*
	 * Set the eliminating factor number K.
	 */
	public void seteliminatingNumberK(int eliminatingNumberK) {
		this.eliminatingNumberK = eliminatingNumberK;

	}

	/*
	 * Get no of children playing the game.
	 */

	public int getnoOfChildren() {
		return this.noOfChildren;
	}

	/*
	 * Get the eliminating factor K.
	 */
	public int geteliminatingNumberK() {
		return this.eliminatingNumberK;
	}

}
