Paint House

1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
Input Format
A number n
n1red n1blue n1green
n2red n2blue n2green
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Question Video

  COMMENTConstraints
1 <= n <= 1000
0 <= n1red, n1blue, .. <= 1000
Sample Input
4
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8

Code:
package DP;

import java.util.Scanner;

public class paintHouse {
	
	public static long paintHouse( long arr[][]) {
		int n= arr.length;
		
		long dp[][]= new long[arr.length][3]; // 3 ki jagah arr[0].length bhi le skte hai
		
		dp[0][0]= arr[0][0];// first gharpe red color lagaya to 
		dp[0][1]= arr[0][1] ;// first gharpe blue color lagaya to
		dp[0][2]= arr[0][2]; //green lagaya to
		
		//ab hum 2nd gharse loop lagayenge aakhri ghar tak
		for( int i=1; i< arr.length; i++) {
			dp[i][0]= arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);// iss ith gharke andar agar red color lagana hai, iss gharka red wala color utha lo aur pichle gharke blue aur green mese jo minimum hoga 
			dp[i][1]= arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // ab 1 pe hai to pichle ghar ka 0 or 2 lena hoga
			dp[i][2]= arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); //iss ghar se 2th color le rhe ho ab pichle ghar ke 0 or 1 uthaiye aur unka minimum lo
		}
		
		//jo last wali row hai uska minimum answer hoga
		return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		
	}

	public static void main(String[] args) {
//long lenge coz constraints mai jada badi value de rakhi hai
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt(); // number of houses
		
		long arr[][]= new long[n][3]; // 3 colors hai so 3
		
		for( int i=0 ;i < arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		
		long ans= paintHouse(arr);
		System.out.println(ans);
		
		
	}

}
