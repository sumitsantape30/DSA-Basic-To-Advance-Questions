Display Array In Reverse
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the elements of array from end to beginning each in a separate line.
4. For the above purpose complete the body of displayArrReverse function. Don't change the signature.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
n1
n2
.. n elements

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 10
Sample Input
5
3
1
0
7
5
Sample Output
5
7
0
1
3

Code:
package Recursion;

import java.util.Scanner;

public class DisplayArrayInReverse {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void displayReverse( int arr[], int idx) {
		
		if( idx == arr.length) {
			return;
		}
		
		displayReverse(arr, idx+1); // faith yeh hai ki end se index+1 tak sab print kardega ab index wala reh gya to usko hum print karenge
		System.out.println(arr[idx]); //recursion call ke bad wali lines stack mai wapas aate waqt chalti hai
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		displayReverse(arr, 0);
		
	}

}
