Target Sum Pair 1
1. You are given an array(arr) of distinct integers and a target.
2. You have to print all the pairs having their sum equal to the target.
Input Format
An Integer N 
arr1
arr2..
n integers
An integer target
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10000
-10^9<= arr[i] <= 10^9
Sample Input
12
9 
-48 
100 
43 
84 
74 
86 
34 
-37 
60 
-29 
44
160
Sample Output
60, 100
74, 86
  
Code:

package TimeAnsSpace;

import java.util.Scanner;
import java.util.Arrays;

public class TargetSumPair1 {

	public static void targetSumPair(int[] arr, int target) {

		//array ko sort karne keliye Arrays.Sort use karenge
		Arrays.sort(arr);
		
		int li= 0; // left index
		int ri = arr.length-1; // right index last mai rkha
		
		while( li < ri) { // jabtak left index less hai right index se tabtak kam karenge
			
			if( arr[li] + arr[ri] < target ) {
				li++;
			}else if( arr[li] + arr[ri] > target) {
				ri--;
			}else { //agar chota bhi nhi bda bhi matlab equal ho
				System.out.println(arr[li]+", "+arr[ri]);
				li++;
				ri--;
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int target = scn.nextInt();
		targetSumPair(arr, target);
	}

}


