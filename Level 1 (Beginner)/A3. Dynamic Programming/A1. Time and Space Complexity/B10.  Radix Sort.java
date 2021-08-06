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
		
		int max=0;
		for( int i=0; i< arr.length; i++) {
			max= Math.max(max,  arr[i]);
		}
		
		int counter=1;
		while( max !=0) { //jabtak max 0 nhi hojata max ko 10 se divide krte rho aur countSort ko call krte rho so jitne digit hai utni bar call lagegi
			max= max/10;
			countSort(arr, (int)Math.pow(10, counter)); //exponent pass kr rhe ki kiske basis pe sort kr rhe hai, 10's ke basis pe ya 100's ke basis pe ya 1000's ke basis pe
			counter++;
		} //jinte number of digits hai utni bar yeh loop chalega
		
/*		
		//radix sort chalaya kitni bar jaye? ones place keliye tens place keliye aisa kabtak chalaye? jabtak sabse bade number ki sari digit puri na hojaye so max nikalna padega
		//pehle max nikalna padega
		int max= Integer.MIN_VALUE; //max=0 le skte ho
		for( int i=0; i< arr.length; i++){
			max= Math.max(max, arr[i]);
		}
		
		int exp= 1; // exponent
		while( exp <= max){
			countSort(arr, exp);
			exp= exp * 10 ; // exponent * 10 kar denge
			// means pehle ones place keliye sort kardo fir tens place keliye fir hundered place keliye so an so jabtak exponent max se chota hai
		}
*/
		
	}

	
	//hume comparison mai places ke basis pe use ho rhe hai, means woh actually mai digit de rhe hai apni unit place or tens place ki or hundreds place ki aur fir reorder hoti hai to actual values reorder hoti hai
	// so countSort ke andar jo frequency array banana hoga woh 0  to 9 hi vary kr skti hai so hum range 10 size ki rakh skte hai coz comparison keliye jo use ho rha woh digit hai
	// 0 to 9 vary kr rha hai to min humara humesha 0 hoga 
	// aur freuqency array ke andar arr[i] use nhi kr skte 
	// kisi bhi number ki digit kaise nikalte hai iske liye open book
	public static void countSort(int arr[], int exp) { //exponent pass kr rhe ki kiske basis pe sort kr rhe hai, 10's ke basis pe ya 100's ke basis pe ya 1000's ke basis pe

		int farr[] = new int[10]; //10 size ka array banayenge cox ek digit ki range 0 to 9 hoti hai

		for (int i = 0; i < arr.length; i++) { //ab freqency array bharna hai
			farr[(arr[i] / exp) % 10]++; // frequency array mai jakar uss place ki frquency badha denge
		}

		for (int i = 1; i < farr.length; i++) { //frequency array ko prefixsum array mai convert karenge
			farr[i] = farr[i - 1] + farr[i] ;
		} 
		
		int ans[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = farr[arr[i] / exp % 10] ; 
			ans[pos-1]= arr[i];
			farr[arr[i] / exp % 10]--;  //fir agli bar keliye position update
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

