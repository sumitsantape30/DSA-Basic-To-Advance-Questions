Maximum Sum Increasing Subsequence

1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
Input Format
A number n
.. n more elements
Output Format
A number representing the sum of elements of the increasing subsequence with maximum sum for the array.

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
255


Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];

    for ( int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int omax = Integer.MIN_VALUE; //dp array mai overall max nikalna hai, -ve numbers bhi ho skte hai so omax= 0 mat rakhna

    int dp[] = new int[n];

    for ( int i = 0; i < dp.length; i++) {
      Integer max = null;

      for (int j = 0; j < i; j++) {
        if ( arr[j] <= arr[i]) { //agar arr[j] arr[i] se chota hai tabhi increasing banega, tabhi consider hoga woh
         
          //yaha 2 case ho skti hai,
          if ( max == null) { //yato max null ho, max ko kisine abhitak update hi nhi kiya hai to max ke andar bina comparison ke dp[j] daldo
             max = dp[j];
             
          } else if ( dp[j] > max) { //agar ab koi number mila hai aur woh dp[j] bada hai humare max se to max ko update krde
            max = dp[j];
          }
        }
      }

      //yahape jab aaunga 2 bate ho skti hai
      if ( max == null) { //ki max null reh gya ho, max null rehne ka matlab hai ki koi bhi jo value thi usse choti koi value hai hi nhi to max null reh jayega
        dp[i] = arr[i];
      } else { //else koi max leke aaye ho to dp[i] ke andar 
        dp[i] = max + arr[i]; //pichli bar 1 add krte the isbar arr[i] add hoga kyuki hum pichese sum leke aaye usme humari value add hogi
      }
      
      //ab overall max
      if( dp[i] > omax){
          omax = dp[i];
      }

    }
    
    System.out.println(omax);

  }

}
