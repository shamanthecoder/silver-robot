package com.org.google;

import java.util.ArrayList;
import java.util.Scanner;

public class AtlassianBaseConversion {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] base7Array =  new String[] {"0","a","t","l","s","i","n"};
		ArrayList<Long> list = new ArrayList<Long>();
		while(n!=0){
			long remainder = n%7;
			list.add(remainder);
			n=n/7;
		}
		int j = list.size()-1;
		StringBuilder base7result = new StringBuilder();
		while(j>=0){
			base7result.append(base7Array[list.get(j).intValue()]);
			j--;
		}
		System.out.println(base7result.toString());
	}
}
