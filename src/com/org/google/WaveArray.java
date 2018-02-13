package com.org.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaveArray {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] input = new int[n];
		for(int i=0;i<n;i++){
			input[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<n;i+=2){
			if(i!=0){
				if(input[i]<input[i-1])
					swap(input,i,i-1);
			}
			if(i<n-2)
			if(input[i]<input[i+1])
				swap(input,i,i+1);
		}
		
		for(int i=0;i<n;i++){
			System.out.println(input[i]+" ");
		}
	}
	
	public static void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
	}

}
