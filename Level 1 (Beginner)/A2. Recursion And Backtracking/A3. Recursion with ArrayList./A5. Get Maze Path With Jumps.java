Get Maze Path With Jumps

1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
A number m
Output Format
Contents of the arraylist containing paths as shown in sample output

Constraints
0 <= n <= 10
0 <= m <= 10
Sample Input
2
2
Sample Output
[h1v1, v1h1, d1]

Code:

package Recursion;

import java.util.Scanner;
import java.util.ArrayList;

public class GetMazePathWithJump {
	
	public static ArrayList<String> getMazePaths( int sr, int sc, int dr, int dc){
		if( sr == dr && sc == dc) { // yahape aaye means hum pohoch gye
			ArrayList<String> bres= new ArrayList<String>();
			bres.add("");
			return bres;
		}
		
		ArrayList<String> paths= new ArrayList<String>(); // hume expectation hai ki sr sc se dr dc ka path denge
		
		//faith wali line
		// pehle dekhte mai kis kis intermeate pe ja skta hu
		// horizontal move karke (means move ka size kitna hai) 
		for( int ms= 1; ms <= dc-sc ; ms++) { //(ms: move size) hum kitne horizontal move/jump kr skte hai itermediate pe jane keliye
			// ab hum lagayenge apna faithm, jahape bhi hum pohochenge wahase aage ke paths hume mil jayenge
			ArrayList<String> hpaths= getMazePaths(sr, sc+ ms, dr, dc);
			// move size dc-sc rahega horizontal direction mai
			
			//ab inn horizontal paths ko kaise convert kiya jaye ki yeh sr sc se dr sc ke path ban jaye
			for( String hpath : hpaths) {
				// jo paths aaye hai unke upar loop lagayenge woh h1/h2 types unke muh pe jod diya
				paths.add("h"+ ms + hpath);
			}
		}
		
		//vertical moves
		for( int ms= 1; ms <= dr - sr; ms++) {
			ArrayList<String> vpaths= getMazePaths(sr + ms, sc, dr, dc);
			for( String vpath: vpaths) {
				paths.add("v"+ ms + vpath); //coz hum vertical effort karke gye hai to v1 v2 v3 aise chipkayenge
			}
		}
		
		//ab diagonal mai humko dono walls control krti hai isliye dono check lagayenge
		// woh bottom wall and right wall dono ke andar rehni chahiye
		for( int ms= 1; ms <= dr - sr && ms <= dc - sc ; ms++) {
			ArrayList<String> dpaths= getMazePaths(sr + ms, sc + sc, dr, dc);
			for( String dpath: dpaths) {
				paths.add("d"+ ms + dpath); 
			}
		}
		
		return paths;
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		ArrayList<String> paths= getMazePaths(1,1,n,m);
		System.out.println(paths);
		
	}

}

