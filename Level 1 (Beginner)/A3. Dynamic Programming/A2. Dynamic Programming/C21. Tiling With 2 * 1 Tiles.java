Tiling With 2 * 1 Tiles

1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
Input Format
A number n
Output Format
A number representing the number of ways in which the number of ways floor can be tiled using tiles.
Question Video

  COMMENTConstraints
1 <= n <= 100
Sample Input
8
Sample Output
34

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
          Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();
           int []dp = new int[n+1];
           dp[1] = 1; // n==1 means 2*1 ka answer ek hi hota ki, usme ek hi tarika exist krta ki ek tile vertically place karado
           dp[2] = 2; // length 2 hoti to 2 tarika hote, 2 tiles ya to vertically rakhdo yafir dono bhi horizontally rakhdo
           
           for(int i = 3; i <= n; i++) {
        	   dp[i] = dp[i - 1] + dp[i - 2];
           }
           
           System.out.println(dp[n]);
           sc.close();
    }
}
