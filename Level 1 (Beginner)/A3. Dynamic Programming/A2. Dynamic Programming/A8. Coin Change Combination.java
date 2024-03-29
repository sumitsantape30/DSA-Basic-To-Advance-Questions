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

//======================================================= SS's (Correct Solution===========================================
import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws Exception {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        
        int arr[]= new int[n];
        
        for( int i=0; i< arr.length; i++){
            arr[i] = s.nextInt();
        }
        int amt= s.nextInt();
        
        int dp[]= new int[amt+1];
        dp[0]= 1;
        
        for( int i=0; i< arr.length; i++){ // bahar humara coins ka loop chalega, ki pehle sari dp mai 2 se pay hoga fir 3,4...
          for( int j= arr[i]; j < dp.length; j++){ // agar coin 2 hai to 2 se aage loop lagayenge, agar coin 3 hai 3 se aage loop lagayenge
              dp[j] += dp[j - arr[i]];// hume yehe store karna hai ki j ko pay karne ke kitne tarike hai,d[j] mai store karenge  [j - arr[i]ko pay karne ke kitne tarike the]. muje j rs ki payment karni hai to maine arr[i] ki payment kardi, eg 6 rs ki payment karni thi to 2rs ki payment kardi aur bache 4 rs to uss dp array mai 4th index pe jake usko pay karne ki jo value hogi usko yaha dal denge
          }
          
//bahar coins ka loop lagane sehi combinations paida hui, humne pure mai pehle 2 ka effect liya fir 3 ka effect liya isse kisi bhi spot pe jo payment pdi hogi usme 3 humesha 2 ke bad hi ayega
        }
        
        System.out.println(dp[amt]);
    }
}

//=====================================================JB's (there's some error)===============================================

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

	private static int coin_change_combination_dp(int n, int[] demons, int amt) { //coin array ko denominations bhi bol skte ho
		
		int dp[] = new int[amt+1];
		dp[0] = 1; //dp[0] pe 1 dal diya coz 0 ko pay karne ka ek tarika hota hai, amt 0 can be paid in 1 way
		//0 ko pay karneka ek tarika hai ki kuch bhi mat do
		
		for(int i = 0; i < demons.length; i++) {  // ab mai ek ek coin select karunga aur uska effect pure dp mai dal dunga 
			int coin= demons[i]; //ek coin  nikala iska effect pure dp mai dalna hai 
			for(int j = coin; j < dp.length; j++) { // effect dalna kahase start karenge? agar coin 3 hai to 3 se, coin 5 hai to 5 se
				dp[j] += dp[j - coin]; //dp[j] ke existing value mai add karo dp[j-coin]
				//dp[j] mai store hoga ki j ko pay karne ke kitne tarike
			} // j-coin ki value always positive hi rahegi coz loop coin se start ho rha so alag se condition lagane ki jarurat nhi hai
		}
		return dp[amt];
	}
}
