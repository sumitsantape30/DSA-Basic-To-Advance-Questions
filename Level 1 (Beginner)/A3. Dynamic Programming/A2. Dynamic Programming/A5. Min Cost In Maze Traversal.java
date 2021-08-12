Min Cost In Maze Traversal

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
     right cell).
7. You are required to traverse through the matrix and print the cost of path which is least costly.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
The cost of least costly path.

Constraints
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
23

Code:

import java.io.*;
import java.util.*;

public class Main {
	
	//recursive : yeh TLE dega
	public static int minCost(int arr[][], int sr, int sc) {
		if( sr >= arr.length || sc >= arr[0].length) { //so yaha ek invalid spot se destination tak jane ki minimum cost puchi ja rhi hai 
			return Integer.MAX_VALUE; //kabhi pohoch hi nhi skte so mai bolung infinte cost deni padegi aapko
		}
		
		if( sr == arr.length-1 && sc == arr[0].length-1) { //jab aap destination pe ho
			//destination ke sport ke paise
			return arr[sc][sc];
		}
		
		int f1= minCost(arr, sr, sc+1); //horizontal: sr, sc+1 se destination tak jane ki minimum cost
		int f2= minCost(arr, sr+1, sc); //sr+1,sc se dest jane ki min cost
		int ans= Math.min(f1,  f2) + arr[sr][sc];
		
		return ans;
		
	}// boht sari repeated calls ho rhi hongi jiski wajah se TLE ayega
	
  //memoization
/* step1: kitne dimension ka storage array lena padega? yeh kaise decide karenge? jitne arguments vary kr rhe hai function call krte waqt arr,sr,sc. Jitne variable recursive call ke andar vary karenge utne dimension ka storage aapko chahiye hoga. jaise recursive call mai array same pass ho rha hai, row and column vary ho rha hai dono calls mai to 2 dimensional storage hume chahiye hoga
         so recursive call ke andar jitne variables vary kr rhe hai utne dimension ka storage array banayenge */
	
	public static int minCost(int arr[][], int sr, int sc, int dp[][]) {
		if( sr >= arr.length || sc >= arr[0].length) { 
			return Integer.MAX_VALUE; 
		}
		
		if( sr == arr.length-1 && sc == arr[0].length-1) { 
			return arr[sc][sc];
		}
		
		//step3. call lagane se pehle check karo ki pre calculated hai kya
		if( dp[sr][sc] != 0) {
			return dp[sr][sc];
		}
		
		int f1= minCost(arr, sr, sc+1, dp); 
		int f2= minCost(arr, sr+1, sc, dp); 
		int ans= Math.min(f1,  f2) + arr[sr][sc];
		
		dp[sr][sc]= ans; //step 2 return karne se pehle ans dp mai stor karwa diya
		return ans;
		
	}
	
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
         System.out.println(min_cost_in_maze_traversal(a, n, m));
         sc.close();  
	 }

	private static int min_cost_in_maze_traversal(int[][] a, int n, int m) {
		 
		int dp[][] = new int[n][m];
		
		for(int i = n-1; i >= 0; i--) {
			for(int j = m-1; j >= 0; j--) {
				if(i == n-1 && j == m-1) {
					dp[i][j] = a[i][j];
				} else if(j == m-1) {
					dp[i][j] = dp[i + 1][j] +a[i][j];
				} else if(i == n-1) {
					dp[i][j] = dp[i][j + 1] + a[i][j];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + a[i][j];
				}
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		return dp[0][0];
	}

}
