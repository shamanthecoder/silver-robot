package com.org.google.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private final int noOfThreads;
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue<Runnable> queue;

	public ThreadPool(int n) {
		this.noOfThreads = n;
		this.queue = new LinkedBlockingQueue<Runnable>();
		this.threads = new PoolWorker[noOfThreads];
		for (int i = 0; i < noOfThreads; i++) {
			this.threads[i] = new PoolWorker();
			this.threads[i].start();
		}
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.execute(new Runnable(){
			public void run(){
				queue.poll();
			}
		});
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	private class PoolWorker extends Thread {
		public void run() {
			Runnable task;

			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException("error occured while waiting");
						}
					}
					task = queue.poll();
				}
				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted");
				}
			}
		}
	}
}
