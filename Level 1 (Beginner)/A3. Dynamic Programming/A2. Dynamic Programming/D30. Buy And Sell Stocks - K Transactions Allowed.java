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
	
	//T.C- > n.k.n -> o(n2k) hogi pichle approach ki yeh dono optimized hai
	
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
	
	public static int ktransactionsAllowedOptimized( int n, int arr[], int k) {
		
		int dp[][]= new int[k+1][n];
		
		//pehle row aur column mai 0 hi rahega siliye 1 se loop chalayenge
		for( int i=1; i< dp.length; i++) {
			int max= dp[i-1][0] - arr[0];//next loop se pehle max nam ka variable maintain karege
			for( int j=1; j< dp[0].length; j++) {
				dp[i][j]= Math.max(dp[i][j-1], max + arr[j]); //pehle factor dp[i][j-1] aur dusra factor max+ arr[i] hota hai
				max= Math.max(max, dp[i-1][j] - arr[j]);
			}
		}
		
		//dp of bottom left corner answer rahega
		return dp[dp.length-1][dp[0].length-1];
		
	}

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
