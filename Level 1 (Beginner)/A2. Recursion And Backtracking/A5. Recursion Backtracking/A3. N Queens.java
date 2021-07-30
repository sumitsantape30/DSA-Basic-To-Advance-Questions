N Queens

1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output

  COMMENTConstraints
1 <= n <= 10
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

Code:

package Restart;

import java.util.Scanner;
import java.util.ArrayList;

public class Problems {

	public static void main(String[] args) throws Exception {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		boolean chess[][]= new boolean[n][n]; //boolean ka lenge coz true false hi mark karna h ki yahape queen place hai ya queen place nhi h 
		printNQueens(chess, "", 0);
	}

	public static void printNQueens(boolean[][] chess, String asf, int row) {
		// jab row number chess.length pe pohoch jaye to wahase apna answer print krte hue return karna chahiye
		if( row == chess.length) {
			System.out.println(asf + ".");
			return;
		}
		
		//row 0 mai ek hi queen place hogi aur woh queen place karane keliye sare columns options hai
		for( int col= 0; col < chess[0].length; col++) {
			//ab mai dehunga kya uuss sport mai meri queen safe hai
			if( isItSafe(chess, row, col) == true) { //agar safe hai to uss spot pe queen ko place karwa do
				chess[row][col]= true; // place the queen
				// aur fir next queen keliye call lagwado, next queen next row mai place hogi
				printNQueens(chess, asf + row + "-" + col + ",", row+1); // answer so far mai abhi ke ans ko daldo aaur agli queen agli row mai baithegi so row+1 kardo
				// wpaas aate waqt usse unplace bhi karoge
				chess[row][col]= false; // unplace the queen
			}
			
		}
		
	}
	
	public static boolean isItSafe(boolean chess[][], int row, int col) {
	    //meri queen safe hai ya nhi yeh check karne keliye mere piche wale3 directions mai check karna padega
		//check karne keliye muje apne same column aur diagonal d1 and d2 mai chack karna padega
		
		//check is column, same column mai check karna hai to row vary karegi
		for(int i= row-1; i >= 0 ; i--) {
			
			if( chess[i][col] == true) {// i, col pe kahipe bhi true dikh gya means our current spot is not safe
				return false;
			}
		}
		
		// diagonal 1 (right ki taraf)
		for(int i= row-1, j= col +1; i >= 0 && j < chess.length; i--, j++) {
			if( chess[i][j] == true) {
				return false;
			}
		}
		
		//d1
		for( int i= row-1, j= col -1; i >=0 && j >= 0 ; i--, j--) {
			if( chess[i][j] == true) {
				return false;
			}
		}
		
		return true; // sabkuch karne ke bad I can say our spot is safe
		
	}

}
