Minimum Score Of Triangulation

1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.
Input Format
A number N
a1
a2.. N integers
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
1
2
3
Sample Output
6

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static int minScoreTriangulation(int[] arr) {
    int[][] dp = new int[arr.length][arr.length];

    for ( int g = 0; g < dp.length; g++) { //gap asal mai hota hai ki start aur end mai kitne ki duri hai

      for ( int i = 0, j = g; j < dp[0].length; i++, j++) { //koi bhi diagonal humesha i=0 aur j=g se start krta hai, tabtak chalta hai jo j hai column sabke end mai khatam hote hai. first diagnoal ke upar 0 ka gap hota hai, second diagnoal ke upar 1 ka gap hota hai so on. 4 ka gap hai matlab pehle aur akhri wale mai 4 ka gap hai. sare diagonals apke aakhri column mai khatam hote hai

        //gap 0 or 1 hai to special case hai
        if ( g == 0) { //gap 0 matlab ek point hai, ek point ka triangle nhi banega
          dp[i][j] = 0;
        } else if ( g == 1) { //gap 1 matlab 2 point hai triagle nhi banega
          dp[i][j] = 0;
        } else if ( g == 2) { // start aur end mai 2 ka gap hai
          dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
        } else {
          int min = Integer.MAX_VALUE;
            //original array ki bat karun mai
          for ( int k = i + 1; k <= j - 1; k++) {
            int tri = arr[i] * arr[j] * arr[k];// immediate triangle jo apne kata hai
            int left = dp[i][k];//triangle ke left mai kya hai
            int right = dp[k][j]; //triagle ke right mai kya hai

            int total = tri + left + right;
            if ( total < min) { //jiski total ki value choti hogi woh jit jayega
              min = total;
            }
          }
          dp[i][j] = min;
        }
      }
    }
    return dp[0][dp[0].length-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i  < n; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(minScoreTriangulation(arr));
  }
}
