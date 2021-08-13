Goldmine
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).

goldmine

6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
An integer representing Maximum gold available.
Question Video

  COMMENTConstraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
33

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
		 Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
       	 for(int j = 0; j < m; j++) {
       		 a[i][j] = sc.nextInt();
       	 }
        }
        System.out.println(goldmine(a, n, m));
        sc.close();  
	 }

	public static int goldmine(int[][] a) {

		int dp[][] = new int[arr.length][arr[0].length];

		// fir iss dp ko right to left fill karna hai column wise, pehle rightmost column fill hoga fir second right most..
		for (int j = arr[0].length - 1; j >= 0; j--) { //hum solve krte waqt column by column piche ki taraf aa rhe so column ko bahar rakhenge aur khudko(j) ko sabse last mai rakhenge
			for (int i = 0; i < arr.length; i++) { //aag iss column mai niche se upar ya upar se niche travel karo faraq nhi pdta
				if (j == a[0].length - 1) { //agar last column hai hai to dig nhi kr skta aage, jo arr[i][j] ai pda hoga wahi humara answer hojayega
					dp[i][j] = a[i][j];
					
				} else if (i == 0) { //agar first row mai hai to hum 2 jagah ja skte hai 
					
					dp[i][j] = a[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]); //khudka gold collect kiya aur dono jagah ka max liya
					
				} else if (i == arr.length - 1) { //agar last row hai , to last row mai banda 2 direction mai dig kr skta hai
					
					dp[i][j] = a[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]) ;
					
				} else { //rest of it, rest of the mai woh 3 jagah ja skta hai
					
					dp[i][j] = a[i][j] + Math.max(Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]) ;
				}
			}
		}
		
		//pure first column mai jo mera max hoga woh mera answer hoga
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (dp[i][0] > max) {
				max = dp[i][0];
			}
			//max= Math.max(ans, dp[i][0]);
		}
//		System.out.println(max);
//		for(int i = 0; i < n; i++) {
//		   for(int j = 0; j < m; j++) {
//			   System.out.print(dp[i][j] + " ");
//		   }
//		   System.out.println();
//	    }
		return max;
	}

}

//==================Recursive================================

package Restart;

import java.util.Scanner;
import java.util.ArrayList;

public class Code {

	//recursive: tle dega
	public static int goldMine( int arr[][], int sr, int sc) {
		if( sr <0 || sr >= arr.length) { //agar iss range mai nhi ho to wahase kuch bhu gold collect nhi kr paoge
			return Integer.MIN_VALUE;
			
		}
		
		if( sc == arr[0].length-1) { //agar source row badhte badhte last column pe pohoch jaye to waha jitna gold hoga usko return kardenge
			return arr[sr][sc];
		}
		
		//3 option hote hai humare pas right up, right, right down
		int f1= goldMine(arr, sr-1, sc+1); //right up
		int f2= goldMine(arr, sr, sc+1);
		int f3= goldMine(arr, sr+1, sc+1);
		
		int ans= arr[sr][sc] + Math.max(f1, Math.max(f2, f3)); //mere answer hoga inn teeno ka max aur khudki value
		return ans;
		
	}

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		
		int arr[][]= new int[n][m];
		
		for( int i=0 ;i< n; i++) {
			for( int j=0; j< m; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		
		//yaha multiple sources hai wih kahise bhi dig karna start kr skta hai, 
		int max=0; //max chahiye hum, so sabhi sources mese jo max hoga woh humara answer hoga
		for( int i=0; i< n; i++) {
			max= Math.max(max,  goldMine(arr, i, 0));
		}
		System.out.println(max);
		
	}
}
