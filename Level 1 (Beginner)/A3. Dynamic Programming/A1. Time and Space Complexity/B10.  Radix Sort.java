Radix Sort

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using radix sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Output Format
Check the sample ouput and question video.

Constraints
1 <= N <= 10000
0 <= arr[i] <= 10^8
Sample Input
5
7 
2 
4 
1 
3
Sample Output
After sorting on 1 place -> 1 2 3 4 7 
1 2 3 4 7 

Code:
package TimeAnsSpace;

import java.util.Scanner;

public class RadixSort {

	public static void radixSort(int[] arr) {
		
		//radix sort chalaya kitni bar jaye? ones place keliye tens place keliye aisa kabtak chalaye? jabtak sabse bade number ki sari digit puri na hojaye so max nikalna padega
		int max= Integer.MIN_VALUE;
		for( int val: arr) {
			if( val > max) { //agar meri value max se badi hai to mai val ko update kar dunga
				max= val;
			}
		}
		
		int exp= 1; // exponent
		while( exp <= max){
			countSort(arr, exp);
			exp= exp * 10 ; // exponent * 10 kar denge
			// means pehle ones place keliye sort kardo fir tens place keliye fir hundered place keliye so an so jabtak exponent max se chota hai
		}

	}

	
	//hume comparison mai places ke basis pe use ho rhe hai, means woh actually mai digit de rhe hai apni unit place or tens place ki or hundreds place ki aur fir reorder hoti hai to actual values reorder hoti hai
	// so countSort ke andar jo frequency array banana hoga woh 0  to 9 hi vary kr skti hai so hum range 10 size ki rakh skte hai coz comparison keliye jo use ho rha woh digit hai
	// 0 to 9 vary kr rha hai to min humara humesha 0 hoga 
	// aur freuqency array ke andar arr[i] use nhi kr skte 
	// kisi bhi number ki digit kaise nikalte hai iske liye opeb book
	public static void countSort(int arr[], int exp) {

		int farr[] = new int[10];


		for (int i = 0; i < arr.length; i++) {
			farr[arr[i] / exp % 10]++; // agar hume 1000 place wali digit nikalni hai to yeh karenge
		}

		for (int i = 1; i < farr.length; i++) {
			farr[i] = farr[i] + farr[i - 1];
		} 
		
		int ans[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = farr[arr[i] / exp % 10]-1 ; 
			ans[pos]= arr[i];
			farr[arr[i] / exp % 10]--; 
		}

		for (int i = 0; i < ans.length; i++) {
			arr[i] = ans[i];
		}
		
		System.out.print("After sorting on " + exp + " place -> ");
		print(arr);
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		radixSort(arr);
		print(arr);
	}
}

Output:
5
12
234
7
9875
62
After sorting on 1 place -> 12 62 234 9875 7 
After sorting on 10 place -> 7 12 234 62 9875 
After sorting on 100 place -> 7 12 62 234 9875 
After sorting on 1000 place -> 7 12 62 234 9875 
7 12 62 234 9875 

