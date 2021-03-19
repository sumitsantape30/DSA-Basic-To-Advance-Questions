Bar Chart

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print a bar chart representing value of arr a.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A bar chart of asteriks representing value of array a

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
			*		
			*		
			*	*	
			*	*	
*			*	*	
*			*	*	
*	*		*	*	

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class BarChart {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void printBars( int arr[]) {
		
		//humm sabse pehle max nikalenge coz utni hi floors se hum deal karenge
		int max= arr[0];
		for( int i=1; i< arr.length; i++) {
			if( arr[i] > max) {
				max= arr[i];
			}
		}
		
		//max floor se start karengeand first floor tak jayenge
		for( int floor= max; floor >= 1; floor--) {
			//ab har floor keliye har building ko analyse karenge
			for( int i=0; i< arr.length; i++) {
				//hum dekhenge kya yeh building iss floor se uchi hai ya iske barabr height ki hai agar hai to iss building mai iss floor pr bricks hongi
				if( arr[i] >= floor) {
					System.out.print("*\t");
				}else {
					System.out.print("\t");
				}
			}
			
			// ek floor ki saari building ko hum nap de to newline lagaye
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		printBars(arr);
	}
}
