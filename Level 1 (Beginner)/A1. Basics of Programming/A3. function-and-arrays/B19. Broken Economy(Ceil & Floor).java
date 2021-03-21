Broken Economy

In a country of novice government, the economic system is changed where only coins are used that too of various denominations. Whenever a foreigner visits this country, they visit a money exchanger to get the currency of the same country. As the foreigner is unaware of the denomination of the country, the money exchange prefers to tell them the denomination which is the nearest maximum and nearest minimum to the denomination mentioned by the foreigner. In case they get the correct guess of the denomination, they are told the same denomination. The denominations are always quoted in ascending order.

Example 1: In a country, 8 given denominations are as follows
[5, 10, 15, 22, 33, 40, 42, 55]

The foreigner asks for denomination 25.
The money exchange tells them that denominations of 33 and 22 are available.

Example 2: 
In a country, 5 given denominations are as follows
[7, 14, 18, 25, 30]

The foreigner asks for the denomination of 18.

The money exchange tells them a denomination of 18 is available.  

You are required to print the values told by the money exchange to the foreigner.

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of the array a.
3. You are given another number d.
4. You are required to find the ceil and floor of d in array a.
Input Format
A number n
n1
n2
.. n number of elements
A number d
Output Format
A number representing ceil
A number representing floor

Constraints
1 <= n <= 1000
-10^9 <= n1, n2, .. n elements <= 10^9
-10^9 <= d <= 10^9
Sample Input
10
1
5
10
15
22
33
40
42
55
66
34
Sample Output
40
33

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class floorAndCeil {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void ceilAndFloor( int arr[], int ele) {
		
		int start=0;
		int end= arr.length-1;
		int ceil=0;
		int floor= 0;
		
		while( start <= end) {
			
			int mid= start + ((end - start)/2);
			
			if( arr[mid] < ele) { //start move hota hai to floor set hota hai
				floor= arr[mid];
				start= mid+1;
			}else if( arr[mid] > ele) { //end move hota hai to ceil set hota hai
				ceil= arr[mid];
				end= mid-1;
			}else { //agar ele barabr hai mid ke to ceil and floor dono wahi rahega and chize mil gyi to break jarur kare
				ceil= arr[mid];
				floor= arr[mid];
				break;
			}
		}
		System.out.println(ceil);
		System.out.println(floor);
	}
	

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int arr[]= takeInput();
		int n= s.nextInt();
		ceilAndFloor(arr, n);
		
	}

}
