Buy And Sell Stocks - K Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number k
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= k <= n / 2
Sample Input
6
9
6
7
6
3
8
1

Sample Output
5

Code:

package DP;

import java.util.Scanner;

public class BuyAndSellStocksKTransactionsAllowed {
	
	private static int ktransactionsAllowedOptimized(int n, int[] arr, int k) {
	    int dp[][] = new int[k + 1][n];
	    for (int t = 1 ; t <= k ; t++ ) {
	      int max = Integer.MIN_VALUE;
	      for (int d = 1 ; d < n ; d++ ) {

	        if ( dp[t - 1][d - 1] - arr[d - 1] > max ) {
	          max = dp[t - 1][d - 1] - arr[d - 1];
	        }

	        if ( max + arr[d] > dp[t][d - 1]) {
	          dp[t][d] =  max + arr[d];
	        } else {
	          dp[t][d] =  dp[t][d - 1];
	        }

	      }
	    }
	    return dp[k][n - 1];
	  }
	
	//T.C- > n.k.n -> o(n2k) hogi iski

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}

		int k= s.nextInt();
		
		System.out.println(ktransactionsAllowedOptimized(n, arr, k));
		
	}

}
