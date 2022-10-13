Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.

Examples:

Example 1: 

Input: arr=[1,3,4,2,2]

Output: 2

Explanation: Since 2 is the duplicate number the answer will be 2.

Example 2:

Input: [3,1,3,4,2]

Output:3

Explanation: Since 3 is the duplicate number the answer will be 3.
  
Code:

package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class findDuplicate {
	
	// brute force
	public static int duplicate( int arr[]) {
		
		Arrays.sort(arr);
		
		for( int i=0; i< arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				return arr[i];
			}
		}
		
		return -1;
	}
	
	//better
	public static int duplicate1( int arr[]) {
		int n= arr.length;
		int freq[]= new int[n + 1];
		
		for( int i=0; i< arr.length; i++) {
			
			if( freq[arr[i]] == 0) {
				freq[arr[i]] += 1;
			}else {
				return arr[i];
			}
		}
		return -1;
	}
	
	//optimised
	public static int findDuplicate2(int nums[]) {
		
		 int slow = nums[0];
	     int fast = nums[0];
	     
	        do {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        } while (slow != fast);

//	        while( true) {
//	        	slow= nums[slow];
//	        	fast = nums[nums[fast]];
//	        	if( slow == fast) {
//	        		break;
//	        	}
//	        }
	        
	        System.out.println(fast);

			//jab dono ek point ko point kr rhe to ab fast ko 0th element pe loke jao aur donoko ekek se aage badhao
	        fast = nums[0];
	        while (slow != fast) {
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        return slow;
		
	}

	public static void main(String[] args) {

		int arr[]= {2,5,9,6,9,3,8,9,7,1};
		System.out.println(findDuplicate2(arr));
	}

}
