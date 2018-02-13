package com.org.google;

import java.util.Scanner;

public class TripleRecursion {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		int[][] result = new int[n][n];
		createMatrix(result,n,m,k,0,0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		scan.close();
	}
	
	public static void createMatrix(int[][] result,int n, int m, int k,int i, int j){
		
		if(i==n || j==n)
			return;
		if(i==0 && j==0)
			result[i][j]=m;
		else if(i==j)
			result[i][i] = result[i-1][j-1]+k;
		else if(i>j)
			result[i][j]=result[i-1][j]-1;
		else if(i<j)
			result[i][j]=result[i][j-1]-1;
		createMatrix(result,n,m,k,i+1,j);
		createMatrix(result,n,m,k,i,j+1);
		createMatrix(result,n,m,k,i+1,j+1);
		
	}	
}
