Queens Combinations - 2d As 1d - Queen Chooses

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 

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
q	q	
-	-	

q	-	
q	-	

q	-	
-	q	

-	q	
q	-	

-	q	
-	q	

-	-	
q	q	

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        if(qpsf == tq){ //sari queens place hogyi to print and return
          
          for(int row = 0; row < chess.length; row++){
              for( int col=0; col< chess.length; col++){
                  if( chess[row][col] == true){
                      System.out.print("q\t");
                  }else{ //agar queen nhi hai khali hai badda to
                      System.out.print("-\t");
                  }
              }
              System.out.println();
          }
           System.out.println();
           return;
        }
        
        for( int cell= lcno+1 ; cell < chess.length*chess.length; cell++){ // jaha last queen baithayi thi uske aage loop chalayenge end tak
            
            //ab aap ith cell mai baithana chahte ho to apko wapas row no banani padegi 
            int row= cell / chess.length;
            int col= cell % chess.length;
            //apko pass kiya gya 1d ki tarah, loop bhi humne 1d ki tarah lagaya aur ab humne usko row col means 2d mai convert karliya kyuki chess mai row col mai hi dal payenge na wog to 2d hai
            chess[row][col] = true; //pehle check karneki jarurat nhi hai ki true hai ki nhi coz hum humesha aage wale dabbe mai dalte hai 
            
            queensCombinations(qpsf+1, tq, chess, cell); //ek aur queen place hogyi hai to +1 aur abhi cell th dabbe mai dala hai to cell pass kiye
            
            chess[row][col]= false;
            
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1); //last cell no -1 pass kiye ki pichli rani -1 pe baithi thi
    }
}

//=================================================================JB's============================================================

import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lbu) {
        if(qpsf == tq){ // basecase pichle question jaisahi hai wahi copy karo
          
          for(int row = 0; row < chess.length; row++){
              for( int col=0; col< chess.length; col++){
                  if( chess[row][col] == true){
                      System.out.print("q\t");
                  }else{ 
                      System.out.print("-\t");
                  }
              }
              System.out.println();
          }
           System.out.println();
           return;
        }

        for( int i= lbu +1; i < chess.length * chess.length; i++){
            // fir row aur column nikalne padenge aur waha queen ko place kardenge
            int row = i / chess.length;
            int col = i % chess.length;
            //so iss row aur col pe queen place krdo
            chess[row][col] = true;
            queensCombinations(qpsf +1, tq, chess, i); // i will be the last box used
            chess[row][col] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
