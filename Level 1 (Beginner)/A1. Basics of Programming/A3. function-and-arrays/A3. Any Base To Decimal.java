Any Base To Decimal

1. You are given a number n.
2. You are given a base b. n is a number on base b.
3. You are required to convert the number n into its corresponding value in decimal number system.
  
Input Format
A number n
A base b
Output Format
A decimal number representing corresponding value of n in base b.
  
Constraints
0 <= d <= 1000000000
2 <= b <= 10
  
Sample Input
111001
2
Sample Output
57
  
Code:
package GettingStarted;

import java.util.Scanner;

public class AnyBaseToDecimal {
	
	public static int getValueIndecimal(int n, int b) {
		int rv= 0;
		int p=1;
		
		while( n >0 ) { //hume tabtak kam karna hai jabtak humara number 0 se bda hai
			
			int rem= n % 10; //aur hum 10 se divide krke digit nikalenge
			//aur 10 se divide krke chota karenge
			n= n /10;
						
			//and jo power hongi woh humare base ki hongi
			ans +=  rem* p;
			//humare base ki power hai to woh 20 se multiply hokar badhegi
			p= p * b;
			
		}
		return rv;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int b = scn.nextInt();
		int d = getValueIndecimal(n, b);
		System.out.println(d);
	}
}
