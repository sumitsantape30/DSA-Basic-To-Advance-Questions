Target Sum Subsets

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. Complete the body of printTargetSumSubsets function - without changing signature - to calculate and print all subsets of given elements, the contents of which sum to "tar". Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
Input Format
A number n
n1
n2
.. n number of elements
A number tar
Output Format
Comma separated elements of the subset, the contents of which add to "tar"
.. all such subsets, each in a single line (the elements of each subset should be comma separated)

  COMMENTConstraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50
Sample Input
5
10
20
30
40
50
60
Sample Output
10, 20, 30, .
10, 50, .
20, 40, .

Code:

package Restart;

import java.util.Scanner;
import java.util.ArrayList;

public class Problems {

	public static void main(String[] args) throws Exception {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< n; i++) {
			arr[i]= s.nextInt();
		}
		
		int tar= s.nextInt();
		printTargetSumSubsets(arr, 0, "", 0, tar);
	}

	// set is the subset
	// sos is sum of subset
	// tar is target
	public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
		if( ssf > tar){ // agar sum so far ki value target se badi hogyi to bas return kardo
			return;
		}
		
		if( idx == arr.length) { //jab woh index arr.length pe pahuch jayega, humare pas aur elements nhi bache for choices
			if(sos == tar) { //ab agar humara sum of subset target ke equal hua to jo set hai usme full stop lagake print kardenge
				System.out.println(set + ".");
			}	
		}

		// humare element ke pas hai 2 choices , woh set ka part ban skta hai aur nhi ban skta
		printTargetSumSubsets(arr, idx+1, set + arr[idx] + ", " , sos + arr[idx], tar);// agar woh set mai gya to sum of set badhega
		printTargetSumSubsets(arr, idx+1, set, sos , tar) ;// agar woh set mai nhi aya to sum of set wahi rahega

	}
	
	//asf : answer so far
	// ssf : sum so far
	public static void printTargetSumSubsets2(int[] arr, int idx, String asf, int ssf, int tar) {
		if( ssf > tar){ // agar sum so far ki value target se badi hogyi to bas return kardo
			return;
		}
		
		if( idx == arr.length) { 
			if(ssf == tar) {
				System.out.println(asf + ".");
			}	
		}
		printTargetSumSubsets(arr, idx+1, asf + arr[idx] + ", " , ssf + arr[idx], tar); //yes 
		printTargetSumSubsets(arr, idx+1, asf, ssf , tar) ; //no
	}
}

