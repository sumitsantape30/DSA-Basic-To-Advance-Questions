Digit Frequency

1. You are given a number n.
2. You are given a digit d.
3. You are required to calculate the frequency of digit d in number n.

Input Format
A number n
A digit d
Output Format
A number representing frequency of digit d in number n

Constraints
0 <= n <= 10^9
0 <= d <= 9
  
Sample Input
994543234
 4
Sample Output
3

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class DigitsFreqeuncy {
	
	public static int digitFrequency(int n, int dgt) {
		
		int count= 0;
		
		while( n > 0) {
			int rem= n % 10;
			if( rem == dgt) {
				count++;
			}
			n= n /10;
		}
		return count;
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int dgt= s.nextInt();

		int count= digitFrequency(n, dgt);
		System.out.println(count);
	}

}

