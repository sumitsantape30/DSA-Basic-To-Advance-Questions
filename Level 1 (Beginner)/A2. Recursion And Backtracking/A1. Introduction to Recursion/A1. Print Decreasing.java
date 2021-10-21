Print Decreasing
Easy  Prev Next  
1. You are given a positive number n. 
2. You are required to print the counting from n to 1.
3. You are required to not use any loops. Complete the body of print Decreasing function to achieve it.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
Output Format
n
n - 1
n - 2
.. 
1


Constraints
1 <= n <= 1000
Sample Input
5
Sample Output
5
4
3
2
1

Code:
package Recursion;

import java.util.Scanner;

public class DecreasingNumber {
	
	public static void printDecreasing( int n) {
		
		if( n == 0) {
			return;
		}
		// n print kardunga and printDecreasing(n-1) call karke uspe believe karunga ki woh 1 tak print kardega
		System.out.println(n);
		printDecreasing(n-1);
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		printDecreasing(n);
		
	}

}

Analysis
Time Complexity: O(n)
As n calls are made and work is done corresponding to these n calls therefore the time complexity becomes O(n).

Space Complexity: O(1)
Since no extra space is used, therefore space complexity is constant, however you should know that if the recursion call stack is taken into account, then space complexity will be O(n) as there are n recursive calls.
