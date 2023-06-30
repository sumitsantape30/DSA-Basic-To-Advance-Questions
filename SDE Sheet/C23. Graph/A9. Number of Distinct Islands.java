Number of Distinct Islands
Problem Statement: Given a boolean 2D matrix grid of size N x M. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. 
Two islands are considered to be distinct if and only if one island is equal to another (not rotated or reflected).

Code:
package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	public static class Pair{
		int first;
		int second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public Pair() {
			
		}
	}
	
	//ek starting point aya to yeh function use nbrs mai bhi traverse karega
	public static void bfs(int row, int col, int visited[][], int grid[][]) {
		
		visited[row][col] = 1;
		
		Queue<Pair> que = new ArrayDeque<>();
		que.add( new Pair(row, col));
		
		int n = grid.length;
		int m = grid[0].length;
		
		while( ! que.isEmpty()) {
			
			//remove
			int rrow = que.peek().first;
			int rcol = que.peek().second;
			que.remove();
			
			//traverse on nbrs
			//row and cols -1 to +1 vary krhe hai
			for(int deltaRow= -1; deltaRow<= 1; deltaRow++) {
				for( int deltaCol = -1; deltaCol <= 1; deltaCol++) {
					
					int nbrRow= rrow + deltaRow; //yeh deltaRow ki value -1, 0 , 1 aise hoti rahegi to 9 directions mai traverse krne mai help hogi
					int nbrCol = rcol + deltaCol;
					
					//yeh naye nbrRow aur nbrCol aaye hai they should be valid aur woh unvisited hone chahiye aur us spot pe 1 hona chahiye
					if( nbrRow >=0 && nbrRow < n && nbrCol >=0 && nbrCol < m &&  grid[nbrRow][nbrCol] == 1 && visited[nbrRow][nbrCol] != 1 ) {
						
						//visited mark krkde que mai push krdenge
						visited[nbrRow][nbrCol] = 1;
						que.add(new Pair(nbrRow, nbrCol));
						
					}
				}
			}	
		}
		
	}

	public static int numberOfIslands( int grid[][]) {
		
		int n = grid.length;
		int m = grid[0].length;
		
		int visited[][]= new int[n][m];
		
		int count = 0; //islands ki count rakhega
		
		for( int row= 0; row < n; row++) {
			for( int col = 0; col < m; col++) {
				
				if( visited[row][col] == 0 && grid[row][col] == 1) { //agar yeh spot visited nhi hai to yahase starting kr skte hai aur yeh ek new land ki shuruwat ho skti hai 
					count++;
					bfs(row, col, visited, grid);
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {

		 int grid[][] = {
			        {1, 1, 0, 1, 1},
			        {1, 0, 0, 0, 0},
			        {0, 0, 0, 0, 1},
			        {1, 1, 0, 1, 1}};
		 
		 System.out.println(numberOfIslands(grid));
	}

}
