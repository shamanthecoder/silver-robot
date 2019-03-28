package com.coding.test.anz;

import java.util.Scanner;

/*
 * @author Shyamant Hegde
 */

/*
 * This class calculates minimum number of swaps required to sort an array in increasing order.
 * 
 */
public class MinimumSwapSortArray {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = scan.nextInt();

		int[] input = new int[n];
		System.out.println("Enter the array elements one after the other");
		
        for (int i = 0; i < n; i++) {
        	input[i] = scan.nextInt();
        }

        int result = minimumSwapsRequired(input);
        System.out.println("Number of swaps required is "+ result);
	}
	
	/*
	 * The minimum swaps required is calculated using the cycles in the array. As the input elements are 1<=i<=n we can use the target indexes 
	 * to create a cycle and elements within a cycle will be swapped. Total swaps will be summation of all the swaps within a cycle. So we find all the cycles covering
	 * all the elements of the array and we arrive at the answer.
	 */
	private static int minimumSwapsRequired(int[] input) {
		int answer = 0;
		//Array to track the cycles in the array where mutual swapping will happen.
		boolean[] cycleTracker = new boolean[input.length];
		
		for(int i=0;i<input.length;i++) {
			int j=i,cycle=0;

			//find the cycles. The swaps needed to sort the cycle will be cycle-1
			while(!cycleTracker[j]){
				cycleTracker[j]=true;
				j=input[j]-1;
				cycle++;
			}
			
			//Add the swaps for a cycle to the answer as answer is summation of all swaps in all cycles.
			if(cycle!=0)
				answer+=cycle-1;
		}
		return answer;		
		}
	}
