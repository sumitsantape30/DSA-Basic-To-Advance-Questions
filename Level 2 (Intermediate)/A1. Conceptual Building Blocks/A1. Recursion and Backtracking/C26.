Coin Change - Permutations - 1

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the permutations of the n coins (non-duplicate) using which the amount "amt" can be paid.

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
5
2
3
5
6
7
12
Sample Output
2-3-7-.
2-7-3-.
3-2-7-.
3-7-2-.
5-7-.
7-2-3-.
7-3-2-.
7-5-.

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){ // used array is ki kis kisko use kar chuke ho, kon konse denomination ko aap use kr chuke ho
    
     if( amtsf > tamt){ // agar amount so far bada hojata hai total amount se to yaha koi fayda nhi hai
       return;
     }else if( amtsf == tamt){ // agar amout so far equal hojate hai total amount ke to asf print krke return hojao
       System.out.println(asf + ".");
       return;
     }
    
      //so pay karne keliye sare options hai mere pas
      for( int i = 0; i< coins.length; i++){
          // ab mai check karunga kisko use kar paoge: agar humne use pehle use nhi kiya hai to use karenge kyuki muje dublicates nhi chahiye
          if( used[i] == false){ // agar false pda hai to hum usko use kr skte hai aur fir aage keliye call lagado
            used[i] = true;
            coinChange( coins, amtsf + coins[i], tamt, asf + coins[i] + "-", used ); // amount so far badhega
            used[i] = false; // wapas aate hue undo means false krdo usko
          }
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
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}
