N Queens Using Bit

1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
     Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
     Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
               Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique, bit manipulation 
               and not test you.
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

import java.io.*;
import java.util.*;

public class Main {

  public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
      
      if( row == board.length){ // aise krte krte jab tum sabko place kr chuke ho aur apki row aaye board length ke barbr
        System.out.println(asf + ".");
        return;
      }
      
      // jo row di hai usme hum kisi bhi column mai bithane ki koshish kr skte hai
      for( int col = 0; col < board.length; col++){
          // mai column mai tabhi try kr skta hu jab wahaki bits off ho
          if(// agar aisa hai to mai apni queen bitha dunga aur call laga dunga. bithane se pehle muje check karna padega ki woh corresponding bits off hai ki nhi
          ((cols & (1 << col)) == 0) && //column ke andar yeh bit off honi chahiye
          ((ndiag & (1 << (row + col))) == 0) &&
          ((rdiag & (1 << (row - col + board.length - 1))) == 0) 
          
           ){
          
              board[row][col] = true;
              cols ^= (1 << col);// column ke andar yeh bit on karni hogi, so toggle krke on karenge pehle off thi
              // normal diagonal mai r+c ki value common hoti hai to r+c apka bit number represent krta hai aur reverse diagnonal mai r-c+b.len-1 aapki bit ko represent krta hai.
              ndiag ^= (1 << (row + col)) ; // iss row+col ko block krdo means yeh row+col wali bit ko on krdo taki koi aur banda iss diagonal pe na baith ske
              rdiag ^= (1 << (row - col + board.length -1 ));
              solution(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + col + ", ");
              cols ^= (1 << col); // wapas aate hue dubara toggle kardiya to woh off hojayegi
              ndiag ^= (1 << (row+col)) ; // wapas jate hue dubara toggle krenge to off hojayegi
              rdiag ^= (1 << (row - col + board.length -1 ));
              board[row][col] = false; // wapas aate hue khali karenge
          }
      }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");
  }

}
