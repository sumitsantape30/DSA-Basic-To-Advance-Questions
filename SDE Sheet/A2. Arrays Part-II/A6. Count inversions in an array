Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Example 1:

Input Format: N = 5, array[] = {1,2,3,4,5}

Result: 0

Explanation: we have a sorted array and the sorted array 
has 0 inversions as for i < j you will never find a pair 
such that A[j] < A[i]. More clear example: 2 has index 1 
and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an 
inversion.
Example 2:

Input Format: N = 5, array[] = {5,4,3,2,1}

Result: 10

Explanation: we have a reverse sorted array and we will 
get the maximum inversions as for i < j we will always 
find a pair such that A[j] < A[i]. 
Example: 5 has index 0 and 3 has index 2 now (5,3) pair 
is inversion as 0 < 2 and 5 > 3 which will satisfy out 
conditions and for reverse sorted array we will get 
maximum inversions and that is (n)*(n-1) / 2.

For above given array there is 4 + 3 + 2 + 1 = 10 inversions.
Example 3:

Input Format: N = 5, array[] = {5,3,2,1,4}

Result: 7

Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),
(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and 
(1,4) as both are not satisfy our condition. 

Code:

package Arrays;

import java.util.Scanner;

public class CountInversions {
	
	public static int merge( int arr[], int temp[], int left, int mid, int right) {
		
		int inv_Count= 0;
		
		int i= left; //i is index for left subarray
		int j= mid; //j is index for right subarray
		int k = left; //k is index for resultant merged subarray: temp wala array, k= 0 bhi rakh skte ho, left bhi 0 hi hai
		
		while( (i <= mid-1) && (j<= right)) {
			if( arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++]= arr[j++];
				
				inv_Count = inv_Count  + (mid - i); //addition will be the count of elements which are in the right of mid, as second array start at mid so from i I need to count the elements till mid which occurs by doing (mid-i)
				//added count of all elements to the right
			}
		}
		
		while( i <= mid-1) {
			temp[k++] = arr[i++];
		}
		
		while( j <= right) {
			temp[k++] = arr[j++];
		}
		
		//now temp array has sorted array of two left and right arrays so it back to the original array
		for( i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
		return inv_Count;
	}
	
	public static int mergeSort(int arr[], int temp[], int left, int right) {
		
		int inv_Count = 0;
		
		while(right > left){
			
			int mid = (left + right)/2;
			
			inv_Count += mergeSort(arr, temp, left, mid);
			inv_Count += mergeSort(arr, temp, mid+1, right);
			
			inv_Count += merge(arr, temp, left,mid+1, right); //mid isliye pass kiye taki dono arrays ko divide kr ske merge function mai
		}
		
		return inv_Count;
	}

	public static void main(String[] args) {

		int n= 5;
		int arr[]= {5,4,3,2,1};
		//you have given only an array and its size n
		
		int temp[] = new int[n]; //jab merge karenge to iss extra array mai store karegne isliye pehliehi pass kr rhe hai yafir merge function mai bhi bana skte the
		System.out.println(mergeSort(arr, temp, 0, n-1));
		
	}

}
