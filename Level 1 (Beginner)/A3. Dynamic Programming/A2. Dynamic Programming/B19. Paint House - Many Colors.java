Paint House - Many Colors

1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
Input Format
A number n
n1-0th n1-1st n1-2nd .. n1-kth
n2-0th n2-1st n2-2nd .. n2-kth
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Question Video

  COMMENTConstraints
1 <= n <= 1000
1 <= k <= 10
0 <= n1-0th, n1-1st, .. <= 1000
Sample Input
4 3
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8

Code:
package DP;

import java.util.Scanner;

public class paintHouseManyColors {
	
	// n3 approach hai yeh
	public static int paintHouseManyColors( int arr[][]) {
		int n= arr.length;
		int c= arr[0].length;
		
		int dp[][]= new int[n][c];
		
		for( int j=0; j< arr[0].length; j++) { //first row wahi rahega jaise ka waisa
			dp[0][j]= arr[0][j];
		}
		
		for( int i=1; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				// ab yaha i hai house number aur j hai color number
				//so ith ghar pr jth color lagana hai to usse pehle wale gharke upar jth ko chodkar koi bhi color ho skta hai
				int min= Integer.MAX_VALUE;
				
				//isse pehle wali row mai ghumenge to get minimum
				for( int k=0; k< dp[0].length; k++) {
					if( k != j) { //minimum lete waqt dhyan denge ki k!= j
						if( dp[i-1][k] < min) { //pichli row ke sare colors except j color itself agar woh chota hai min se to min ko update krlo
							min= dp[i-1][k];
						}
					}
				}
				
				// min aagya ab dp mai dalenge
				dp[i][j]= arr[i][j] + min;
			}
		}
		
		//aisa karne ke bad jo aakhri row ka min hoga woh humara answer hoga
		int min= Integer.MAX_VALUE;
		for( int k=0; k< arr[0].length; k++) { 
			if( dp[n -1][k] < min) {  //aakhri row isliye n-1
				min= dp[n -1][k];
			}
		}
		
		return min;
		
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt(); // number of houses
		int c= s.nextInt(); // number of colors
		
		int arr[][]= new int[n][c];
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		
		System.out.println(paintHouseManyColors(arr));
		
	}

}
