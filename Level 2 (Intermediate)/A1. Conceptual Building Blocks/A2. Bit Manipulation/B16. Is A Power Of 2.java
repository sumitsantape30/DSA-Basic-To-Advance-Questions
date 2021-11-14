Is A Power Of 2

1. You are given a number n.
2. You have to check whether it is a power of 2 or not.
Input Format
A number n
Output Format
true/false

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
1024
Sample Output
true

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int val = (n & (n-1));
    
    //agar val 0 aya to yes it was 2 ki power
    if( val == 0){
        System.out.println(true);
    }else{
        System.out.println(false);
    }
  }

}

/*
one correction it will give true even if the number is n = 0, which is not the power of 2
so, 
return (x && !(x&(x-1))); */
this will check for 0 and power of 2.
