Number Of Ways Of Triangulation

1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.
Input Format
A number N
Output Format
A number representing number of ways of traingulating a N-sided polygon.

Constraints
1 <= N <= 15
Sample Input
5
Sample Output
5

Code:

import java.io.*;
import java.util.*;

public class Main {

    //so n vertices ka polygon hai to usko catalan of n-2 tarikese traingulate kr skte hai
    //hume n number of sides ke terms mai diya hai but usse koi faraq nhi pdega, pentagon mai 5 side hoti hai aur 5 vertices hoti hai so on
	public static int solution(int n){
        n = n - 2; // n ko 2 se isliye ghata diya kyuki traingulation of n is catalan of n-2
        
        int dp[] = new int[n+1];
        dp[0] =1;
        dp[1] = 1;
        
        for( int i=2; i<= n; i++){
            int l = i-1; //agar aap i ka catalan ni nikal rhe ho to left state kiya i-1 se
            int r = 0;
            
            while( l >= 0){ //jabtak left 0 nhi hojata
              dp[i] += dp[l]*dp[r];
              
              l--;
              r++;
            }
        }
        return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
