Print Fibonacci Numbers Till N

1. You've to print first n fibonacci numbers.
2. Take as input "n", the count of fibonacci numbers to print.
3. Print first n fibonacci numbers.
Input Format
n
Output Format
0
1
1
2
3
5
8
.. first n fibonaccis

Constraints
1 <= n < 40
  
Sample Input
10
Sample Output
0
1
1
2
3
5
8
13
21
34

Code:

package GettingStarted;

import java.util.Scanner;

public class printAllFiboTillN {
	
	public static void fibo( int n) {
		
		//hume pta hai ki humara first fibonacci number is 0 and second is 1
		int a= 0;
		int b= 1;
		for( int i=0; i< n; i++) { //jitni n ki value hai utni bar loop chalega
			System.out.println(a);
			
			int c= a+ b;
			a= b;
			b= c;
		}
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		fibo(n);
	}

}
