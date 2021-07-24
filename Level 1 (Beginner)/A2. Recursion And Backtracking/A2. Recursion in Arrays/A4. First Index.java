First Index
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the first index at which x occurs in array a.
5. If x exists in array, print the first index where it is found otherwise print -1.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
n1
n2
.. n number of elements
A number x
Output Format
A number representing first index of occurence of x in array a or -1 if not found at all.

Constraints
1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^ 3
0 <= x <= 10 ^ 3
Sample Input
6
15
11
40
4
4
9
4
Sample Output
3

Code:
 
package Recursion;

import java.util.Scanner;

public class FirstIndex {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int firstIndex( int arr[], int idx, int x) {
		
		if(idx == arr.length) {
			return -1; // agar call hote hote index ki value agar arr.length ke equal hojati hai to mko pta lag gya ki element exist ho nhi krta so -1 return kardunga
		}
		
		if( arr[idx] == x) {
			return idx;
		}else {
			int fiisa= firstIndex(arr, idx+1, x);
			return fiisa;
		}
		
//		int fiisa= firstIndex(arr, idx+1, x); //first index in small array
//		if( arr[idx]== x) {
//			return idx;
//		}else {
//			return fiisa;
//		} yeh bhi sahi hai but not good agar 0th index pehi data mil jaye to itni call karneki jaurrat nhi hai so pehlehi 0th index wale ke sath compare krlo agar same nhi hoga tabhi smaller array mai call karenge
		
	}

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= takeInput();
		int d= s.nextInt();
		int fi= firstIndex(arr, 0, d);
		System.out.println(fi);
		 
	}

}
