Kernighans Algorithm

1. You are given a number n.
2. You have to count the number of set bits in the given number.
Input Format
A number n
Output Format
Number of set bits in n

Constraints
1 <= n <= 10^9
Sample Input
58
Sample Output
4

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int counter= 0;
    
    while( n != 0){ // jabtak yeh n 0 nhi hojata
        //iska pehle right most set bit mask nikalenge
        int rsbm = n & -n;
        n -= rsbm;
        
        //aur counter badha denge
        counter++;
    } // yeh bas unhi bits par jata hai jo on hai har bit pe jake check nhi krta so its a smartest way to calculate
    
    System.out.println(counter);
    
  }

}

//------------------------JB's--------------------------------------------

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int count=0;
    
    while( n!= 0){
        n ^= (n & ((~n) + 1));
        count++;
    }
    System.out.println(count);
  }

}
