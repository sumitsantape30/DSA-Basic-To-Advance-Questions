Partition Into Subsets

1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which these elements can be partitioned in k non-empty subsets.

  COMMENTConstraints
0 <= n <= 20
0 <= k <= n
Sample Input
4
3
Sample Output
6

Code:

package DP;

import java.util.Scanner;

public class partitionIntoSubsets {
	
	public static long partitionKSubset( int n, int k) {
		
		if( n ==0 || k == 0 || n < k) { //aisa hua to 0 tarike hai 
			return 0;
		}
		
		long dp[][]= new long[k+1][n+1]; // pehle teams then columns mai people
		
		//first row aur first column mai sab 0s hote hai so 1 se loop chalayenge
		for( int t=1; t<= k; t++) { // teams
			for( int p=1; p<= n; p++) {
				if( p < t) { // if number of people is less than number of teams
					dp[t][p]= 0;
				}else if( p == t) {
					dp[t][p]= 1;
				}else {
					// if number of people is grater than number of teams
					dp[t][p]= dp[t-1][p-1] + dp[t][p-1]*t;
				}
			}
		}
		
		return dp[k][n];
		
	}
	
	//recursive
	public static long partitionSubsetR(int n, int k) {
		if( n == k) {
			return 1;
		}
		
		if( k == 0) { // n < k ki jarurat nhi hai coz constraints mai already de rakha hai ki n>k
			return 0;
		}
		
		long ans= partitionSubsetR(n-1, k-1) + k*partitionSubsetR(n-1, k);
		
		return ans;
		
	}

	public static void main(String[] args) {

	    Scanner s= new Scanner(System.in);
	    int n= s.nextInt();
	    int k= s.nextInt();
		System.out.println(partitionKSubset(n,k));
	}

}
