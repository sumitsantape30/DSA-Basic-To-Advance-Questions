Print Value Of Rsb Mask

1. You are given a number n.
2. You have to print the right-most set bit mask.
Input Format
A number n
Output Format
A number

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
58
Sample Output
10

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int rsbm = n & -n ; // rightmost set bit mask 
    
    //hum isko binary print karna chahte hai
    System.out.println(Integer.toBinaryString(rsbm));
    
    //System.out.println(n & ((~n) + 1));
    
  }

}
