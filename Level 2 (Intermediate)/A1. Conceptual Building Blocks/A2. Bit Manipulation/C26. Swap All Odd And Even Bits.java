Swap All Odd And Even Bits

1. You are given a number n.
2. You have to swap all odd position bits with even position bits.
3. Every odd position bit is swapped with adjacent bit on left side.
4. Every even position bit is swapped with adjacent bit on right side.
5. Print the number formed after swapping.
Input Format
A number n
Output Format
Check the sample ouput and question video.

Constraints
1 <= n <= 10^9
Sample Input
10
Sample Output
5

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //integer keliye kr rhe hai isliye 8 times 5 dena hoga and 8 times A
    int om = 0x55555555; //odd walo ka mask
    int em = 0xAAAAAAAA;// even ka mask
    
    int odds = (n & om); //isse odds mil jayenge. isme odd wali bach jayegi aur even wali udd jayegi
    int evens = (n & em) ; // isme even wali bach jayegi aur odd wali bach jayegi
    
    odds <<= 1; // odds wale ko 1 se right shift kiya
    evens >>= 1; 
    
    //ab evens wali odds ban gyi aur odds wali evens ban gyi
    // ab odds aur evens ka OR lelo
    n = odds | evens;
    
    System.out.println(n);
    
  }

}
