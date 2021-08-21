Paint House - Many Colors

1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
Input Format
A number n
n1-0th n1-1st n1-2nd .. n1-kth
n2-0th n2-1st n2-2nd .. n2-kth
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Question Video

  COMMENTConstraints
1 <= n <= 1000
1 <= k <= 10
0 <= n1-0th, n1-1st, .. <= 1000
Sample Input
4 3
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		arr[i][j] = sc.nextInt();
        	}
        }
        paint_house_many_colors_optimal(n,m,arr);
        sc.close();
    }

private static void paint_house_many_colors_optimal(int n, int m, int[][] arr) {
		int dp[][] = new int[n][m];
		
		int least = Integer.MAX_VALUE;
		int sleast = Integer.MAX_VALUE;
		
		for(int j = 0; j < m; j++) {
			dp[0][j] = arr[0][j];
			
			if(arr[0][j] <= least) {
				sleast = least;
				least = arr[0][j];
			} else if(arr[0][j] <= sleast) {
				sleast = arr[0][j];
			}
		}
		
		for(int i = 1; i < dp.length; i++) {
			int nleast = Integer.MAX_VALUE;
			int nsleast = Integer.MAX_VALUE;
			for(int j = 0; j < dp[0].length; j++) {
				if(least == dp[i-1][j]) {
					dp[i][j] = sleast + arr[i][j];
				} else {
					dp[i][j] = least + arr[i][j];
				}
//				update least and sleast
				if(dp[i][j] <= nleast) {
					nsleast = nleast;
					nleast = dp[i][j];
				} else if(dp[i][j] <= nsleast) {
					nsleast = dp[i][j];
				}
			}
			least = nleast;
			sleast = nsleast;
		}
		System.out.println(least);
	}
}
