Get Maze Paths

1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
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
3
3
Sample Output
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]

Code:

package Recursion;

import java.util.Scanner;
import java.util.ArrayList;

public class getMazePath {

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
	public static ArrayList<String> getMazePaths( int sr, int sc, int dr, int dc){
		if( sr == dr &&  sc== dc) { // basecase mai hum vishwas dilana hai ki 3,3 se 3,3 tak ek rasta hai and that rasta is ki apni jagah se hilo hi mat
			ArrayList<String> bres= new ArrayList<String>();
			bres.add("");
			return bres;
		}
		
		// vertical and horizontal path ki new arraylist bana lenge taki basecase mai help ho
		ArrayList<String> hpaths= new ArrayList<String>();
		ArrayList<String> vpaths= new ArrayList<String>();
		
		// horizontal call lagne keliye jaruri hai ki aap last column mai nhi ho
		if( sc < dc ) { //agar aapka source column destination column se chota hai, matlab hum right wall pe nhi hum thodasa andar hai to hum horizontal call laga skte hai
			// hume faith yeh hai 
			hpaths= getMazePaths(sr, sc +1, dr, dc); // yeh horizontal move hai hum column badha rhe hai wahase destination row and column tak jo raste exist krte hai woh lake dega
		}
		
		//isi tarah se agar aapka source row destination row se choti hai to hum vertical call laga skte hai
		// vertical call lagne keliye jaruri hai ki hum last row mai nhi hai
		if( sr < dr) {
			// hume yeh bhi faith hai ki mai vertical move karunga to pahuchunga
			 vpaths= getMazePaths(sr + 1, sc, dr, dc);
		}
		
		ArrayList<String> paths= new ArrayList<String>(); // yeh humara final wala path hai
		
		// horizontal path mai loop lagayenge, usme jo paths hongi uske muh pe 'h' lagayenge aur apne answer arraylist mai add karenge 
		for( String hpath: hpaths) {
			paths.add("h"+hpath);
		}
		
		//vertical paths mai loop lagayenge and unke muh pe v lagayenge
		for( String vpath: vpaths) {
			paths.add("v"+vpath);
		}
		
		return paths;
	}
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		
		ArrayList<String> paths= getMazePaths(1, 1, n, m); // 1,1 se hume n,m jana hai matlab top left se hume bottom right jana hai
		System.out.println(paths);
	}
}
