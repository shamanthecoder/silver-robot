package com.org.google;

import java.util.Scanner;

public class LuckyPurchase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] inputArray = new String[n];
		String[] priceArray = new String[n];
		String output = "-1";
		int currentPrice = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			inputArray[i] = scan.next();
			priceArray[i] = scan.next();
		}
		for (int i = 0; i < n; i++) {
			int price = Integer.parseInt(priceArray[i]);
			int x = price;
			int noOfFours = 0;
			int noOfSevens = 0;
			boolean invalidDigit = false;
			while (x > 0) {
				int digit = x % 10;
				if (digit != 4 && digit != 7) {
					invalidDigit = true;
					break;
				}
				if(digit ==4)
					noOfFours++;
				else
					noOfSevens++;
					
				x = x / 10;
			}
			if (!invalidDigit && (noOfFours == noOfSevens)) {
				if (price < currentPrice) {
					currentPrice = price;
					output = inputArray[i];
				}
			}
		}
		System.out.println(output);
		scan.close();
	}
}
