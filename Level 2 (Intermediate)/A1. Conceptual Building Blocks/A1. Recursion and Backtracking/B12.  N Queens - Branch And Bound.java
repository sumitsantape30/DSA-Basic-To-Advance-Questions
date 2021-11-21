N Queens - Branch And Bound

1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can 
     kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and 
     print all safe configurations of n-queens

Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit 
               of question is.

Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique and not test you.
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output

Constraints
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
    
    public static void solve(boolean[][] board, int row, boolean[] cols, boolean ndiag[], boolean rdiag[], String asf){
        //so humne row pass kari hai uss row mai hum yeh faisla karenge ki uss row mai queen konse column mai bithaye
        
        //agar aisa krte krte har row mai aap ek queen ko place karneme successful rhe means aap board ki length ki pass agye
        if(row == board.length){
            System.out.println(asf + ".");
            return;
        }
        
        // so mai sare columns pe jaunga aur wahape queen ko place karneki koshish karunga
        for( int col= 0; col < board.length; col++){
            // mai queen ko tabhi place kr skta hu jab cols bole iss column mai false pda hai aur normal diagonal bole iss row+col mai false pda hai, aur reverse diagonal bhi bolegi
            if(cols[col] == false && ndiag[row + col] == false && rdiag[row- col+ board.length-1] == false){ //agar yeh sab hua means woh occupied nhi hai to mai yaha queen bitha skta hu
             board[row][col]= true;
             //jaha queen bithayi hai usko occupy karlenge
             cols[col]= true;
             ndiag[row + col]= true;
             rdiag[row - col + board.length - 1] = true;
             
             solve(board, row+1, cols, ndiag, rdiag, asf+ row + "-" + col + ", "); // row badha denge ki agli queen agle row mai place ki jaye. aur asf mai jaha abhi apne queen place kari hai woh dalenge
             
             //jate jate board mai karenge false
             board[row][col]= false;
             //aur usko unoccupied bhi mark kardenge
             cols[col]= false;
             ndiag[row + col]= false;
             rdiag[row - col + board.length - 1] = false;
            }
        }
    }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    
    //3 arrays banayenge
    boolean cols[]= new boolean[n]; // n size ka columns array
    boolean ndiag[]= new boolean[2*n-1]; // normal diagonal, isme row+col ki value common rehti hai
    boolean rdiag[]= new boolean[2*n-1] ; // reverse diagonal, isme r-c + b.l -1 common value rehti hai
    
    //ab hum solve ko call karenge 
    solve( board, 0, cols, ndiag, rdiag, ""); // solve ko board pass karenge, row number ki 0th row mai pehli queen bitha rhe hai(har row mai ek queen bithayenge), fir teeno array pass kare aur answer so far  
  }

}

//========================================================JB's==========================================================

import java.io.*;
import java.util.*;

public class Main {

  public static void nQueens(boolean[][] chess, int i, boolean[] cols, boolean[] d1, boolean[] d2, String asf){
    int n= chess.length;

    if( i == chess.length){
      System.out.println(asf + ".");
      return;
    }

    //pehli queen keliye sare columns option rahenge to columns ke upar loop chalado
    for( int j = 0; j < chess.length; j++ ){ // j = columns
      //so yahape mai check karta tha ki queen safe hai ya nhi
      if( cols[j] == false && d1[i - j + n - 1] == false && d2[i + j] == false){// agar yeh teeno positions kisi queen ne aquire karke nhi rakhi hai to hum safe position pe hai to queen ko place krdo
        chess[i][j] = true;
        //queen ko jaisehi place kardiya to bolo cols[j] humne acquire krliya hai
        cols[j] = true;
        d1[ i - j + n - 1] = true;
        d2[ i + j ] = true;
        //humne queen yaha baithayi to inko true mark kardiya aur ab recursive call
        nQueens(chess, i + 1, cols, d1, d2, asf + i + "-" + j + ", "); // i+1 means aagli queen next row mai place hogi. aur output mai hume answer iss tarah se chahiye to waisehi asf mai add karenge
        // wapas aate time sabko unplace kardenge, kyuki hume dusri position try karni hai iske bad
        chess[i][j] = false;
        cols[j] = false;
        d1[i - j + n - 1] = false;
        d2[i + j] = false; 
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    boolean[] cols= new boolean[n];
    boolean d1[] = new boolean[2*n - 1]; // 2n-1 diagonals hote hai total
    boolean d2[] = new boolean[2*n - 1];

    nQueens(board, 0, cols, d1, d2, ""); // starting mai row number will be 0
    
  }

}
