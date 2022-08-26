Reverse A Number
1. You've to display the digits of a number in reverse.
2. Take as input "n", the number for which digits have to be display in reverse.
3. Print the digits of the number line-wise, but in reverse order.
Input Format
"n" where n is any integer.
Output Format
d1
d2
d3
... digits of the number in reverse

Constraints
1 <= n < 10^9
Sample Input
65784383
Sample Output
3
8
3
4
8
7
5

Code:

package GettingStarted;

import java.util.Scanner;

public class revserseOfANumber {
	
	public static void reverse( int n) {
		
		while( n >0) {
			int rev= n %10; 
			System.out.println(rev);
			n= n/10;
		}
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		
		int rev = 0;
		
		while( n > 0) {
			int r = n % 10;
			int q = n / 10;
			rev = rev*10 + r;
			n = q;
		}
		
		System.out.println(rev);
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		 int n= s.nextInt();
		 reverse(n);
	}

}
