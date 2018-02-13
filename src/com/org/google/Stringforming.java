package com.org.google;

import java.util.Scanner;

public class Stringforming {

	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0;i<t;i++){
            int n = scan.nextInt();
            calculate(n);
        }
        
	}
	
	public static void calculate(int n){
	    int totale = Double.valueOf(Math.pow(3, n)).intValue();
	    int firstExpression = Double.valueOf(Math.pow(2,n)).intValue()-n-1;
	    int secondExpression = Double.valueOf(Math.pow(2,n)).intValue()-n-1-(n*(n-1))/2;
	    System.out.println(totale-firstExpression-secondExpression);
	}
	
	public static int permutation(int n){
	    if(n ==1 || n==0)
	        return 1;
	        return n*permutation(n-1);
	}
}
