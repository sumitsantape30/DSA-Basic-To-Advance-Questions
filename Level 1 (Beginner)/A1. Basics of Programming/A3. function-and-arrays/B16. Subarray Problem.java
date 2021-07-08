Subarray Problem

1. You are given an array of size 'n' and n elements of the same array.
2. You are required to find and print all the subarrays of the given array. 
3. Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
[Tab separated elements of subarray]
..
All subarrays

Constraints
1 <= n <= 10
0 <= n1, n2
 .. n elements <= 10 ^9
Sample Input
3
10
20
30
Sample Output
10	
10	20	
10	20	30	
20	
20	30	
30	
  
Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class SubarrayProblem {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void subarray( int arr[]) {
		
		for( int i=0; i< arr.length; i++) { //yeh wala i starting point hai subarray ka
			for( int j= i; j< arr.length; j++) { //yeh end point, end point starting point se jada hi hoga isliye i ke badse start ho rha hai
				for( int k= i; k<= j; k++) { //fir subarray print karne keliye ek loop lagega so start se leke end tak humara k travel karega aur sabko print karne mai help karega
					System.out.print(arr[k]+"\t");
				}
				//jab ek subarray print hojaye to enter jarur lagaye agla subarray start karne se pehle
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		subarray(arr);
	}

}
