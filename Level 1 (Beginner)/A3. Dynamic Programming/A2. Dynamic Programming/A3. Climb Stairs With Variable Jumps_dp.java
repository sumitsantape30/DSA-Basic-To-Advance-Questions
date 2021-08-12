Climb Stairs With Variable Jumps
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
Input Format
A number n
.. n more elements
Output Format
A number representing the number of ways to climb the stairs from 0 to top.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 20
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
5

Code:

package DP;

import java.io.*;
import java.util.*;

public class ClimbingStairsWithVariableJumps {
	
	//memoization
	//current index se destination tak jane ke total number of ways kitne yeh nikal rhe hai
	public static int cs2M(int arr[], int idx, int dp[]) { //step 1 storage bana liye
		if( idx == arr.length) { 
			return 1;
		}
		
		if( idx > arr.length) { 
			return 0;
		}
		
		//step3 call lagane se pehle check karlo
		if( dp[idx] != 0) {
			return dp[idx];
		}
		
		int ans=0;
		for( int jump=1; jump <= arr[idx]; jump++) { 
			ans += cs2(arr, idx + jump, dp); 
		}
		
		//step 2. apna answerr return karne se pehle store karwao
		dp[idx]= ans;
		
		return ans;
	}
	//mai dp[idx] mai yeh store karwa rha hu ki ith index se destination tak jane ke total number of ways
	
		
	//recursive
	public static int cs2(int arr[], int idx) { //array milta hai aur aap konse index pe abhi ho yeh milta hai
		if( idx == arr.length) { //agar destination pe pohoch gye, to destination se destination tak 1 rasta exist krta hai and woh rasta hai kuch bhi mat karo
			return 1;
		}
		
		if( idx > arr.length) { //agar galtise destination ke age nikal gye, to wahase destination tak ek bhi rasta exist nhi karega
			return 0;
		}
		
		int ans=0;
		
		for( int jump=1; jump <= arr[idx]; jump++) { //1 se jump lagana start karoge to arr[idx] itne jumps lagaoge
			
			ans += cs2(arr, idx + jump); //maine mangwaya: aap iss index se destination tak pohochna tha to iske total number of ways lake do. current index
			
		}
		
		return ans;
	}
	
	//tabulation
	public static int sc2Tab( int arr[]) {
		int n= arr.length;
		int dp[]= new int[n+1];
		
        dp[n]= 1; // iska matlab hai n se n jane ka 1 rasta hai means chalo hi mat: destination se destination tak ek rasta hota hai
		
		for( int i= n-1; i>=0; i-- ) {
			// yeh solve karega, dp[i] pe yeh store karega ki i se n jane ke kitne rraste hai and arr[i] yeh contain krte hai ki i se kitni dur ja skte hai
			for( int jump=1; jump<= arr[i] && i+jump < dp.length; jump++) { //i + jump range mai hona chahiye
				dp[i] += dp[i+jump];
			}
		}
		
		return dp[0];
		
	}
	
	public static void main(String[] args) {


		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		
		int arr[]= new int[n]; //array declare kiya jisme muje lena hai ki kahase kaha kitne dur ja skte hai 
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		int dp[]= new int[n+1]; //memoization keliye array banaye
		// why ? 0 pe store hoga 0 se n jane ke raste. n pe n tak jane ke raste store hoga so 0 se n chahiye to n+1 size ka array banan pdta hai
		System.out.println(cs2(arr,0);
		
	}

}
