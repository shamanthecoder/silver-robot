package com.org.google;

import java.util.Scanner;

public class GeneratePowerSet {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		char [] set = input.toCharArray();
		int n = set.length;
		for(int i=0;i<(1<<n);i++){
			System.out.print("{ ");
			for(int j=0;j<n;j++){
				if((i&(1<<j))>0){
					System.out.print(set[j]+" ");
				}
			}
			System.out.println("}");
		}
		int x = -3;
		System.out.println(0-x);
	}

}
