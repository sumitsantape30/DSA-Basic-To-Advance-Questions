Burst Balloons

1. You are given an array(arr) of length N which represents N number of balloons.
2. Each balloon is painted with a number on it.
3. You have to collect maximum coins by bursting all the balloons.
4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
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
12

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr) {
      int dp[][] = new int[arr.length][arr.length];
      
      //gap strategy use karunga
      for( int g = 0; g < dp.length; g++){
          for( int i=0, j = g; j < dp.length; i++, j++){
              //i se leke j tak ka area fodna hai
              int max = Integer.MIN_VALUE;
              for( int k=i; k<=j; k++){ //k i se start hoga aur j tak jayega
                int left= k==i ? 0 : dp[i][k - 1] ;// left wala area jo already fut chuka hai. agar k i ke equal hua to left part hoga 0 otherwise dp[i][k-1]
                int right = k == j ? 0: dp[k + 1][j];//right wala area jo already fut chuka hai. aur agar j k ke equal hua to right part hoga 0 otherwise dp[k + 1][j] hoga
               // int val = arr[i - 1] * arr[k] * arr[j + 1];//kth fodne ki value
               //but ho skta hai left or right wala special case
            //   int val = arr[k]; //isme pehle k daldo
               
            //   if( i > 0){ //agar i 0 nhi hai to value ke andar multiply krlo arr[i-1]
            //       val = arr[i-1] * val;
            //   }
               
            //   if( j != arr.length-1){ //agar j aakhri nhi hai 
            //       val = val * arr[j+1];
            //   }
                int val = (i == 0 ? 1: arr[i-1]) * arr[k] * (j == arr.length-1 ? 1 : arr[j+1]); // i agar 0 hai to 1 ajaye nhito i-1 ajaye. agar j akhri hai to right side mai kuch nhi hai
                
                int total = left + right + val;
                if( total > max){
                    max = total;
                }
              }
              //bahar aake dp[i][j]  pe yeh max dump kardenge
              dp[i][j] = max;
          }
      }
      //0th row ka top right corner return kardenge
      return dp[0][dp.length-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
