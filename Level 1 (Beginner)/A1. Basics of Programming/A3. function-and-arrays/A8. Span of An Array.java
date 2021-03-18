Span Of Array

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the span of input. Span is defined as difference of maximum value and minimum value.
  
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing max - min

Constraints
1 <= n <= 10^4
0 <= n1, n2
 .. n elements <= 10 ^9
Sample Input
6
15
30
40
4
11
9
Sample Output
36

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class spanOfAnArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void span( int arr[]) {
		
		int max= arr[0];
		int min= arr[0];
		for( int i=1; i< arr.length; i++) {
			
			if( arr[i] > max) {
				max= arr[i];
			}
			
			if( arr[i] < min) {
				min= arr[i];
			}
		}
	
		int span= max - min;
		System.out.println(span);
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		span(arr);
	}

}
