Print Increasing Decreasing

1. You are given a positive number n. 
2. You are required to print the counting from n to 1 and back to n again.
3. You are required to not use any loops. Complete the body of pdi function to achieve it. Don't change the signature of the function.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
Output Format
n
n - 1
n - 2
..
1
1
2
3
..
n

Constraints
1 <= n <= 1000
Sample Input
3
Sample Output
3
2
1
1
2
3

Code:

package Recursion;

import java.util.Scanner;

public class DecreasingIncreasingNum {
	
	public static void decreasingIncreasingNum( int n) {
		
		if( n == 0) {
			return;
		}
		
		System.out.println(n);
		decreasingIncreasingNum(n-1);
		System.out.println(n);
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		decreasingIncreasingNum(n);
	}
}

Time Complexity :
O(n)
This time complexity is linear because a recursion call is made.

SPACE COMPLEXITY :
O(1)

As no extra space is required, therefore space complexity is constant. However, if we include the space used in the recursive stack then the space complexity is O(n).
