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
		// return Math.max(arr[idx], misa) // yeh bhi kr skte hai : inn dono mese jo bada hoga woh return hojayega
	}
	
	public static int mx(int arr[], int idx) {
		if( idx == arr.length) { //yahape koi element exist hi nhi krta to maximum hi nhi hoga so -infinity ko return kar denge coz wahi maximum hai waha. sabse bekar maximum return kara
			return Integer.MIN_VALUE; //max exist nhi krna aur -infinity same hi hota hai 
		}
		
		int misa= mx(arr, idx+1);
		
		return Math.max(arr[idx], misa);
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int max= maxOfArray(arr, 0);
		System.out.println(max);
	}

}

Analysis
Time Complexity :
The time complexity of the above solution is O(n). This is because we have iterated the array twice. Once while going into the recursion and the other time while coming out of it. So, n elements were visited twice: n+n= 2n, O(2n)=O(n).

SPACE COMPLEXITY :
The space complexity will be O(1) as we have not used any extra space. If we consider the recursion space, it will be O(n) i.e. the maximum height of the recursion stack.
So dear reader, did you get the solution? You would have, the important question is, did you enjoy it? You have to enjoy recursion to feel it completely and the word feel is really important when it comes to recursion. If you have any doubts, we suggest you revisit the article once more or you may watch the complete solution video for better understanding.
