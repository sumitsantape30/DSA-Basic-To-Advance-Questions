Max Of An Array
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the maximum of input. 
4. For the purpose complete the body of maxOfArray function. Don't change the signature.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing max

Constraints
1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^9
Sample Input
6
15
30
40
4
11
9
Sample Output
40

Code:

package Recursion;

import java.util.Scanner;

public class MaximumOfAnArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int maxOfArray(int arr[], int idx) {
		
		if( idx == arr.length-1) { //iske explanation keliye opne book
			return arr[idx];
		}
		
		int misa= maxOfArray(arr, idx+1); //max in smaller array, yeh faith hai ki yeh muje idx+1 se leke end mese sabko compare krke jo max hga woh laake dega
		//smaller array se jo max aya hai usko arr[idx] ke sath compare karenge
		if( misa > arr[idx]) {
			return misa;
		}else {
			return arr[idx];
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int max= maxOfArray(arr, 0);
		System.out.println(max);
	}

}
