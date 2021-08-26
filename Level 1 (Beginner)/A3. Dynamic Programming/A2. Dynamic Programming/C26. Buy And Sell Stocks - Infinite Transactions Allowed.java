Buy And Sell Stocks - Infinite Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output
30

Code:

package DP;

import java.util.Scanner;

public class buyAndSellStocksInfiniteTransactionsAllowed {
	
	//approach 1
	public static int buyAndSellStocksInfiniteTransactionsAllowed1( int arr[]) {
		int profit=0;
		for( int i=0; i< arr.length-1; i++) {
			if( arr[i+1] > arr[i]) {
				profit += (arr[i+1] - arr[i]);
			}
		}
		return profit;
	}
	
	public static int buyAndSellStocksInfiniteTransactionsAllowed2( int arr[]) {
		
		int buy[]= new int[arr.length];
		int sell[]= new int[arr.length];
		
		buy[0]= -arr[0];
		sell[0]=0 ;
		
		for( int i=1; i< arr.length; i++) {
			buy[i]= Math.max(buy[i-1], sell[i-1] - arr[i]);
			sell[i]= Math.max(sell[i-1], buy[i-1] + arr[i]);
		}
		
		return sell[arr.length-1];
	}
	

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		System.out.println(buyAndSellStocksInfiniteTransactionsAllowed2(arr));
		
	}

}
