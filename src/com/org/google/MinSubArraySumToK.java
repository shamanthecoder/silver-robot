package com.org.google;

import java.util.Scanner;

/**
 * 
 * @author shyamanthegde
 *
 */
public class MinSubArraySumToK {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[] array = new int[t];
		for(int i=0;i<t;i++){
			array[i]=scan.nextInt();
		}
		int k = scan.nextInt();
		int minLen = minimumLen(array,k);
		System.out.println("The minimum elements is "+minLen);
		scan.close();

	}

	public static int minimumLen(int[] array,int k){
		int current_sum = array[0];
		int startPoint=0,endPoint=0;
		int minLen = array.length+1;
		
		while(endPoint<array.length){
			//add the elements one by one
            while (current_sum <= k && endPoint < array.length)
            {
            	current_sum = current_sum+array[endPoint];
            	endPoint++;
            }
            //Solution reached if sum greater than k.
            while (current_sum > k && startPoint < array.length) 
            {
                if (endPoint - startPoint < minLen)
                    minLen = endPoint - startPoint;
                //Slide the window for getting the best solution
                current_sum = current_sum - array[startPoint];
                startPoint++;
            }
		}
		
		return minLen;
		
	}
}
