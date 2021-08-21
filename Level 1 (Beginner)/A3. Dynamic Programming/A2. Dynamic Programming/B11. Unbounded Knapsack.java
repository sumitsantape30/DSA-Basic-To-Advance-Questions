Unbounded Knapsack

1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
    overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again 
                  and again.
Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap
Output Format
A number representing the maximum value that can be created in the bag without overflowing it's capacity
Question Video

  COMMENTConstraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
100

Code:

package DP;

import java.util.Scanner;

public class unboundedKnapsach {
	
	public static int unboundedKnapsach(int vals[], int wts[], int cap) {
		int n= vals.length;
		
		int dp[]= new int[cap+1]; // capacity se ek bana array banayenge, capacity 7 thi to 0 to 7 index lagega so 8 size ka banayenge
		dp[0]= 0; //0 kilo ki bag mai kuch nhi ho skta
		
		for( int bagc= 1; bagc <= cap; bagc++) { //cap or dp.length likh skte ho
			//ab hum sabhi items ko try karneki koshish karenge
			int max=0; //max rkhenge ek
			for( int i=0; i<n ; i++) {
				if( wts[i] <= bagc) { //agar weight bag capacity se kam hai to hum isko use kr skte bag mai
					
					int rbagc= bagc- wts[i];// remaining bag capacity
					int rbagv= dp[rbagc]; // reamining bag value
					int tbagv= rbagv + vals[i];// total bag value
					
					if( tbagv > max) { //agar yeh total bag value tumhare max ko beat krti hai to max ko update krlo
						max= tbagv;
					}
				} 
			}
			
			dp[bagc]= max; //dp of bagcapacity mai yeh max dal denge
			
		}
		
		return dp[cap]; //last index humara capacity hai so woh return kar denge
		
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int vals[]= new int[n];
		
		for(int i=0; i< vals.length; i++) {
			vals[i]= s.nextInt();
		}
		
		int wts[]= new int[n];
		
		for( int i=0; i< wts.length; i++) {
			wts[i]= s.nextInt();
		}
		
		int cap= s.nextInt();
		int ans= unboundedKnapsach(vals, wts, cap);
		System.out.println(ans);
		
	}
}
