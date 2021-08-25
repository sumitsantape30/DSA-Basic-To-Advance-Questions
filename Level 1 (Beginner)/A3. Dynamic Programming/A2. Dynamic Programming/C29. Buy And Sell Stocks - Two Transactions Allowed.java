Buy And Sell Stocks - Two Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
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

public class BuyAndSellStocksTwoTransactionsAllowed {
	
	//Hint: single transaction ke 2 methods sikhe, left se min banate chalo ki aaj ke din bechenge. Ya fir right se max ki aaj ke din kharidenge. So inn dono method ka combination hai
	//dusri approch mai mai har ek point ko buying point man rha hu aur pehle approach mai selling point man rhe hai ki aaj ke din bechenge
	
	public static int buy_and_sell_2_transaction(int n, int arr[]) {
		int minsf = arr[0]; // min so far ko array ke 0th element se initialise kr diya
		int maxsf = arr[n-1]; 
		
		int dp1[] = new int[n];
		int dp2[] = new int[n];
		
		//dp1[i]: max profit by doing at most one transaction till ith index
		for(int i = 1; i < n; i++) { //left to right fill karenge isko 
			minsf = Math.min(minsf, arr[i]); //aatehi sabse pehle min ko update krlo
			dp1[i] = Math.max(dp1[i - 1], arr[i] - minsf); //fir dp mai dal denge: aaj agar humne isko bach diya to aajke pehle din kitna profit tha aur aaj kitna profit hota, max wala dal denge
		}
		
		// dp2[i] : max profit by doing at most one transaction from ith index to last index 
		//2nd last se start krdo
		for(int i = n-2; i >= 0; i--) { //right to left
			maxsf = Math.max(maxsf, arr[i]);
			dp2[i] = Math.max(dp2[i + 1], maxsf - arr[i]  ); // maxsf pe bechenge aur arr[i] pe means aaj kharidenge
		}
		
		int maxprofit = 0;
		for (int i = 0; i < n; i++) {
			maxprofit = Math.max(maxprofit, dp1[i] + dp2[i]);
		}
		
		return maxprofit;
	}
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		System.out.println(buy_and_sell_2_transaction(n, arr));
		
	}

}
