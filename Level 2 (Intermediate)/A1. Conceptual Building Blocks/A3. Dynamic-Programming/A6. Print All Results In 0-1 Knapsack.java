Print All Results In 0-1 Knapsack

1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
5. Also, you have to print the indices of items that should be selected to make maximum profit.
6. You have to print all such configurations.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
Check the sample output and question video.

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75
3 4 

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static class Pair { //row column aur pathsofar rakhunga, jo jo item select hote jayenge unko psf mai dalenge
    int i;
    int j;
    String psf;

    public Pair(int i, int j, String psf) {
      this.i = i;
      this.j = j;
      this.psf = psf;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] vals = new int[n];
    String str1 = br.readLine();
    for (int i = 0; i < n; i++) {
      vals[i] = Integer.parseInt(str1.split(" ")[i]);
    }

    int[] wts = new int[n];
    String str2 = br.readLine();
    for (int i = 0; i < n; i++) {
      wts[i] = Integer.parseInt(str2.split(" ")[i]);
    }

    int cap = Integer.parseInt(br.readLine());

    int dp[][] = new int[vals.length + 1][cap + 1];

    //dp ke first row aur first column mai 0 hi ayega so loop 1,1 se chalayenge
    for ( int i = 1; i < dp.length; i++) {
      for ( int j = 1; j < dp[0].length; j++) { //balls j se represent ho rhi hai
        dp[i][j] = dp[i - 1][j]; // iss spot pe aap humesha pichli team ke run dal skte hai ki tereko batting pe nhi bhej rhe hai to bakiki team(i-1) itne balls(j) mai kitne runs banati hai utne daldiye. btting kari hi nhi to balls bhi kam nhi kiya aur aur value bhi yaha add nhi ki

        //agar hum usko batting pe bhejna chahte hai
        //hum batting pe tabhi bhejte hai jab batting krke woh jada runs banwa de but yeh batting pe tabhi ja skta hai jab balls enough ho
        if ( j >= wts[i - 1]){ //yeh banda wts[i-1] itni balls khelta hai aur j is itni balls hai so
          if (dp[i - 1][j - wts[i - 1]] + vals[i - 1] > dp[i - 1][j]) { //res of the team ne rest of the balls par jitne run banaye  + jitne run isne banaye, agar yeh greater hai unn runs se jab yeh batting nhi krta usse to hum update krdenge
            dp[i][j] = dp[i - 1][j - wts[i - 1]] + vals[i - 1];
          }
        }
      }
    }

    int ans = dp[vals.length][cap]; //yeh answer agya isko print karenge
    System.out.println(ans);

    //yahase aage start hogi bfs.

    ArrayDeque<Pair> que = new ArrayDeque<>();
    que.add(new Pair(vals.length, cap, "")); // i, j, psf

    while (que.size() > 0) { //jabtak que khali nhi hojati tabtak kam chalega
      Pair rem = que.removeFirst();

      //ab iske neighbours dalenge
      if (rem.i == 0 || rem.j == 0) { //agar rem.i 0 hogya means woh first row mai agya hai ya first column mai aagya hai means yato team mai players nhi bache ya balls nhi bachi sari balls khali to apke pas jo answer aya hai woh final hai print kardo
        System.out.println(rem.psf);

      } else { //agar first row or column mai nhi hai to apke pas 2 options hai
        //2 values padi hai, ek piche jab aap batting nhi krte fir ek value hai jab aap batting nhi krte woh + apka khudki value. to apko dekhna hota hai mai jahape hu yeh value kiske help se bani hai. agar dono jagah same hai to donoko dalenge otherwise donose jo bada hai usko dal dete hai

        int exc = dp[rem.i - 1][rem.j];// exclude ki value jab isko nhi liya/isne batting nhi ki to bakiki team ko sari balls mili. batting nhi kari thi to balls kobhi substract nhi kiya aur iske runs bhi add nhi kiye

        if (rem.j >= wts[rem.i - 1]) { //batting karne keliye enough balls hone chahiye
          int inc = dp[rem.i - 1][rem.j - wts[rem.i - 1]] + vals[rem.i - 1]; //bakiki team (rem.i - 1) aur bachi hui balls. yeh banda wts[rem.i - 1] itni balls khelta hai aur include mai iske runs bhi add honge

          if ( dp[rem.i][rem.j] == inc) { //agar yeh include ke barabr hai to queue mai hum ek naya pair dalenge jo batayega ki yeh item include hua tha
            que.add( new Pair(rem.i - 1, rem.j - wts[rem.i - 1], (rem.i - 1) + " " + rem.psf)); //bakiki team ko bakiki balls milengi aur purane wale psf mai yeh wala index add hoga

          }
        }

        if ( dp[rem.i][rem.j] == exc) { //aur agar yeh include wale ke nhi exclude wale ke equal hai
          que.add( new Pair(rem.i - 1, rem.j, rem.psf)); //bakiki team puri balls milengi kyuki isne batting ki hi nhi aur fir psf mai bhi kuch add nhi hoga kyuki yeh exclude hua hai
        }

      }
    }
  }
}
