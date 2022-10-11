Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
  
Input format: Arr[] = {1,3,2}

Output: Arr[] = {2,1,3}

Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.


class Solution {
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return; // if length of array is null or has single element the next permutation will be he himself
        
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; //yeh loop tabtak chalega jabtak yeh condition false nhi hot, jaisehi yeh false hogi means arr[i] < arr[i+1] wala element mil gya
        if(i >= 0) { // only if we ge the break points, then we again linearly iterate back and we try to find some who is greater than i               
            int j = A.length - 1;              
            while(A[j] <= A[i]) j--;      
            swap(A, i, j);                     
        }//if there's no breakpoint this if would have never performed
        reverse(A, i + 1, A.length - 1);   //after swapping simply reverse the right half   
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
  }
  
}

//===========================================================

package Arrays;

import java.util.Arrays;

public class setMatrixZeroes {

	public static void nextPermutation( int arr[]) {
		
		int i= arr.length-2;
		while( i >=0 && arr[i] >= arr[i+1]) {
			i--;
		}
		
		if( i >= 0) {
			int j= arr.length-1;
			
			while(j>=0 && arr[j] <= arr[i]) { //jabtak index1 se badi values hai piche aate rahenge
				j--;
			}
			swap(arr, i, j);
		}
		
		reverse(arr, i + 1, arr.length - 1);
	}
	
	public static void swap( int arr[], int i, int j) {
		int temp=  arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void reverse( int arr[], int i, int j) {
		
		while( i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
	}

	public static void main(String[] args) {
		int arr[]= {1,3,5,4,2};
		nextPermutation(arr);
		for( int i=0; i< arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}

