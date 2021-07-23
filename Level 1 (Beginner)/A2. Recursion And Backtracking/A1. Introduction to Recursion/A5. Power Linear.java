Power-linear
1. You are given a number x.
2. You are given another number n.
3. You are required to calculate x raised to the power n. Don't change the signature of power function .

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
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

public class PowerLinear {
	
	public static int powerLinear(int x, int n) {
		
		if(  == 0) {
			return 1;
		}
		
		int xnm1= powerLinear(x , n-1);
		int pow= xnm1 * x;
		return pow;
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int x= s.nextInt();
		int n= s.nextInt();
		int result= powerLinear(x,n);
		System.out.println(result);
	}
}
