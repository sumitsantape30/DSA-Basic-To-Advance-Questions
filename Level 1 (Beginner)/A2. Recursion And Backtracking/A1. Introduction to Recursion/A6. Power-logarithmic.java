Power-logarithmic

1. You are given a number x.
2. You are given another number n.
3. You are required to calculate x raised to the power n. Don't change the signature of power function.

Note1 -> The previous version expects the call stack to be of n height. This function expects call function to be only log(n) high.

Note2 -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number x
A number n
Output Format
x raised to the power n

Constraints
1 <= x <= 10
0 <= n <= 9
Sample Input
2
5
Sample Output
32

Code:
package Recursion;

import java.util.Scanner;

public class logarithmicPower {

	public static int Power(int x, int n) {// yeh optimize solution hai isme boht kam calls lagegi
		
		if( n == 0) {
			return 1;
		}
		
		int xpnb2= Power(x, n/2); //yeh faith wali line hai iss faith pe x ki power n/2 milegi
		// agar yeh agya to x ki power n will be xpnb2 ko aapas mai 2 times multiply krde
		int xn= xpnb2* xpnb2;
		//yeh kaafi hai jab n even hai
		
		// but agar yeh odd hai to ek bar x se multiply karna padega
		if( x % n == 1) { 
			xn *= x;
		}
		return xn;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		int xn = Power(x, n);
		System.out.println(xn);
	}

}

