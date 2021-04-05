Partition An Array
1. You are given an array(arr) of integers and a pivot.
2. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side.
3. You have to achieve this in linear time.

Note -> For more information, watch question video.
Input Format
An Integer n 
arr1
arr2..
n integers
An integer pivot
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 100000
-10^9 <= arr[i] <= 10^9
-10^9 <= pivot <= 10^9
Sample Input
5
7 
-2 
4 
1 
3
3
Sample Output
Swapping -2 and 7
Swapping 1 and 7
Swapping 3 and 4
-2 1 3 7 4 

 Code:

package TimeAnsSpace;

import java.util.Scanner;

public class paritioningAnArray {
	
	public static void partition(int arr[], int pivot) {
		
		// 0 to j-1 choto ka area hai( <= pivot ) 
		// j to i-1 humesha bada log rahenge pivot se ( > pivot )
		//i to end unknowns rahenge
		int i=0;
		int j=0;
		
		while( i < arr.length) { //jabtak koi bhi unknown hai 
			if( arr[i] > pivot) { // agar pivot se bda hai to sirf i badhege
				i++;
			}else { // agar tum chote ho ya barabr ho
				//pehle to swap hoga aur uske bad dono badhenge
				swap(arr, i, j);
				i++;
				j++;
			}
		}
	}
	
	 // used for swapping ith and jth elements of array
	  public static void swap(int[] arr, int i, int j) {
	    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }
	  
	  public static void print(int[] arr) {
		    for (int i = 0; i < arr.length; i++) {
		      System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		  }

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i<arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		int pivot= s.nextInt();
		partition(arr, pivot);
		print(arr);
	}

}
