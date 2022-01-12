Count Of Valleys And Mountains

1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
2. You are required to find the number of valleys and mountains you can create using strokes.
E.g.

countvalleys
Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).

Input Format
A number n
Output Format
A number representing the number of valleys and mountains you can create using strokes.

Constraints
0 <= n <= 15
Sample Input
4
Sample Output
14

Code:

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {

    Scanner s= new Scanner(System.in);
    int n = s.nextInt();
    
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for( int i = 2; i < dp.length; i++){
        //i keliye find kr rhe hai
        int inside = i -1;
        int outside = 0;

        while( inside >= 0){
            dp[i] += dp[outside]*dp[inside];
            
            inside--;
            outside++;
        }
    }
    System.out.println(dp[n]); 
 }

}
