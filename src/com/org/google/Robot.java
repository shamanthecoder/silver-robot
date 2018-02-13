package com.org.google;

import java.util.Scanner;

public class Robot {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String inputString = scan.next();
		int[] brickCount = new int[10];
		char[] inputCharacters = inputString.toCharArray();
		char[] outputArray = new char[10];
		boolean alreadyPicked = false;
		int brickPosition = 0;
		for (char c : inputCharacters) {
			switch (c) {

			case 'P':
				if (alreadyPicked)
					brickPosition = 0;
				alreadyPicked = true;
				break;

			case 'M':
				if (brickPosition > 9)
					break;
				brickPosition++;
				break;

			case 'L':
				if (!alreadyPicked)
					break;
				if (brickCount[brickPosition] < 15){
					brickCount[brickPosition]++;
					alreadyPicked = false;
					brickPosition=0;
				}
				break;
			}

		}
		
		//hexa conversion
		for(int i=0;i<brickCount.length;i++){
			if(brickCount[i]>9) {
				switch (brickCount[i]) {
					case 10:
						outputArray[i] = 'A';
						break;
					case 11:
						outputArray[i] = 'B';
						break;
					case 12:
						outputArray[i] = 'C';
						break;
					case 13:
						outputArray[i] = 'D';
						break;
					case 14:
						outputArray[i] = 'E';
						break;
					case 15:
						outputArray[i] = 'F';
						break;	
				}
			}else
				outputArray[i] = Character.forDigit(brickCount[i], 10);
		}
		
		System.out.println(String.copyValueOf(outputArray));
		
	}

}
