Coin Change Combination

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of combinations of the n coins using which the 
     amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of combinations and not permutations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
                  combination. You should treat them as 1 and not 3.
Input Format
A number n
n1
n2
.. n number of elements
A number amt
Output Format
A number representing the count of combinations of coins which can be used to pay the amount "amt"
Question Video

  COMMENTConstraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= amt <= 50
Sample Input
4
2
3
5
6
7
Sample Output
2

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coin[] = new int[n];
        for(int i = 0; i < n; i++) {
        	coin[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        
        System.out.println(coin_change_combination_dp(n, coin, amt));
        sc.close();
    }

	private static int coin_change_combination_dp(int n, int[] coin, int amt) {
		
		int dp[] = new int[amt+1];
		dp[0] = 1;
		for(int i = 0; i < coin.length; i++) {
			for(int j = coin[i]; j <= amt; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		return dp[amt];
	}
}
