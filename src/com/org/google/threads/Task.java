package com.org.google.threads;

public class Task implements Runnable {

	private int num;

	public Task(int n) {
		this.num = n;
	}

	@Override
	public void run() {
		System.out.println("Task " + num + " is running");
	}

}

