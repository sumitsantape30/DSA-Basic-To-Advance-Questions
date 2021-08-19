Coin Change Permutations

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of permutations of the n coins using which the 
     amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of permutations and not combinations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
                  combination. You should treat them as 3 and not 1.
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
1 <= n <= 20
0 <= n1, n2, .. n elements <= 20
0 <= amt <= 30
Sample Input
4
2
3
5
6
7
Sample Output
5

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

	public static int coin_change_combination_dp(int n, int[] denoms, int amt) { //denoms: denomination
		
		int dp[] = new int[amt+1];
		dp[0] = 1; // 0 ko pay karneka 1 tarik
		//ab har ek spot ke upar sare coins ka effect dalna hai 
		for(int i = 0; i < dp.length; i++) { //outer loop chalega dp array ke upar 
			for(int j = 0; j < denoms.length; j++) { //aur innner loop chalega coins ke upar
				int coin= denoms[j] ;//coint nilalenge
				if( i - coin >=0){
					dp[i] += dp[i - coin];
				}
			}
		}
		return dp[dp.length]; //last mai aakhri index pe rakhi value ko return krdenge
		//return dp[amt];
	}
}

