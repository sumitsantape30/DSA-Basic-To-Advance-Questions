Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. 
  Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
  
Example 1:

Input: 
n = 4, arr1[] = [1 4 8 10] 
m = 5, arr2[] = [2 3 9]

Output: 
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:
After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]

Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:
After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
  
Code:

//========================== Brute Force=========================
package Arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class setMatrixZeroes {
	
	public static void mergeArrays( int arr1[], int arr2[]) {
		
		int ans[]= new int[arr1.length + arr2.length];
		int idx= 0;
		
		for( int i=0; i< arr1.length; i++) {
			ans[idx]= arr1[i];
			idx++;
		}
		
		for( int i=0; i< arr2.length; i++) {
			ans[idx] = arr2[i];
			idx++;
		}
		
		Arrays.sort(ans);
		idx= 0;
		
		for( int i=0; i< arr1.length; i++) {
			arr1[i] = ans[idx];
			idx++;
		}
		
		for( int j=0; j< arr2.length; j++) {
			arr2[j] = ans[idx];
			idx++;
		}
		
		for( int i=0; i< arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for( int j=0; j < arr2.length; j++) {
			System.out.print(arr2[j]+" ");
		}
		
	}

	public static void main(String[] args) {
		int arr1[]= {1, 4, 8, 10};
		int arr2[]= {2, 3, 9};
		mergeArrays(arr1, arr2);
		
	}

}
