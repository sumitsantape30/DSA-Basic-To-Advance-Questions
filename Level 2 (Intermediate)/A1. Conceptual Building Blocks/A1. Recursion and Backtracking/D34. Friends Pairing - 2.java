Friends Pairing - 2

1. You are given an integer n, which represents n friends numbered from 1 to n.
2. Each one can remain single or can pair up with some other friend.
3. You have to print all the configurations in which friends can remain single or can be paired up.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
Output Format
Check the sample ouput and question video.

 Constraints
1 <= n <= 10
Sample Input
3
Sample Output
1.(1) (2) (3) 
2.(1) (2,3) 
3.(1,2) (3) 
4.(1,3) (2) 

Code:

import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1; // counter bhi print karna hai

  public static void solution(int i, int n, boolean[] used, String asf) {
    if( i > n){
        System.out.println(counter + "." + asf);
         counter++;
         return;
    }
 
    if ( used[i] == true) { // agar i pehlese used hai means iska faisla ho chuka hai to i ke pas koi option nhi hai aage call lagado
        solution(i + 1, n, used, asf); // iske pas koi option nhi hai aagle walo pe delicate krdo, aage walo se karwa lo merko tum pehlese kisike sath set karwake llaye ho 
    } else {

      //pehle bande ke pas option hai ya to mai akele aau, ya 2 ke sath aau, ya 3 ke sath aau

      used[i] = true;// akela aa rha hai to used hogya

      solution(i + 1, n, used, asf + "(" + i + ") "); // akela ayega to sirf i badhado, aur asf mai add krdo iss i ko
      //ab 1(i) ke rha hai 2 or 3 ke sath aa skta hu, apne ke bad walo ke sath hi aa skta hai. kyuki jab 2 ki bari ayegi to 21 nhi banne dena kyuki 12 ban chuka hoga already, 21 se permutation paida hojati hai
      for ( int j = i + 1; j <= n; j++) { // jin logoke sath mai aa skta hu woh mere bad ke hone chahiye
        // i pehle use ho chuka hai, i ke level pr to i use honahi hai, i ke level pr aaye hai to i use hogahi hoga yato pehlese used hoga yafir ab used hojayega
        //jab akele gye the tab maine i ko used kiya tha ab hum j kobhi used kardenge
        if( used[j] == false){
            used[j] = true;
            solution(i + 1, n, used, asf + "(" + i + "," + j + ") "); // kisike sath pair up karne ki call yeh hai
            used[j] = false; // wapas aate hue edgepost mai j ko uda do
        }
      }
      // aur node post mai bhi hata do
      used[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1]; // ek used ka array de rakha hai n+1 size ka, 3 elements hai to 4 size ka array diya hai to usme 0 1 2 3, 1 2 3 ko mai use karunga yeh mark karne keliye ki yeh banda used ho chuka hai nhi hua hai
    solution(1, n, used, ""); // level pe muje i pass kiya hai which is the first person
  }
}
