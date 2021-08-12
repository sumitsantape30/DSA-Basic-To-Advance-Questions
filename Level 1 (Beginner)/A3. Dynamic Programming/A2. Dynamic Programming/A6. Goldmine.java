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

	public static int goldmine(int[][] a, int n, int m) {

		int dp[][] = new int[n][m];

		
		for (int j = m - 1; j >= 0; j--) { //hum solve krte waqt column by column piche ki taraf aa rhe so column ko bahar rakhenge aur khudko(j) ko sabse last mai rakhenge
			for (int i = 0; i < n; i++) { //aag iss column mai niche se upar ya upar se niche travel karo faraq nhi pdta
				if (j == a[0].length - 1) { //agar last column hai hai to dig nhi kr skta aage, jo arr[i][j] ai pda hoga wahi humara answer hojayega
					dp[i][j] = a[i][j];
					
				} else if (i == 0) { //agar first row mai hai to hum 2 jagah ja skte hai 
					
					dp[i][j] = a[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]); //apna gold collect kiya aur dono jagah ka max liya
					
				} else if (i == n - 1) { //agar last row hai , to last row mai banda 2 direction mai dig kr skta hai
					
					dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + a[i][j];
					
				} else { //rest of it, rest of the mai woh 3 jagah ja skta hai
					
					dp[i][j] = Math.max(Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]) + a[i][j];
				}
			}
		}
		
		//pure first column mai jo mera max hoga woh mera answer hoga
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (dp[i][0] > max) {
				max = dp[i][0];
			}
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
