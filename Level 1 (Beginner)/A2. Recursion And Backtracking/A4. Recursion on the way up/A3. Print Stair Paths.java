Print Stair Paths
1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
Output Format
Print paths (one path in each line) in order hinted by Sample output

Constraints
0 <= n <= 10
Sample Input
3
Sample Output
111
12
21
3

Code:

package Recursion;

import java.util.Scanner;

public class printStairPath {
	
	public static void printStairPaths(int n, String path) {
		
		if( n < 0) { // 0 se niche hye to journey khatam hai and yeh answer bhi nhi hai so print bhi nhi karenge
			return;
		}
		
		if( n == 0) { // aur kabhi kabhi hum 0 pr pohoch jayenge
			// journey 0 pebhi khatam hai lekin yeh sahi rasta hai isko print karenge
			System.out.println(path);
			return;
		}
		
		// apne teeno options express kardo usse new levels ban jayenge
		printStairPaths( n -1 , path + "1"); // humare pas option hai 1 step rakhna
		printStairPaths( n -2, path + "2"); // dusri option hai humare pas 2 kadam rakhna
		printStairPaths( n -3, path + "3"); // teesri option hai humare pas 2 kadam rakhna
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		printStairPaths(n, "");
	}

}
