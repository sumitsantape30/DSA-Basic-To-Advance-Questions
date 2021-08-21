Zero One Knapsack

1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
               again and again.
Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap
Output Format
A number representing the maximum value that can be created in the bag without overflowing it's capacity
Question Video

  COMMENTConstraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75

Code:

package DP;

import java.util.Scanner;

public class ZeroOneSnapsack {
	
	public static int knapsack(int prices[], int wts[], int cap) {
		
		int dp[][]= new int[prices.length][cap+1];
		
		//1,1 se fill karna start karenge coz baki jagah to 0 hi hai, first row and column mai 0 hai
		for( int i=1; i< dp.length; i++) {
			for(int j=1; j< dp[0].length; j++) {
				//sabse pehle maine na wali choice consider karli
				dp[i][j]= dp[i-1][j]; //merese pehle wala element isi capacity ke sath maxm profit kitna de rha h
				if(j- wts[i-1] >=0 ) { //ha wali choice iss condtn pehi de payenge, yeh range mai honi chahiye
					dp[i][j]= Math.max(dp[i][j], prices[i-1] + dp[i-1][j- wts[i-1]]); //agar woh ana chahta hai to current element ka price add kardo fir maine bola merese pehle wale elemens updated capacity ke sath max profit kitne banayega 
				}
				// no wali choice aap humeshahi consider kr skte ho isliye bina kuch dimag lagaye no wale ka answer store krwa do 
			}
		}
		return dp[dp.length-1][dp[0].length-1];
		
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int prices[]= new int[n];
		
		for( int i=0; i<n;i++) {
			prices[i]= s.nextInt();
		}
		
		int wts[]= new int[n];
		
		for( int i=0; i<n;i++) {
			wts[i]= s.nextInt();
		}
		
		int cap= s.nextInt();
		
		System.out.println(knapsack(prices, wts, cap));
		
	}

}
