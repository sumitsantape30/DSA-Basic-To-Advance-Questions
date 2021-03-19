Rotate An Array

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. Rotate the array a, k times to the right (for positive values of k), and to
the left for negative values of k.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
0 <= n < 10^4
-10^9 <= a[i], k <= 10^9
Sample Input
5
1
2
3
4
5
3
Sample Output
3 4 5 1 2
  
Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class RotateAnArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void reverse( int arr[], int i, int j) {
		//humm reverse pe dependent hai, i se leke j tak ka reverse karna hai
		int li= i; //left
		int ri= j;  //right
		
		while( li < ri) {
			int temp= arr[li];
			arr[li]= arr[ri];
			arr[ri]= temp;
			
			li++;
			ri--;
		}
	}
	
	public static void rotate( int arr[], int k) {
		
		k= k % arr.length;
		if( k < 0) {
			k= k + arr.length;
		}
		
		//part 1 ko reverse karenge 
		reverse(arr, 0, arr.length- k- 1);
		
		// part 2 ko reverse karenge
		reverse(arr, arr.length- k, arr.length-1);

		//all ko reverse karenge
		reverse(arr , 0, arr.length - 1);
	}
	
	public static void print( int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int arr[]= takeInput();
		int k= s.nextInt();
		rotate(arr, k);
		print(arr);
		
	}

}
