Reverse An Array

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to reverse the contents of array a.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
0 <= n < 10^4
-10^9 <= a[i] <= 10^9

Sample Input
5
1
2
3
4
5
Sample Output
5 4 3 2 1

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class ReverseOfAnArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static int[] reverse( int arr[]) {
		
		int i= 0;
		int j= arr.length-1;
		
		while(i < j) {
			
			int temp= arr[i];
			arr[i]= arr[j];
			arr[j]= temp;
			i++;
			j--;
		}
		return arr;
	}
	
	public static void print( int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		reverse(arr);
		print(arr);
		
	}
}
