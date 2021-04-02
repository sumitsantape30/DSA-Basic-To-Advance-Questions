Print Maze Paths

1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of pri tMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
A number m
Output Format
Print paths (one path in each line) in order hinted by Sample output


Constraints
0 <= n <= 10
0 <= m <= 10
Sample Input
2
2
Sample Output
hv
vh

Code:

package Recursion;

import java.util.Scanner;

public class printMazePath {
	

	// sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) { // psf= path so far
    	//agar border ke bahar gye hai to print nhi karna hai agar andar honge to print kar denge
    	if( sr > dr || sc > dc) { // humne iss case mai border cross kardi so return without printing
    		return;
    	}
    	
    	if( sr == dr && sc == dc) { // yeh sahi hai so print kr denge
    		System.out.println(psf);
    		return;
    	}
        
    	// humare pas kya options hai
    	// ek option hai hum horizontal chale, horizontal chalenge to column badhega aur dr drc ko farak nhi padta. Aur apne path mai horizontal h add kardenge
    	printMazePaths(sr, sc+1, dr, dc, psf + "h");
    	// vertical chalenge to source row badhegi
    	printMazePaths( sr +1, sc, dr, dc, psf + "v"); // apne path mai vertical add kardenge
    }

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		// jo matrix ka dimension hoga uska input lenge
		int n=s.nextInt();
		int m= s.nextInt();
		printMazePaths( 1, 1, n, m, ""); // shuruwat mai path blank
	}
}
