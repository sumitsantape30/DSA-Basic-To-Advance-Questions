Paint Fence

1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which the fences could be painted so that not more than two fences have same colors.
Question Video

  COMMENTConstraints
1 <= n <= 10
1 <= k <= 10
Sample Input
8
3
Sample Output
3672

Code:

import java.io.*;
import java.util.*;

public class Main {
	
    public static int pf( int n, int k) { // n ka answer chahiye jiske andar not more than two consecutive fences should be painted with the same color iska jawab chahiye hume
		if( n== 1) {
			return k;
		}
		
		if( n ==2) {
			return k*k;
		}
		
		
		//int ans= pf(n-1)*(k-1) + pf(n-2)*(k-1);// n-1 ka jawab mangwa liya, n-1 fences ko paint karne ke kitne tarike hai jiske andar not more than two consecutive fences should be painted with the same color. and jis color se painted hoga usko chodke k-1 option hogye humare pas
		//pehli call different color wale and second call same color wale
		
		int ans= (pf(n-1, k) + pf(n-2, k)) * (k-1);
		
		return ans;
	}

   public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int k = sc.nextInt();
         paint_fence(n, k);
         sc.close();
    }

	private static void paint_fence(int n, int k) {
		
//		rgb --> repeate me - (eg. r -> rr,g -> gg,b -> bb)
		long same = k * 1;
//		rgb --> choose different options except me (eg. r -> gb, g -> rb, b -> rg)
		long diff = k * (k - 1);
		long total = same + diff;
		
		for(int i = 3; i <= n; i++) {
		    same = diff * 1;
			diff = total * ( k - 1 );
			total = same + diff;
		}
		System.out.println(total);
	}
}

//========================================Jb====================================================================

package DP;

import java.util.Scanner;

public class paintFence {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int k= s.nextInt();
		
		int dp1[]= new int[n+1]; //hume aakhri index n chahiye so n+1 ka banaye: last two fences are painted with the same color
		int dp2[]= new int[n+1];// last two fences are painted with the different color
		
		dp2[1]= k;
		
		for( int i=2; i<= n; i++) {
			dp1[i] = dp2[i-1];
			dp2[i]= (dp1[i-1] + dp2[i-1]) * (k-1);
		}
		
		System.out.println(dp1[n] + dp2[n]); // n fence ka answer 
		
	}

}
