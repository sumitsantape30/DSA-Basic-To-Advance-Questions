Buy And Sell Stocks - One Transaction Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output
17

Code:

package DP;

import java.util.Scanner;

public class bestTimeToBuyAndSellStocksOneTransactionAllowed {

	public static int bestTimeToBuyAndSell( int prices[]) {
		
		int lsf= Integer.MAX_VALUE; //least so far
		int op = 0; //overall profit
		int pist=0 ; // profit is sold today
		
		for( int i=0; i< prices.length; i++) {
			if( prices[i] < lsf) { // agar yeh lsf se chota hai to sabse pehle lsf ko update kardunga
				lsf= prices[i];
			} // lsf kyu maintain karke rakhna hai? coz kisi bhi din ka profitifsoldtoday sabse jada tab hota hai jab woh apne left pe least ke sath pair krta hai
			
			//agar aaj bechna mandatory hai to kitna profit hoga, aaj wale prices mese aap apnese pehle wale dino ke least se minus krdo to apko profit pta lag jayega
			 pist=  prices[i] - lsf;
			 
			 //har din ka pist nikalte rahenge jis din ka sabse jada rahega to woh humara overall profit hoga
			 if(pist > op) {
				 op = pist;
			 }
			
		}
		
		return op;
		
	}
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int prices[]= new int[n];
		
		for( int i=0; i< prices.length; i++) {
			prices[i]= s.nextInt();
		}
		
		System.out.println(bestTimeToBuyAndSell(prices));
		
	}

}
