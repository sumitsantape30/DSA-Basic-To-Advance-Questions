4 Key Keyboard

1. Imagine you have a special keyboard with the following keys - 
   Key 1 : Print 'X' on the screen.
   key 2 : Select screen.
   Key 3 : Copy selection to buffer.
   Key 4 : Print buffer on screen appending to what has already been printed.
2. You are given a number N, which represents the number of times the keyboard is pressed.
3. You have to find the maximum number of 'X' that can be produced by pressing the N number of keys.  

Constraints
1 <= N <= 100

Format
Input
A number N

Output
Check the sample output and question video.

Example
Sample Input
3

Sample Output
3

Code:

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {

		int dp[]= new int[n+1];

		//1 to 6 tak ka answer to muje pta hi hota hai
		for(int i = 1; i <= n; i++){
			if( i <= 6){ //yeh obervation kiya tha to directly fill krdete hai
				dp[i] = i; 
			}else{
				dp[i] = i ; //har case mai dp[i] pe i to rakh hi dunga
				for(int j = 1; j <= i - 3; j++){
					dp[i] = Math.max(dp[i], dp[j] + dp[j] * (i - j - 2)); //abtak jo value rakhi hui hai compared with 
				}
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
