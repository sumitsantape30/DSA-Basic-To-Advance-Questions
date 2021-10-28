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
		if( idx == arr.length) { //last index se aage nikal gya means arr.length-1 se aage nikal gya to yahase return hojao
			return;
		}
		
		System.out.println(arr[idx]); //idx wala hum print kar denge
		displayArray(arr, idx +1); //never use post increament (idx++) operator in recursive call, coz idx++ use kiya to idx ki purani value hi use hogi uss line mai
		
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		int n= arr.length;
		displayArray(arr,0); 


	}

}

Analysis
Time Complexity :
O(n)
Let"s try to understand our time complexity. Since we are making at most n recursion calls and in each call we are performing O(1) operations (printing a data is constant time) so our overall time complexity is n*O(1) = O(n).

SPACE COMPLEXITY :
O(n)
Also, we know for each recursion call the parameters, address of the array are stored in the runtime stack, and since the recursive call stack is of n length it will also take n space in the stack. Although we are not using any array the space complexity will be O(n).
