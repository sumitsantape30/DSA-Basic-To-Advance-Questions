Josephus Special

1. You are given an integer N which represents the total number of soldiers standing in a circle 
     having position marked from 1 to N.
2. A cruel king wants to execute them but in a different way.
3. He starts executing soldiers from 1st position and proceeds around the circle in clockwise 
     direction.
4. In each step, every second soldier is executed.
5. The elimination proceeds around the circle (which is becoming smaller and smaller as the 
     executed soldiers are removed), until only the last soldier remains, who is given freedom.
6. You have to find the position of that lucky soldier.
Input Format
A number N
Output Format
Check the sample ouput and question video.

  COMMENTConstraints
1 <= N <= 10^9
Sample Input
4
Sample Output
1

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static int powerof2(int n){ // basically iss function se hume 2^x (2 to the power x) mil rha hai
     int i = 1;
     while( i * 2 <= n){ // jabtak i ko 2 se multiply krte rhe aur woh n se chota or equal ata rhe to i ko aap 2 se multiply krdo
        i = i * 2;
     }

     return i;
   } // so yeh highest power 2 dedega

  public static int solution(int n){ // so hume chahiye highest power 2 jo n ke within ho
    int hp2 = powerof2(n);
    int l = n - hp2; // n = hp2 + l hota hai 
    return 2 * l + 1;
    
  }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));

  }
  
}

