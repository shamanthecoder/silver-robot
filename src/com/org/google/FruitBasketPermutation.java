package com.org.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitBasketPermutation {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String[] inputArray = new String[3];
		Map<String,Integer> frequencies = new HashMap<String,Integer>();
		scan.next();
		scan.next();
		for(int i=0;i<inputArray.length;i++){
			scan.next();
			inputArray[i] = scan.next();
		}
		for(int i=0;i<3;i++){
			String[] fruits = inputArray[i].split(",");
			for(int j=0;j<fruits.length;j++){
				if(!frequencies.containsKey(fruits[j])){
					frequencies.put(fruits[j], 1);
				}else{
					frequencies.put(fruits[j], frequencies.get(fruits[j])+1);
				}
			}
	   }
		
		for(int i=0;i<3;i++){
			int minFrequency = Integer.MAX_VALUE;
			String[]bucket = inputArray[i].split(",");
			int n= bucket.length;
			for(int j=3;j<(1<<n);j++){
				StringBuilder elements = new StringBuilder();
				for(int k=0;k<n;k++){
					if((j&(1<<k))>0){
						if(frequencies.get(bucket[k])<minFrequency)
							minFrequency = frequencies.get(bucket[k]);
						elements.append(bucket[k]);
						elements.append(",");
					}
				}
				elements.deleteCharAt(elements.length()-1);
				elements.append(" ");
				elements.append(minFrequency);
				String output = elements.toString();
				if(output.contains(","))
				System.out.println(output);
			}
			
		}
	}
}

