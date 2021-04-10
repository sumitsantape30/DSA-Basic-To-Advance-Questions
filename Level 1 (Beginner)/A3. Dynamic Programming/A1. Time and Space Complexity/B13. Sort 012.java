Sort 012

  1. You are given an array(arr) containing only 0's, 1's, and 2's.
2. You have to sort the given array in increasing order and in linear time.
Input Format
An Integer N 
arr1
arr2..
n integers
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10000
arr[i] = 0,1,2
Sample Input
10
1
0
2
2
1
0
2
1
0
2
Sample Output
Swapping index 1 and index 0
Swapping index 2 and index 9
Swapping index 2 and index 8
Swapping index 2 and index 1
Swapping index 3 and index 7
Swapping index 5 and index 2
Swapping index 6 and index 6
  
Code:

package TimeAnsSpace;

import java.util.Scanner;

public class Sort012 {

	public static void sort012(int[] arr) {

		//3 pointers banayenge, j and i 0 pe and k last pe
		int j=0; // 0 to j-1 --> 0s area
		int i=0;  // j to i-1 --> 1s area
		int k= arr.length-1; // k+1 to end --> 2s area
		
		// i to k is unknown
		// jabt tak kuch to unknown hai problem chalti rahegi
		while( i <= k) { //jab i k ko cross karega tabhi unknowns khatam honge
			
			if( arr[i] == 0) {
				// agar 0 mila to i and j ko swap kardenge
				swap(arr, i ,j);
				i++;
				j++;
			}else if(arr[i] == 1) { // 1 mila to kuch nhi bas i badha dete hai
				i++;
				
			}else if( arr[i] == 2) { // agar 2 mila to i and k ko swap krte hai aur sorf k ko ghatate hai, i ko badha nhi pate  coz i ko kya mila hume pta nhi hai 
				swap( arr, i ,k);
				k--;
				
			}
			
		}
		
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping index " + i + " and index " + j);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		sort012(arr);
		print(arr);
	}

}
