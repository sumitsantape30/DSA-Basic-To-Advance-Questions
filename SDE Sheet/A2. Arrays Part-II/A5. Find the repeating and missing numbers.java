Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Example 1:
Input Format:  array[] = {3,1,2,5,3}
Result: {3,4)
Explanation: A = 3 , B = 4 
Since 3 is appearing twice and 4 is missing
  
Example 2:
Input Format: array[] = {3,1,2,5,4,6,7,5}
Result: {5,8)
Explanation: A = 5 , B = 8 
Since 5 is appearing twice and 8 is missing
  
Code:

//================================= Brute Force========================================

package Codes;

import java.util.*;
import java.io.*;

public class ques {

	public static int[] findMissingRepeatingNumbers( int arr[]) {
		
		int freq[]= new int[arr.length+1];
		
		for( int i=0; i< arr.length; i++) {
			freq[arr[i]]++;
		}
		
		for( int i=0; i< freq.length; i++) {
			System.out.println(freq[i]);
		}
		
		int repeating = -1;
		int missing= -1;
		
		for( int i=1; i< freq.length; i++) {
			
			if( freq[i] == 2) {
				repeating = i;
			}
			
		}
		
		for( int i=1; i< freq.length; i++) {
			
			if( freq[i] == 0) {
				missing= i;
			}
		}
		
		int ans[]= new int[2];
		ans[0]= repeating;
		ans[1]= missing;
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		 int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
	        int[] ans = findMissingRepeatingNumbers(a);
	        System.out.println("The repeating and missing numbers are: {"
	                           + ans[0] + ", " + ans[1] + "}");

	}
}

//========================================================Optimised ========================

