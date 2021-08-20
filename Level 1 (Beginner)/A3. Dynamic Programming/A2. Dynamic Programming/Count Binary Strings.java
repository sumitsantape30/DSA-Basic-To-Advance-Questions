Count Binary Strings
Easy  Prev   Next
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
Input Format
A number n
Output Format
A number representing the number of binary strings of length n with no consecutive 0's.
Question Video

  COMMENTConstraints
0 < n <= 45
Sample Input
6
Sample Output
21

Code:

package DP;

import java.util.Scanner;

public class CountBinaryStrings {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int dp1[]= new int[n+1]; // n+1 size ki banayenge coz aakhri index n hona chahiye, aur isme ending at 0 ka count store karenge
		int dp2[]= new int[n+1]; // ending at 1 ka count store karunga
		
		dp1[0]=1; // 1 length ka answer 1 hi hoga
		dp2[0]= 1; 
		
		for( int i=2; i< dp1.length; i++) {
			dp1[i] = dp2[i-1]; // ending at 0's pe, pehli wali string ka ending at 1's ka count
			dp2[i]= dp1[i-1] + dp2[i-1] ;// i length ki string, ending at 1 chahiye, i-1 length ki string 0 and 1 pebhi end ho skti hai so dono ke addition
			
		}
		
		System.out.println(dp1[n]+" "+dp2[n]);
		
	}

}
