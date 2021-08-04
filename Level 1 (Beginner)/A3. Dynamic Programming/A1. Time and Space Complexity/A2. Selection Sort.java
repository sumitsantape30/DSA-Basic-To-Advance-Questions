Selection Sort

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using selection sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Output Format
Check the sample ouput and question video.

Constraints
1 <= N <= 10000
-10^9 <= arr[i] <= 10^9
Sample Input
5
7 
-2 
4 
1 
3
Sample Output
Comparing -2 and 7
Comparing 4 and -2
Comparing 1 and -2
Comparing 3 and -2
Swapping 7 and -2
Comparing 4 and 7
Comparing 1 and 4

Code:

package TimeAnsSpace;

import java.util.Scanner;

public class SelectionSort {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void selectionSort( int arr[]) {
		
		// n size ke array keliye n-1 iterations hoti hai
		for( int i= 0; i < arr.length-1; i++) {
			int mi= i; //mi:min Index. shuruwat mai min i pehi hota hai
			
			//j i ke aage se start hota hai and j end tak jata hai
			for( int j= i+1 ; j< arr.length; j++) {
				// ab j compare hoga minimum index ke sath
				if( isSmaller(arr, j, mi)) { // agar j minimum index se smaller hai to fir minimum index to j hua na
				mi= j;
				}
			}
			
			//ab hum settle karenge means i and mi ko swap karenge
			   swap(arr, i, mi); // i swap hojaye mi ke sath
		}
	}
	
	public static boolean isSmaller( int arr[], int i, int j) {
		//System.out.println("comparing "+arr[i]+ " and "+arr[j]);
		if( arr[i] < arr[j]) {
			return true;
		}
		return false;
	}
	
	public static void swap(int arr[], int i, int j) {
		//System.out.println("Swapping "+ arr[i] + " and "+ arr[j]);
		int temp= arr[i];
		arr[i]= arr[j];
		arr[j]= temp;
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		
	}

}
