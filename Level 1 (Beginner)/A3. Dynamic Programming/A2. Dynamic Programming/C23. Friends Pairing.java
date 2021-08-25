Friends Pairing

1. You are given a number n, representing the number of friends.
2. Each friend can stay single or pair up with any of it's friends.
3. You are required to print the number of ways in which these friends can stay single or pair up.
E.g.
1 person can stay single or pair up in 1 way.
2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.
Input Format
A number n
Output Format
A number representing the number of ways in which n friends can stay single or pair up.

  COMMENTConstraints
0 <= n <= 20
Sample Input
4
Sample Output
10

Code:

package DP;

import java.util.Scanner;

public class FriendsPairing {
	
	public static int friendsPairing( int n) {
		
		int dp[]= new int[n+1];
		
		dp[0]= 0; //ek bhi banda nhi hai to 0 tarike
		dp[1]=1; // 1 banda hota to 1 tarika hai 
		dp[2]= 2 ;// 2 bande hote to 2 tarike hai, 1-2,12
		
		//3 se aage hum solve karenge
		for( int i=3; i<= n; i++) { // i < dp.length bhi kr skte ho
			dp[i]= dp[i-1] + (dp[i-2] * (i-1)) ; // humara pehle banda bola mai alag rahunga to bache n-1 unka count muje dp[n-1] mai milega. ab first banda bola mai pair up hounga woh n-1 tarike se pair up ho skta hai. usko pair up karna ke bad n-2 bache, n-2 log kitne tarike se single or pair up krte hai iska count dp[n-2] mai pda hua hai 
		}
		
		return dp[n];
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		System.out.println(friendsPairing(n));
	}

}
