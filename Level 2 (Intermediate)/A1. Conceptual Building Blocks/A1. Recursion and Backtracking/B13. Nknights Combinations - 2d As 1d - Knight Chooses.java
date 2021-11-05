Nknights Combinations - 2d As 1d - Knight Chooses

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n knights can be placed on the 
     n * n chess-board. 
3. No knight shall be able to kill another.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format
Check the sample output and question video

Constraints
1 <= n <= 5
Sample Input
2
Sample Output
k	k	
-	-	

k	-	
k	-	

k	-	
-	k	

-	k	
k	-	

-	k	
-	k	

-	-	
k	k	

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        // so muje 4 dabbe check karne hai
        if( i - 1 >= 0 && j-2 >= 0 && chess[i-1][j-2]){ // woh spot range mai hona chahiye aur iss spot pe pehlese knight baitha hai to you are not safe
            return false;
        }
        
        if( i - 2 >= 0 && j-1 >= 0 && chess[i-2][j-1]){ //range mai hona chahiye aur iss spot pe pehlese knight baitha hai to you are not safe
            return false;
        }
        
        if( i - 2 >= 0 && j+1 < chess.length && chess[i-2][j+1]){ // iss spot pe pehlese knight baitha hai to you are not safe
            return false;
        }
        
        if( i - 1 >= 0 && j+2 < chess.length && chess[i-1][j+2]){ // iss spot pe pehlese knight baitha hai to you are not safe
            return false;
        }
        
        return true; // agar waha kahi nhi pda to aap bilkul safe hai
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) { // IsKnightSafe call kiya ki aagar knight safe hai tabhi bithaye
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}
