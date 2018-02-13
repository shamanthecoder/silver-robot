package com.org.google;

import java.util.Scanner;

public class SubsetSolution {
	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        int k = scan.nextInt();
	        int[] array = new int[n];
	        int maxCount = 0;
	        for(int i=0;i<n;i++)
	            array[i] = scan.nextInt();
	        int [] remainderArray = new int[n];
	        int [] remainderElements = new int[k];
	        boolean evenRemainder = (k%2==0)?true:false;
	        for(int i=0;i<n;i++){
	            remainderArray[i] = array[i]%k;
	            remainderElements[remainderArray[i]]++;
	        }
	        for(int i=1,j=k-1;i<=j;i++,j--){
	        	if(i!=j)
	            maxCount += (remainderElements[i]>remainderElements[j]&& i!=j)?remainderElements[i]:remainderElements[j];
	        }
	        if(evenRemainder)
	        	maxCount++;
	        if(remainderElements[0]!=0)
	            maxCount++;
	        System.out.println(maxCount);
	    }
}
