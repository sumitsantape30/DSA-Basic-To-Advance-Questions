Maximum Sum Non Adjacent Elements

1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing the maximum sum of a subsequence with no adjacent elements.
Question Video

  COMMENTConstraints
1 <= n <= 1000
-1000 <= n1, n2, .. n elements <= 1000
Sample Input
6
5
10
10
100
5
6
Sample Output
116

Code:

package DP;

import java.util.Scanner;

public class maximumSumNonAdjacentElements {
	
	public static int maximumSumNonAdjacentElements( int arr[]) {
		
		int inc= arr[0];
		int exc=0;
		
		for(int i= 1; i< arr.length; i++) {
			int ninc= exc + arr[i]; //new include paida hota hai old include pe 
			int nexc= Math.max(inc, exc); //puran incude and exclude ka jo max hoga woh rakh lenge
			
			 inc= ninc;
			 exc= nexc;
		}
		//last mai humara answer dono ka max hoga
		return Math.max(inc,  exc);
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		int ans= maximumSumNonAdjacentElements(arr);
		System.out.println(ans);
	}

}
