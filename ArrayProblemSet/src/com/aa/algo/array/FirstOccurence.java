package com.aa.algo.array;

public class FirstOccurence {
	
	
	public static int getFirstOccurence(int[] a , int n) {
		
		int lo = 0;
		int hi = a.length-1;
		if(a[lo] == n) return lo;
		
		while(lo <= hi) {
			
			int mid = lo + (hi-lo)/2;
			
		    if(a[mid]< n) {
				lo = mid+1;
			}
			else if(a[mid] > n ){
				hi=mid-1;
			}
		    
		    /*else {
			int i= mid-1;
			while( i>=0  && a[i] == n) {
				i--;
			}
			return i+1;
		   } */
		    
			else {
				if(mid ==0 || a[mid-1] != a[mid])
					return mid;
				else {
					hi = mid-1;
				}
			}
		}		
		return -1;		
	}
	
	public static void main(String args[]) {
		int a [] = {1,10,10,10,20,20,40};
		System.out.println(" first occurrence of the number 20 at index : " + FirstOccurence.getFirstOccurence(a, 20));
		System.out.println(" first occurrence of the number 10 at index : " + FirstOccurence.getFirstOccurence(a, 10));
	    int b [] = {10,10,10,10,20,20,40,40,50};
	    System.out.println(" first occurrence of the number 10 at index : " + FirstOccurence.getFirstOccurence(b, 10));
		System.out.println(" first occurrence of the number 20 at index : " + FirstOccurence.getFirstOccurence(b, 20));
		System.out.println(" first occurrence of the number 40 at index : " + FirstOccurence.getFirstOccurence(b, 40));
		System.out.println(" first occurrence of the number 50 at index : " + FirstOccurence.getFirstOccurence(b, 50));
		
	}
	

}
