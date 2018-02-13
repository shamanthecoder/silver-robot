package com.org.google;

import java.util.ArrayList;
import java.util.Scanner;

public class FindSubArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		ArrayList<Integer>list1 = new ArrayList<Integer>();
		ArrayList<Integer>list2 = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			list1.add(scan.nextInt());
		}
		for(int i=0;i<m;i++){
			list2.add(scan.nextInt());
		}
		
		int index = binarySearch(list1,0,n-1,list2.get(0));
		if(index==-1){
			System.out.println(index);
			return;
		}
		
		for(int i=index;i<index+m;i++){
			if(list1.get(i)!=list2.get(i)){
				System.out.println(-1);
				return;
			}
		}
		System.out.println(index+1);
		
	}
	
	public static int binarySearch(ArrayList<Integer> list,int l,int r,int ele){
		int mid = r-(l+r)/2;
		if(r>=l){
		if(list.get(mid) == ele){
			return mid;
		}
		if(list.get(mid)>ele)
			binarySearch(list,l,mid-1,ele);
		return binarySearch(list,mid+1,r,ele);
		}
		return -1;
		
	}

}
