package com.org.google;

public class NumberPrinting {
	private static int MAX=10;
	public static void main(String[] args) throws InterruptedException{
		PrintResources printResources = new PrintResources();
		Thread t1 = new Thread(new NumberPrinter("odd",1,printResources));
		Thread t2 = new Thread(new NumberPrinter("even",2,printResources));
		
		t1.start();
		t2.start();
		
		
	}

	
	public static class PrintResources{
		
		public PrintResources(){
			
		}
		
		public void print(String n){
			System.out.println(n);
		}
		
	}
	
	public static class NumberPrinter implements Runnable{

		private int seed;
		PrintResources print;
		String name;
		
		public NumberPrinter(String name,int n, PrintResources print){
			this.seed=n;
			this.print = print;
			this.name=name;
		}
		@Override
		public void run() {
			int count = 1;
			while(true){
				synchronized(print){
					print.print("Thread name "+this.name+"   "+seed);
					seed+=2;
					print.notifyAll();
				
				if(count<=MAX){
					try {
						print.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					break;
				}
				count++;
				}
			}
		}
		
	}
}


