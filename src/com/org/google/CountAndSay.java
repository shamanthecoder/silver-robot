package com.org.google;

import java.util.Scanner;

public class CountAndSay {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String start = "1211";
		String temp = new String();
		int count = 1;
		for(int i=0;i<n;i++){
			start+="$";
			int len = start.length();
			temp = new String();
			for(int j=1;j<len;j++){
				if(start.charAt(j)!=start.charAt(j-1)){
					temp+=String.valueOf(count);
					temp+=start.charAt(j-1);
					count=1;
				}
				else
					count++;
			}
			start=temp;
		}
		System.out.println(start);
	}

}
