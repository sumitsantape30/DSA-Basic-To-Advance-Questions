Climb Stairs

1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
Input Format
A number n
Output Format
A number representing the number of ways to climb the stairs from 0 to top.

Constraints
0 <= n <= 20
Sample Input
4
Sample Output
7

Code:

package DP;

import java.util.Scanner;

public class ClimbingStairs {
	
	public static int countPaths( int n) {
		if( n == 0 ) { //0 se 0 tak jane ka 1 tarika hai 
			return 1;
		}else if( n < 0) {
			return 0; 
		}
		
		//System.out.println("Hello" +n);
		
		int f1 = countPaths(n-1); // muje yeh faith hai ki yeh muje n-1 se 0 ke numbr of paths laake dedegi
		int f2 = countPaths(n-2); //n-2 stairs climb karne ke tarike lake dega
		int f3 = countPaths(n-3);
		
		int cp = f1 + f2 + f3;
		
		return cp;
		
	}
	
	public static int countPathsM( int n, int qb[]) {
		if( n == 0 ) {
			return 1;
		}else if( n < 0) {
			return 0;
		}
		
		//2. ek basecase aur lagayenge
		if( qb[n] != 0) { //agar yeh question pehlese solved hai to usme value pdi hogi means non zero rahega so dubara solve na kare question bank sehi answer return krde
			return qb[n];
		}
		
		
		System.out.println("Hello" +n);
		
		int nm1 = countPathsM(n-1, qb); 
		int nm2 = countPathsM(n-2, qb);
		int nm3 = countPathsM(n-3, qb);
		
		int cp = nm1 + nm2 + nm3;
		
		//1. question hai n( n se number of path return karne hai) aur cp(count paths) humara answr hai)
		qb[n]= cp ;// so question bank of n mai maine question ke samne answer store kardiya
		
		return cp;
		
	}
	
	//Tabulation
	public static int countPathsTab( int n) { // isme recursion nhi lagate iteration se solve krte hai
		
		int dp[]= new int[n+1];
		
		dp[0]= 1 ; // hume pta hai 0 se 0 ke ek rasta hai
		for( int i=1; i <=n ; i++) {
			// jab i ==1 0r 2 hai to i-2 and i-2 negative hojate isliye usko handle kr rhe hai
			if( i == 1) {
				dp[i]= dp[i-1]; // i-2 aur i-3 bahar chale jayenge so nhi liye
			}else if( i == 2) {
				dp[i]= dp[i-1] + dp[i-2];
				
			}else if( i == 3) {
				dp[i]= dp[i-1] + dp[i-2] + dp[i-3] ; // i = i-1 se 0 kitne raste hai, i-2 and i-3 se 0 kitne raste hai
			}
		}
		return dp[n]; // last mai dp[n] return kardenge
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int cp1 = countPaths(n); //iss function se meri yeh expectations hai ki yeh n se 0 ke number of paths return kare
		int cp2 = countPathsM( n, new int[n+1]); //n+1 size ka array pass karenge
		System.out.println(cp2);
	}
}
