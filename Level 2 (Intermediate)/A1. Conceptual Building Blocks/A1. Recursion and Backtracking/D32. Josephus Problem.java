Josephus Problem

1. You are given two numbers N and K.
2. N represents the total number of soldiers standing in a circle having position marked from 0 to N-1.
3. A cruel king wants to execute them but in a different way.
4. He starts executing soldiers from 0th position and proceeds around the circle in clockwise direction.
5. In each step, k-1 soldiers are skipped and the k-th soldier is executed.
6. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed soldiers are removed), until only the last soldier remains, who is given freedom.
7. You have to find the position of that lucky soldier.

Note -> Check out the question video and write the recursive code as it is intended without  changing signature. The judge can't force you but intends you to teach a concept.
Input Format
2 numbers N and K
Output Format
Check the sample ouput and question video.

Constraints
1 <= N,K <= 200
Sample Input
4
2
Sample Output
0

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n, int k){ // hume return karna hai n logo mai k agar kill kiya jata hai to kon survive karega woh bande hai 0 to n-1
    //kth banda marega 0 1 2 3 4 aise k -1th banda mar jayega uske bad ka bache hue logoko solve krne hum bhej denge
   
    if( n == 1){ // agar 1 hi banda bache, 1 hi banda bache to woh 0th banda hota hai 
        return 0; // 1 hi banda hai to woh 0th banda mana jayega
    }
   
    int x =  solution(n-1, k); // n-1 mai kon survive karega yeh hum solution() dega, hume fath hai ki n-1 mai yeh bta dega ki kon survie karne wala hai
    //xth banda n-1 mai survie kar jayega, to n-1 ka jo xth banda hai woh nth mai kon banda hoga
    
    int y = (x + k) % n; // apke level wala
    
    return y; // apke level wala return karenge
   }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(solution(n,k));
  }
}
