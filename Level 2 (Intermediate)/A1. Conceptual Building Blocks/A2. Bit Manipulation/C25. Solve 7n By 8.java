Solve 7n By 8

1. You are given a number n.
2. You have to calculate the value of 7n/8 without using division and multiplication.
Input Format
A number n
Output Format
Check the sample ouput and question video.

Constraints
1 <= n <= 10^9
Sample Input
15
Sample Output
13

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int val = (((n << 3) - n) >> 3);
    System.out.println(val);
  }

}
