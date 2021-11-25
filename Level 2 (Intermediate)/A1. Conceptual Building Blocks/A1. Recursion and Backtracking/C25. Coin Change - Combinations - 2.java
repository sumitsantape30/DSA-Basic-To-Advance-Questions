Coin Change - Combinations - 2

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (same coin can be used 
     again any number of times) using which the amount "amt" can be paid.

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
2-2-2-2-2-2-.
2-2-2-3-3-.
2-2-2-6-.
2-2-3-5-.
2-3-7-.
2-5-5-.
3-3-3-3-.
3-3-6-.
5-7-.
6-6-.

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if( i == coins.length){
            if( amtsf == tamt){
                System.out.println(asf + ".");
            }
            return;
        }
        
        //ha ki call, ki kitne bar coin ke le skte hai 
        //sample output mai jada wala pehle de rakha hai means 6 times 2 wala pehle de rakha hai, fir 3 times 2 wala  so on.
        for( int j = tamt / coins[i]; j >= 1; j--){ // j = will be kitni bar uss coin ko liya ja skta hai. tamt agar 10 hai aur coin apka 3 hai to 3 bar max le skte ho aap. 
           String part = "";
           for( int k = 0; k < j; k++){
               part += coins[i] + "-"; // jaise agar 2 3 times aa rha hai to isse 2-2-2 ban jayega
           }
            coinChange( i + 1, coins, amtsf + coins[i] * j, tamt, asf + part); // amount so far mai, yeh wala coin maine j bar liya hai so coins[i]*j. asf mai itni bar dash dash lagake usme add krna hoga. aur yaha 2*3= 6 aad kardiya. aur answer so far mai 2-2-2 wala part add kardiya
        }
        
        //  no wali call ki nhi lena coin ko
        coinChange(i + 1, coins, amtsf, tamt, asf); // amount so far mai koi change nhi ayega kyuki use hi nhi kiya
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}
