package com.org.google;

import java.util.ArrayList;

public class BitFlip {
	
	public static void main(String[] args){
		System.out.println(System.getProperty("java.version"));
		ArrayList<Integer>result = new ArrayList<Integer>();
        String A = "1101";
        char[] inputArray = A.toCharArray();
        int min_diff = 0;
        int curr_diff = 0;
        int l=1,r=1,s=1;
        int val;
        for(int i=0;i<inputArray.length;i++){
             val = (inputArray[i] == '1')?1:-1;
            curr_diff = val+curr_diff;
            if(curr_diff<min_diff){
                min_diff = curr_diff;
                l=s;
                r=i+1;
            }
            if(curr_diff>0){
                curr_diff=0;
                s=i+2;
            }
            
        }
        if(min_diff>0)
        	System.out.println("NO solution possible");
        result.add(l);
        result.add(r);
        System.out.println(result.get(0)+","+result.get(1));
	}

}
