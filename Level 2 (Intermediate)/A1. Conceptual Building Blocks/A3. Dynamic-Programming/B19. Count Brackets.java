Count Brackets

1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
Input Format
A number n
Output Format
A number representing the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets

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
    
    for( int i=2; i <= n; i++){
        //inside wale ghatate jayenge aur outside wale badhte jayenge
        int inside = i - 1; // inside usse kam hai to i keliye inside usse ek kam se start hoga
        int outside = 0 ; //aur outside 0 se start hoga
        
        while( inside >= 0){
            dp[i] += dp[inside]*dp[outside];
            
            //inside wala ghatate rahega aur outside wala badhate rahega
            inside--;
            outside++;
        }
    }
    System.out.println(dp[n]);

 }

}
