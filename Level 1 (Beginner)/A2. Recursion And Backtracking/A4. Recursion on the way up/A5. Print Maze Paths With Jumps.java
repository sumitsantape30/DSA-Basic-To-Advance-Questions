Print Maze Paths With Jumps
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
4. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
A number m
Output Format
Print paths (one path in each line) in order hinted by Sample output

Constraints
0 <= n <= 5
0 <= m <= 5
Sample Input
3
3
Sample Output
h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1

Code:

package Recursion;

import java.util.Scanner;

public class printMazePathWithJumps {
	
	// sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
    	if( sr == dr && sc == dc) {
    		System.out.println(psf);
    		return;
    	}
    	
    	
    	// horizontal direction mai kya hai mere pas options
    	for( int ms= 1; ms <= dc- sc; ms++) { // move distance h1 or h2 or h3
    		printMazePaths( sr, sc+ms, dr, dc, psf + "h"+ ms);
    	}
    	
    	//vertical move size
    	for( int ms= 1; ms <= dr- sr; ms++) {
    		printMazePaths( sr + ms , sc, dr, dc, psf + "v"+ ms);
    	}
    	
    	//diagonals, yeh donoko control krti hai isliiye yaha dono checks hone chahiye and dono chize badhayenge bhi
    	for( int ms= 1; ms <= dr- sr && ms<= dc-sc; ms++) {
    		printMazePaths( sr + ms , sc+ ms, dr, dc, psf + "v"+ ms);
    	}
        
    }

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		printMazePaths( 1, 1, n, m, "");
		
	}

}