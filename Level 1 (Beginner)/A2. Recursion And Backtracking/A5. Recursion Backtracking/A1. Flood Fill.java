Flood Fill

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a. The numbers can be 1 or 0 only.
4. You are standing in the top-left corner and have to reach the bottom-right corner. 
Only four moves are allowed 't' (1-step up), 'l' (1-step left), 'd' (1-step down) 'r' (1-step right). You can only move to cells which have 0 value in them. You can't move out of the boundaries or in the cells which have value 1 in them (1 means obstacle)
5. Complete the body of floodfill function - without changing signature - to print all paths that can be used to move from top-left to bottom-right.

Note1 -> Please check the sample input and output for details
Note2 -> If all four moves are available make moves in the order 't', 'l', 'd' and 'r'
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
trrrdlt
tlldrt
.. and so on

  COMMENTConstraints
1 <= n <= 10
1 <= m <= 10
e1, e2, .. n * m elements belongs to set (0, 1)
Sample Input
3 3
0 0 0
1 0 1
0 0 0
Sample Output
rddr

Code:

package Restart;

import java.util.Scanner;
import java.util.ArrayList;

public class Problems {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		
		//ek visited array bhi chahiye hoga taki alreay visited path ko firse visit nhi kare
		boolean visited[][]= new boolean[n][m]; //by defaul isme har jagah false pda hoga, aur iss visited kobhi pass karenge
		floodfill(arr, 0, 0, "", visited);
	}

	// asf -> answer so far
	public static void floodfill(int[][] maze, int row, int col, String asf, boolean visited[][]) { //jab bhi kisi cell mai ayenge to uss cell ko sabse pehle visited mark karenge
		
		if( row < 0 || col < 0 || row == maze.length || col== maze[0].length || maze[row][col] ==1 || visited[row][col] == true) { //agar hum board ke bahar aagye or obstacle mila or already visited ho to return karenge 
			return;
		} // maze[row][col] ==1 yh coondition last mai hi likhna coz agar pehle rakhdi yeh condtn aur row -ve hua to index out of bound de dega. Agar hum board ke andar hai tabhi woh last condition check hogi
		
		if( row== maze.length-1 && col == maze[0].length-1) {
			System.out.println(asf);
			return;
		}
		
		// so kisibhi direction mai jane se pehle visited mark karenge ki iss cell pe aa chuke hai
		visited[row][col]= true;
		
		
		//mere pas 4 choices hai
		//pehle top ke taraf jayenge
		floodfill(maze, row-1, col, asf + "t", visited); //top
		floodfill(maze, row, col -1, asf + "l", visited); //left
		floodfill(maze, row + 1, col, asf + "d", visited); // down 
		floodfill(maze, row, col +1, asf + "r", visited); //right
		
		//apna kam hone ke bad means ek path milne ke bad uss cell ko hum non visited mark kr denge taki koi path mai woh cell use ho ske
		//so jab hum ek spot se 4 bhi calls laga chuke hai means woh function wipe out hone wala h, hum wahase return hone wale h so wapas jane se pehle usko unvisited mark kardo
		visited[row][col]= false;

	}
	
	 public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean visited[][]) { //jab bhi kisi cell mai ayenge to uss cell ko sabse pehle visited mark karenge
		
		if( sr < 0 || sc < 0 || sr == maze.length || sc== maze[0].length || maze[sr][sc] ==1 || visited[sr][sc] == true) { //agar hum board ke bahar aagye or obstacle mila or already visited ho to return karenge 
			return;
		} // maze[row][col] ==1 yh coondition last mai hi likhna coz agar pehle rakhdi yeh condtn aur row -ve hua to index out of bound de dega. Agar hum board ke andar hai tabhi woh last condition check hogi
		
		if( sr== maze.length-1 && sc == maze[0].length-1) {
			System.out.println(asf);
			return;
		}
		
		// so kisibhi direction mai jane se pehle visited mark karenge ki iss cell pe aa chuke hai
		visited[sr][sc]= true;
		
		
		//mere pas 4 choices hai
		//pehle top ke taraf jayenge
		floodfill(maze, sr-1, sc, asf + "t", visited); //top
		floodfill(maze, sr, sc -1, asf + "l", visited); //left
		floodfill(maze, sr + 1, sc, asf + "d", visited); // down 
		floodfill(maze, sr, sc +1, asf + "r", visited); //right
		
		//apna kam hone ke bad means ek path milne ke bad uss cell ko hum non visited mark kr denge taki koi path mai woh cell use ho ske
		visited[sr][sc]= false;
	}
}
