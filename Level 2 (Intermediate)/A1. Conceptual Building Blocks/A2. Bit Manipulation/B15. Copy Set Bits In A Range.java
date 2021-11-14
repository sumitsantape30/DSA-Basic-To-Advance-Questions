Copy Set Bits In A Range

1. You are given two numbers A and B.
2. You are given two more numbers left and right, representing a range [left,right].
3. You have to set bits in B which are set in A lying in the above mentioned range.
4. Print the updated number B.
Input Format
4 numbers representing A,B,left and right.
Output Format
A number

  COMMENTConstraints
-10^9 <= A,B <= 10^9
1 < left < right < 32
Sample Input
10
13
2
3
Sample Output
15

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

    int mask = 1; // mask ko pehle maine rakha 1
    mask = mask << (right - left +1); // right aur left mai jitna gap hai utnese shift kiya jayega mask ko
    mask = mask - 1; // mask mese 1 minus karlo
    
    //ab left-1 jitne 0s dalne hai
    mask = (mask << (left-1));
    
    mask = (mask & a); // to ab apke pas aagya upar sare 0s niche sare 0s aur bicheme range jitni hai utne a ke bits ab isko b ke sath OR karenge
    
    b = b | mask;
    
    System.out.println(b);
  
  }

}
