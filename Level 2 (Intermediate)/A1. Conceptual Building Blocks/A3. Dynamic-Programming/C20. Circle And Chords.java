Circle And Chords

1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
Input Format
A number N
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
Sample Output
5

Code:

import java.io.*;
import java.util.*;

public class Main {

    //hume input mai jo n diya hai woh represent krta hai ki 2*n points on the circle hai to hume bas n ka catalan nikalna hai 
    //agar bolta ki number of points n hai aur bola ki kitne chords draw ho skte hai to apko n/2 karna pdta
    public static long NumberOfChords(int n){ // n represent krega ki 2n points hai to simply n ka catalan nikal le
    
      //muje long ka use karna hoga, int error dega
      long dp[] = new long[n + 1]; 
      
      //0 aur 1 ka catalan 1 hota hai 
      dp[0] = 1;
      dp[1] = 1;
      
      for( int i=2; i <= n; i++){
          //yeh indexe integer ke hi banao kyuki dp array ka size jada nhi hoga but uske andar jo vlue store karenge woh jada hogi thats why long liya waha
          int l = 0; //left
          int r = i - 1; // right
          
          while( l <= i -1){ //jabtak left <= i na hojaye
              dp[i] += dp[l]*dp[r];
              l++;
              r--;
          }
      }
        
        return dp[n];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
	}
}
