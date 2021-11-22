Flip Bits To Convert A To B

1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
Input Format
2 numbers A and B
Output Format
A number

  COMMENTConstraints
-10^9 <= A,B <= 10^9
Sample Input
57
76
Sample Output
5

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
     Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();

    int flipped = a ^ b ; // flipped is kitni bits flipped hai 
    
    //ab bits count karlo, karninghan algo for counting bits
    int count= 0;
    while( flipped != 0){ // jabtak flipped 0 ke barabr nhi hojata tabtak hum 
       int rsb = (flipped & -flipped) ; // right most set bit
       flipped -= rsb; // right most set bit ko flipped mese minus karliya
       count++; // aur count ko badha diya kyuki ek bit count hogyi hai 
    }
    System.out.println(count);
  }

}
