Bubble Sort

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using bubble sort.
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
Swapping -2 and 7
Comparing 4 and 7
Swapping 4 and 7
Comparing 1 and 7
Swapping 1 and 7
Comparing 3 and 7
Swapping 3 and 7
Comparing 4 and -2
Comparing 1 and 4
Swapping 1 and 4
Comparing 3 and 4
Swapping 3 and 4
Comparing 1 and -2
Comparing 3 and 1
Comparing 1 and -2
-2
1
3
4
7

Code:

package TimeAnsSpace;

import java.util.Scanner;

public class bubbleSort {
	
	public static void bubbleSort(int arr[]) {
		
		// n- 1 iterations hoti hai
		for( int itr=1; itr<= arr.length-1; itr++) {
			// first iteration mai hum last tak comparison krte hai, agli iterrations mai thoda thoda pehle rukne lag jate hai jaise 2nd iteration mai last element chhodke end tak comparison kiye
			// so jitni iterations hui utne pehle banda rukne lagta hai
			for( int j=0; j< arr.length- itr; j++) {
				if( isSmaller(arr, j+1, j)) { // jab hum j pe hai to j+1 bolrha hai kya mai terese chota hu kya
					// agar j+1 chota hai j se to swap hojayega
					 swap(arr, j+1, j); //j+1 bola agar mai tumse chota hu to tumhare sath swap hounga
				}
			}
		}
	}
	
// 	public static void bubble( int arr[]) {
// 	   int n= arr.length;
	   
// 	   for( int itr= 1; itr <= n-1; itr++) {
		   
// 		   for( int i=0; i<= n- itr- 1; i++) {
// 			   if( isSmaller(arr, i+1, i) == true) {
// 				   swap(arr, i+1, i);
// 			   }
// 		   }
// 	   } 
//    }
	  // return true if ith element is smaller than jth element
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
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		bubbleSort(arr);
		print(arr);
	}

}
