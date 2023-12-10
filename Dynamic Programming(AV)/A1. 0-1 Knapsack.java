package Practice;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class main {

	// recursive
	public static int knapsack(int wt[], int val[], int W, int n) {
		if (n == 0 || W == 0) {
			return 0;
		}

		if (wt[n - 1] <= W) {
			return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), knapsack(wt, val, W, n - 1));

		} else { // if( wt[n-1] > W) capacity ke bahar hai
			return knapsack(wt, val, W, n - 1);
		}
	}
	
	//memoization	
	
	public static int knapsackMemo( int wt[], int val[], int W, int n, int dp[][]) {
		
		if(n==0 || W == 0) {
			return 0;
		}
		
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		
		if( wt[n-1] <= W) {
			int res = Math.max(val[n-1]+ knapsackMemo(wt, val, W - wt[n-1], n-1, dp), knapsackMemo(wt, val, W, n-1, dp));
			dp[n][W] = res;
			return res;
		}else {
			int res=  knapsackMemo(wt, val, W, n-1, dp);
			dp[n][W] = res;
			return res;
		}
		
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int prices[] = new int[n];

		for (int i = 0; i < n; i++) {
			prices[i] = s.nextInt();
		}

		int wts[] = new int[n];

		for (int i = 0; i < n; i++) {
			wts[i] = s.nextInt();
		}

		int cap = s.nextInt();

		//recursive
		System.out.println(knapsack(wts, prices, cap, prices.length));
		
		//Memoization
	    int[][] dp = new int[102][1002]; //Constraints se maximum size de denge array ko aur usme -1 fill karenge
		for (int[] row : dp) {
		    Arrays.fill(row, -1);
		} //iss array ko static set krke bhi use kr skte ho
		
		System.out.println(knapsackMemo(wts, prices, cap, prices.length, dp));

	}
}
