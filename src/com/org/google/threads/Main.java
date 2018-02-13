package com.org.google.threads;

public class Main {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Task task = new Task(i);
			pool.execute(task);
		}
	}
}