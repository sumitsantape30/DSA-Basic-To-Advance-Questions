Number Of Bsts

1. You are given a number n, representing the number of elements.
2. You are required to find the number of Binary Search Trees you can create using the elements.
Input Format
A number n
Output Format
A number representing the number of Binary Search Trees you can create using the elements.

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
    
    int dp[] = new int[n + 1]; // hum iss dp mai har index pe yeh store karenge ki utne node se kitne bst banegne woh store karne wale hai. means 1th index pe yeh store karenge ki 1 node se kitne bsts ban skte hai
    dp[0] = 1; //0 se ek bst ban skta hai
    dp[1] = 1; //1 se bhi ek bst ban skta hai
    
    for( int i = 2; i <= n ; i++){
        
        //ab hume btana hai i node se kitne bst ban skte hai 
        int l = 0; //left mai hai 0
        int r = i -1; //right mai hai i-1
        
        while( l <= i-1){ //jabtak left pe i-1 nhi hojate tabtak krte rahenge
          dp[i] += dp[l]*dp[r];
        
          l++;
          r--;
            
        }
    }
    System.out.println(dp[n]);
    
 }

}
