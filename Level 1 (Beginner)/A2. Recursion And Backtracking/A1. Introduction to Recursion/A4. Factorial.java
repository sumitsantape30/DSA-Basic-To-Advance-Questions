Factorial

1. You are given a number n.
2. You are required to calculate the factorial of the number. Don't change the signature of factorial function.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
Output Format
factorial of n


Constraints
0 <= n <= 10
Sample Input
5

Sample Output
120

Code:

package Recursion;

import java.util.Scanner;

public class Factorial {
	
	public static int factorial(int n) {
		
		if( n == 0 || n== 1) {
			return 1;
		}
		
		int fnm1= factorial(n-1); // yeh meri faith wali line hai, ki n-1 se 1 tak ki mutliplication muje iss line se mil jayegi fnm1 ke andar. (fn1m : factorial of n minus m)
		// aur muje banana hai fcatorial of n
		int fn= n * fnm1; //n* factorial of n minus 1
		return fn; // mere pura answer isme agya hoga
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int result = factorial(n);
		System.out.println(result);
	}

}
