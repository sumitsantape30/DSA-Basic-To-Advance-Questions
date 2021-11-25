Coin Change - Combinations - 1

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (non-duplicate) using 
     which the amount "amt" can be paid.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
n1
n2
.. n number of elements
A number amt
Output Format
Check the sample output and question video

  COMMENTConstraints
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
5-7-.

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        
        if( i == coins.length){ // i coins.length pe pahucha to apki sari choices ho chuki hai
            if( amtsf == tamt){ // agar amount so far total amount ke equal hua hai 
              System.out.println(asf + ".");
            }
            return;
        }
        
        // humare coin ke pas 2 options hai
        coinChange(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-"); // amount so far mai uss coin ko add krlo woh coin keh rha ki mai aaunga, aur answer so far mai bhi uss coin ko add krle. i+1 means next coin keliye call laga rhe current wale ko answer mai dalke
        coinChange(i + 1, coins, amtsf, tamt, asf); // woh bolrha mai payment mai nhi aaunga
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        
        coinChange(0, coins, 0, amt, ""); // 1st 0: ki pehle konse coin ki bari hai, 2nd 0: abhitak kitne payment ho chuka hai, amt is total amout kitna hai, "": answer so far
    }
}
