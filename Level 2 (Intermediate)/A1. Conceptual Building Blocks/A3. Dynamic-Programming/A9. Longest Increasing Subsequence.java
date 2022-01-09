Longest Increasing Subsequence

1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest increasing subsequence of array.
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
6

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    
        int omax = 0; //overallmax, pure dp array mese max nikalne keliye
        int dp[] = new int[n]; 
      //  dp[0] = 1; //0th spot pe akela hi ayega woh number aur uski length 1 so 1 store kiye. yeh choti problem bahar nhi likhte coz niche woh max ke sath compare nhi hoga isliye andar hi karenge so loop 0 se start karenge
        
        for( int i = 0; i < dp.length; i++){ //1th spot se loop chalega
         //iss loop ke andar lets say mai i ki value  leke aya aur input mai arr[5]= 50 hai, means mai 4th spot ki dp[5] ki value solve karne keliye aya hu to mai isse pehle wale sare bando ko loop lagake visit karunga aur dekhunga 50 unse bada hai ya nhi, agar 50 unse bada hoga to mai unki spot(i = jo length hai dp array mai) value consider karunga aur unmese max dhundunga jo sabse bada hoga usko +1 karke current spot pe dal dunga 
         //lets say ab 41 pe solve ho rha hai to woh apnese pichle area mai sabko dekhega ki woh kiske piche lag skte hai, jinke piche lag skte ho unka max lo +1 
         
          int max = 0;
          
          for( int j=0; j < i; j++){ //i pe aane ki jarurat nhi hai usse pehle pehle tak lagayenge
              if( arr[j] < arr[i]){ //agar arr[j] arr[i] se choti hai tabhi iss value ko consider karna hai 
                if( dp[j] > max){ //fir dp[j] max se bada hai to max ko update krdo
                    max = dp[j];
                }
              }
          }
          
          //jab mai iss loop se bahar aaunga to mere pas max aachuka hoga
          dp[i] = max + 1;
          
          //jab mai har yeh dp calculate kr chuk hu to mai dp[i] ko overall max ke sath compare krleta hu 
          if( dp[i] > omax){
              omax = dp[i];
          }
        }
        
        System.out.println(omax);
  }
}
