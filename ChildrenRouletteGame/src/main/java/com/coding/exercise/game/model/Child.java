package com.coding.exercise.game.model;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * This class represents a child.
 */
public class Child {

	private String childName;

	private int childId;

	public Child(String childName, int childId) {
		this.childName = childName;
		this.childId = childId;
	}

	public String getChildName() {
		return this.childName;
	}

	public int getChildId() {
		return this.childId;
	}

}
