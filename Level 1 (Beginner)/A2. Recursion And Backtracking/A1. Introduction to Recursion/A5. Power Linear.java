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
		
		if( n == 0) {
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

Analysis
Time Complexity :
O(n)
Since you are recursively calling for a subproblem with n-1 from n, hence n + 1 recursive calls will be made (+ 1 when it hits the base case n = 0). You can also count the number of recursive calls in the call stack. So the time complexity turns out to be O(n) (which is independent of the value of x).

SPACE COMPLEXITY :
O(1)
There is no data structure used, thus no auxiliary space is used. Hence, space complexity is O(1).
Note: There are n recursive calls that do take stack space, but we do not account for this space as we are only concerned with space used by data structures defined by us.
However, if it is mentioned to give the space complexity which takes into account the space taken by recursion call stack also, then, since there are n recursive calls, hence O(n) space will be required.
