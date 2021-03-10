Count Digits In A Number

1. You've to count the number of digits in a number.
2. Take as input "n", the number for which the digits has to be counted.
3. Print the digits in that number.
  
Input Format
"n" where n is any integer.
Output Format
"d" where d is the number of digits in the number "n"
  
Constraints
1 <= n < 10^9
Sample Input
65784383
Sample Output
8

Code:
package GettingStarted;

import java.util.Scanner;

public class CountDigitInNum {
	
	public static int countDigit( int n) {
		
		int count=0;
		while( n != 0) {
			n= n/10; //n ko 10 se divide karke wapas n mai hi dal denge, n chota hojayega
			//after every number is decreased from the number we increase count by 1
			count++;
		}
		return count;
		
	}

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int count= countDigit( n);
		System.out.println(count);
	}

}
