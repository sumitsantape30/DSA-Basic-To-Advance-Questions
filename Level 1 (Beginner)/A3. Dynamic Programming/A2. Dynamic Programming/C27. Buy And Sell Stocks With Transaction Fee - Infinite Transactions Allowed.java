Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number fee
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with transaction fee.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= fee <= 5
Sample Input
12
10
15
17
20
16
18
22
20
22
20
23
25
3
Sample Output
13

Code:

package DP;

import java.util.Scanner;

public class BuyAndSellStocksWithTransactionFeeInfiniteTransactionsAllowed {

	public static int buyAndSellStocksInfiniteTransactionsAllowed2(int arr[], int fee) {

		int buy[] = new int[arr.length];
		int sell[] = new int[arr.length];

		buy[0] = -arr[0];
		sell[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 1] - arr[i]); //first option: aaj nhi kharidna chahte bought state mai hi rehna chahte hai. Dusra option aaj khardite hai 
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + arr[i] - fee);
		}

		return sell[arr.length - 1];
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		int fee= s.nextInt();
		System.out.println(buyAndSellStocksInfiniteTransactionsAllowed2(arr, fee));
	}

}
