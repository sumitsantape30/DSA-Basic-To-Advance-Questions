Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Examples:

Example 1:
Input: N = 5, array[] = {1,3,2,3,1)
Output: 2 
Explanation: The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.

Example 2:
Input: N = 4, array[] = {3,2,1,4}
Output: 1
Explaination: There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]

  
Code:
                         
package Arrays;

import java.util.ArrayList;

public class CountReverse {
	
	//Brute force
	public static int reversePairs( int arr[]) {
		int count = 0;
		
		for( int i=0; i< arr.length; i++) {
			for( int j= i+1; j< arr.length; j++) {
				
				if( arr[i] > 2*arr[j]) {
					count++;
				}
			}
		}
		return count;
	}

	//Optimal - modified merge Sort
   public static int reversePairs2(int[] nums) {
	   return mergeSort(nums, 0, nums.length-1);
    }
   
   public static int mergeSort( int nums[], int lo, int hi) {
	   
	   if( lo >= hi) { //if its a single element it'll contribute to my answer
		   return 0;
	   }
	   
	   int mid = (lo + hi)/2;
	   int inv = mergeSort(nums, lo, mid);
	   inv += mergeSort(nums, mid+1, hi);
	   inv += merge(nums, lo, mid, hi);
	   return inv;
	   
   }
   
   public static int merge( int nums[], int low, int mid, int high) {
	   
	   int cnt = 0;
	   int j = mid + 1; //j is kep at starting position of right side array
	   
	   for( int i = low; i <= mid; i++) { //i'm moving in left half of array
		   
		   while( j <= high && nums[i] > (2* (long) nums[j])) { // j<= high means either the right side of array is exhausted or condition is not being met then i'll keep on moving j++
			   j++;
		   }
		   //if any of these conditions met then i'll count the number of left elements
		   cnt += (j - (mid + 1)); 
	   }
	   
	   //then i'll perform the merge function
	   ArrayList<Integer> temp = new ArrayList<Integer>();
	   int left = low, right = mid + 1;
	   while( left <= mid && right <= high) {
		   if( nums[left] <= nums[right]) {
			   temp.add(nums[left++]);
		   }else {
			   temp.add(nums[right++]);
		   }
	   }
	   
	   while( left <= mid) {
		   temp.add(nums[left++]);
	   }
	   
	   while( right <= high) {
		   temp.add(nums[right++]);
	   }
	   
	   for( int i= low; i <= high; i++) {
		   nums[i] = temp.get( i - low);
	   }
	   return cnt;
   }
	
	public static void main(String[] args) {

		int arr[]= {1,3,2,3,1};
		System.out.println(reversePairs(arr));
	}
}
