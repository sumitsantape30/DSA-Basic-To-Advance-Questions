Kth largest/smallest element in an array
Problem Statement: Given an unsorted array, print Kth Largest and Smallest Element from an unsorted array.

Examples:

Example 1:
Input: Array = [1,2,6,4,5,3] , K = 3 
Output: kth largest element = 4, kth smallest element = 3

Example 2:
Input: Array = [1,2,6,4,5] , k = 3
Output : kth largest element = 4,  kth smallest element = 4
  
Code:

//====================================== Better =========================================================

import java.util.*;
class Solution {

    static void kth_Largest_MaxHeap(int[] arr, int k) {

        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->b-a);
        
        int n = arr.length  ;

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i])  ;
        }

        int f = k - 1 ;

        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }

        System.out.println("Kth Largest element "+pq.peek())  ;
    }

    static void kth_Smallest_MinHeap(int[] arr, int k) {

        PriorityQueue<Integer>pq= new PriorityQueue<>();
        int n = arr.length  ;

        for (int i = 0; i < n; i++) {
            pq.add(arr[i])  ;
        }

        int f = k - 1 ;

        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }

        System.out.println("Kth Smallest element "+pq.peek())  ;
    }
 
public static void main(String args[]) {

    int arr[] = {1, 2, 6, 4, 5, 3}  ;

    kth_Largest_MaxHeap(arr, 3)  ;
    kth_Smallest_MinHeap(arr, 3)  ;
}
}

//================================================== Optimised ===========================

package Codes;

import java.util.*;

public class code {	
	

	public static int quickSelect( int arr[], int lo, int hi, int k) {
		
		int pivot = arr[hi];
		
		int pi = partition2(arr, lo, hi, pivot);
		
		if(k < pi) {
			return quickSelect(arr, lo, pi-1, k);
		}else if( k > pi) {
			return quickSelect(arr, pi+1, hi, k);
		}else {
			return arr[pi];
		}

	}
	
	//for kth largest
	public static int partition1( int arr[], int lo, int hi, int pivot) {
		
		int i= lo;
		int j = lo;
		
		while(i < arr.length) {
			
			if( arr[i] < pivot) {
				i++;
			}else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		
		return (j-1);
		
	}
	
	//for kth smallest
		public static int partition2( int arr[], int lo, int hi, int pivot) {
			
			int i= lo;
			int j = lo;
			
			while(i < arr.length) {
				
				if( arr[i] > pivot) {
					i++;
				}else {
					swap(arr, i, j);
					i++;
					j++;
				}
			}
			
			return (j-1);
			
		}
	
	
	
	public static void swap( int arr[], int i, int j) {
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
	}
	
	public static void main(String args[]) {
		
		int arr[]={12,3,5,7,4,19,26};

	    int n = arr.length, k = 1;
		System.out.println(quickSelect(arr, 0, n-1, k-1));
		
	}

}

