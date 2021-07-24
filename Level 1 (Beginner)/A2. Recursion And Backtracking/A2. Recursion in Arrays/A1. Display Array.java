Display Array

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the elements of array from beginning to end each in a separate line.
4. For the above purpose complete the body of displayArr function. Don't change the signature.

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
3
1
0
7
5

Code:

package Recursion;

import java.util.Scanner;

public class DisplayArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0;i< n; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	// expectation yeh hai ki yeh idx se end tak sab print karde
	// and faith yeh hai ki idx+1 se end tak print karna woh janta hai
	public static void displayArray(int arr[], int idx) { // agr input mai muje array mila to kam nhi hoga, sirf array se mai problem ko chota nhi kr pa rha so muje index bhi chahiye taki mai choti problem achieve kr saku
		if( idx == arr.length) {
			return;
		}
		
		System.out.println(arr[idx]); //idx wala hum print kar denge
		displayArray(arr, idx +1);
		
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		int n= arr.length;
		displayArray(arr,0); 


	}

}
