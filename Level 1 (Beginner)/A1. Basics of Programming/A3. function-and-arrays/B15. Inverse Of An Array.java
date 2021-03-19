Inverse Of An Array

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to calculate the inverse of array a.

The only difference is the range of values is from 0 to n - 1, instead of 1 to n.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
0 <= n < 10^7
The only difference is the range of values is from 0 to n - 1, instead
of 1 to n
Sample Input
5
4
0
2
3
1
Sample Output
1
4
2
3
0

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class InverseOfArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i<arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] inverse( int arr[]) {
		
		//inverse array declare karenge
		int inv[]= new int[arr.length];
		
		for( int i=0; i< arr.length; i++) {
			int v= arr[i]; // ith index pe pdi hui value nikal li
			//ab inverse array mai vth position pr mai i dal dunga
			inv[v]= i;
			
		}
		
		return inv;
	}
	
	public static void print(int arr[]) {
		
		for( int ele: arr) {
			System.out.println(ele);
		}
	}

	public static void main(String[] args) {

	   int arr[]= takeInput();
	   int inverse[]= inverse(arr);
	   print(inverse);
	   
	}
}
