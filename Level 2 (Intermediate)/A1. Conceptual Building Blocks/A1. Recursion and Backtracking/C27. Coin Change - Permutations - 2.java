Coin Change - Permutations - 2

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the permutations of the n coins (same coin can be used again any number of times) using which the amount "amt" can be paid.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
n1
n2
.. n number of elements
A number amt
Output Format
Check the sample output and question video

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= amt <= 50
Sample Input
3
2
3
5
7
Sample Output
2-2-3-.
2-3-2-.
2-5-.
3-2-2-.
5-2-.

Code:
import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        if( amtsf > tamt){ // aisa hua to aage call mat lagao yahise return hojao
          return;
        }else if( amtsf == tamt){ // agar amount so far equal hota hai total amount ke to hume answer mil gya to print kardo
          System.out.println(asf + ".");
          return;
        }
        
        //mere pas sare options hai mai sare coins ko use kr skta hu
        for( int i=0; i< coins.length; i++){
            coinChange( coins, amtsf + coins[i], tamt, asf + coins[i] + "-"); // amout so far will get incremented by coins[i]
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins, 0, amt, "");
    }
}
