Climb Stairs With Minimum Moves

1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of 
     staircase.
Note -> If there is no path through the staircase print null.
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
4

Code:
 package DP;

import java.util.Scanner;

public class ClimbingStairswithMinimumMoves {
	
	//jB's method
	public static int climb_stairs_with_minimum_jump_Tabu(int[] arr) {
		int n = arr.length;
		int dp[] = new int[n]; // n size ka dp banega
		dp[n-1] = 0;  // destination se destination tak 1 way hota hai ki move hi na kro aur minimum number of steps 0 hote hai 
		
	    for(int i = arr.length - 2; i >= 0; i-- ) {
	    	int min = Integer.MAX_VALUE - 1; //hume min nikalna hai. manlo maximum jump4 ka allowed hai to agle 4 spots ka minimum nikalna hai  
	        for(int jump = 1; jump <= arr[i]; jump++ ) { // jump 1 se maximum kitna jump allowed hai yeh arr[idx] pe store hoga 
	        	if(i + jump < arr.length) { // yeh range mai hona chahiye
	        	   min = Math.min(min, dp[jump + i]); // min will be minimum abtak ka min aur dp[i+1] 
	            }
	        }
// 	        if(min == Integer.MAX_VALUE) {
// 	        	dp[i] = min;
// 	        } else {
	        	dp[i] = min + 1; //agle 4 spots ka minimum +1 yeh mere jawab hoga. ek jump hum bhi lagayenge uska +1 hai 
	        //}
	    }
	    return dp[0];
	}
/* manlo agar mai infinity-1 nhi krta, min ki value sirf infinity rakhta, aur manlo jump 0 ka allowed hota means arr[i] pe 0 rakha hota to jump wala loop to ek bar bhi nhi chalta, to dp[i] pe mai infinity+1 store karwa deta aur infinity+1 means -infinity hota hai so -infinity store kara deta jisse mera answer ajta galat */

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		
		int arr[]= new int[n]; //kaase kahatk ja skte ho woh wala array hume banaya

		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		// Capital Integer type ka array banayenge coz isme null yeh represent krte hai ki rasta nhi hai 
		Integer dp[]= new Integer[n+1]; // hume isme 0 se n stroe karna hai, 10 mila hai to 0 to 10 store karna hai so 0 to 10 keliye 11 size ka banan pdta hai
		dp[n]= 0;
		
		for( int i= n-1; i>= 0 ; i--) {
			if( arr[i] > 0) { // agar kisi jagah 0 hai means kahi nhi ja skte so null hi reh jayega so hum kam sirf tab karenge jab arr[i] greater than 0 hoga
				//agar arr[i] pr 3 pda hai to woh current i se i+1 i+2 i+3 pr ja skta hai to hum wahi loop chalaye
				
				int min= Integer.MAX_VALUE; //
				for( int j= 1; j<= arr[i] && i+j < dp.length; j++) {
					// muje ab yeh calculate karna hai ki dp[i] pr kya dale
					if( dp[i+j] != null) { // i+j jab null nhi hoga tabhi min le skte hai
						min = Math.min(min, dp[i+j]);
					}
				}
				
				if( min != Integer.MAX_VALUE) { //agar aisi koi jagah mili jahase rasta tha to hum update karenge
					dp[i]= min + 1;
				}
			}
		}
		
		System.out.println(dp[0]);
		
		//agar dp[0] pe null agya to wahi print karenge
		
	}

}
