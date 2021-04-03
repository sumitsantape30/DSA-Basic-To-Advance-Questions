Insertion Sort

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using insertion sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Output Format
Check the sample output and question video.

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
Swapping 7 and -2
Comparing 4 and 7
Swapping 7 and 4
Comparing 4 and -2
Comparing 1 and 7
Swapping 7 and 1
Comparing 1 and 4
Swapping 4 and 1
Comparing 1 and -2
Comparing 3 and 7
Swapping 7 and 3
Comparing 3 and 4
Swapping 4 and 3
Comparing 3 and 1
-2
1
3
4
7
  
Code:

package TimeAnsSpace;

import java.util.Scanner;

public class InsertionSort {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for(int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void insertionSort( int arr[]) {
		
		//oth wala sorted manenge
		for( int i=1; i< arr.length; i++) {
			for( int j= i-1; j>=0; j--) {
				if( isGreater(arr, j, j+1)) {// j apne aage wale se bol rha hai ki agar mai terese bda hu to mere sath swap hoja
					swap(arr, j, j+1);
				}else { //aur agar mai terese chota hu to break hoja kyuki merese piche wale tumse chotehi honga
					break;
				}
			}
		}
	}
	
	public static boolean isGreater( int arr[], int i, int j) {
		//System.out.println("comparing "+arr[i]+ " and "+arr[j]);
		if( arr[i] > arr[j]) {
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
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		insertionSort(arr);
		print(arr);
	}
}

