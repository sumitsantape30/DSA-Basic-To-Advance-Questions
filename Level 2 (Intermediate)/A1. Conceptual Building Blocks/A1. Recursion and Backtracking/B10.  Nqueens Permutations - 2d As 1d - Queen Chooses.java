Nqueens Permutations - 2d As 1d - Queen Chooses

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens (distinct) can be 
     placed on the n * n chess-board. 
3. No queen shall be able to kill another.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format
Check the sample output and question video
Question Video

Constraints
1 <= n <= 5
Sample Input
4
Sample Output
-	q1	-	-	
-	-	-	q2	
q3	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q2	
q4	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q2	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q4	
q2	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q4	-	-	-	
-	-	q2	-	

-	q1	-	-	
-	-	-	q4	
q3	-	-	-	
-	-	q2	-	

-	-	q1	-	
q2	-	-	-	
-	-	-	q3	
-	q4	-	-	

-	-	q1	-	
q2	-	-	-	
-	-	-	q4	
-	q3	-	-	

-	-	q1	-	
q3	-	-	-	
-	-	-	q2	
-	q4	-	-	

-	-	q1	-	
q4	-	-	-	
-	-	-	q2	
-	q3	-	-	

-	-	q1	-	
q3	-	-	-	
-	-	-	q4	
-	q2	-	-	

-	-	q1	-	
q4	-	-	-	
-	-	-	q3	
-	q2	-	-	

-	-	q2	-	
q1	-	-	-	
-	-	-	q3	
-	q4	-	-	

-	-	q2	-	
q1	-	-	-	
-	-	-	q4	
-	q3	-	-	

-	-	q3	-	
q1	-	-	-	
-	-	-	q2	
-	q4	-	-	

-	-	q4	-	
q1	-	-	-	
-	-	-	q2	
-	q3	-	-	

-	-	q3	-	
q1	-	-	-	
-	-	-	q4	
-	q2	-	-	

-	-	q4	-	
q1	-	-	-	
-	-	-	q3	
-	q2	-	-	

-	q2	-	-	
-	-	-	q1	
q3	-	-	-	
-	-	q4	-	

-	q2	-	-	
-	-	-	q1	
q4	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q1	
q2	-	-	-	
-	-	q4	-	

-	q4	-	-	
-	-	-	q1	
q2	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q1	
q4	-	-	-	
-	-	q2	-	

-	q4	-	-	
-	-	-	q1	
q3	-	-	-	
-	-	q2	-	

-	q2	-	-	
-	-	-	q3	
q1	-	-	-	
-	-	q4	-	

-	q2	-	-	
-	-	-	q4	
q1	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q2	
q1	-	-	-	
-	-	q4	-	

-	q4	-	-	
-	-	-	q2	
q1	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q4	
q1	-	-	-	
-	-	q2	-	

-	q4	-	-	
-	-	-	q3	
q1	-	-	-	
-	-	q2	-	

-	-	q2	-	
q3	-	-	-	
-	-	-	q1	
-	q4	-	-	

-	-	q2	-	
q4	-	-	-	
-	-	-	q1	
-	q3	-	-	

-	-	q3	-	
q2	-	-	-	
-	-	-	q1	
-	q4	-	-	

-	-	q4	-	
q2	-	-	-	
-	-	-	q1	
-	q3	-	-	

-	-	q3	-	
q4	-	-	-	
-	-	-	q1	
-	q2	-	-	

-	-	q4	-	
q3	-	-	-	
-	-	-	q1	
-	q2	-	-	

-	-	q2	-	
q3	-	-	-	
-	-	-	q4	
-	q1	-	-	

-	-	q2	-	
q4	-	-	-	
-	-	-	q3	
-	q1	-	-	

-	-	q3	-	
q2	-	-	-	
-	-	-	q4	
-	q1	-	-	

-	-	q4	-	
q2	-	-	-	
-	-	-	q3	
-	q1	-	-	

-	-	q3	-	
q4	-	-	-	
-	-	-	q2	
-	q1	-	-	

-	-	q4	-	
q3	-	-	-	
-	-	-	q2	
-	q1	-	-	

-	q2	-	-	
-	-	-	q3	
q4	-	-	-	
-	-	q1	-	

-	q2	-	-	
-	-	-	q4	
q3	-	-	-	
-	-	q1	-	

-	q3	-	-	
-	-	-	q2	
q4	-	-	-	
-	-	q1	-	

-	q4	-	-	
-	-	-	q2	
q3	-	-	-	
-	-	q1	-	

-	q3	-	-	
-	-	-	q4	
q2	-	-	-	
-	-	q1	-	

-	q4	-	-	
-	-	-	q3	
q2	-	-	-	
-	-	q1	-	
  
Code:

import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        //8 bhi directions mai check karna hoga
        
        //vertically up
        for( int i= row, j= col; i>=0; i--){
            if( chess[i][j] > 0){ //agar muje kahipe chess of i,j mai value mil gyi to hume woh mar skti hai to return false
               return false;
            }
        }
        
        //vertically down
        for( int i= row, j= col; i < chess.length; i++){
            if( chess[i][j] > 0){ 
               return false;
            }
        }
        
        //horizontally left
        for( int i= row, j= col; j >=0; j--){
            if( chess[i][j] > 0){ 
               return false;
            }
        }
        
        // horizontally right
        for( int i= row, j= col; j < chess.length; j++){
            if( chess[i][j] > 0){ 
               return false;
            }
        }
        
        //ab diagonal 1 check karenge, i and j dono kam ho rhe, row and column dono kam ho rhe hai
        for( int i= row, j= col; i >=0 && j >=0 ; i--, j--){
            if( chess[i][j] > 0){ 
               return false;
            }
        }
        
        //diag 2
        for( int i= row, j= col; i >=0 && j < chess.length; i--, j++){
            if( chess[i][j] > 0){ 
               return false;
            }
        }
        
        for( int i= row, j= col; i < chess.length && j < chess.length; i++, j++){
            if( chess[i][j] > 0){ 
               return false;
            }
        }
        
        for( int i= row, j= col; i < chess.length && j >= 0; i++, j--){
            if( chess[i][j] > 0){ 
               return false;
            }
        }
        
        // agar kisibhi direction mai queen na mile to return true
        return true;
    }


    public static void nqueens(int qpsf, int tq, int[][] chess) {
        
        if( qpsf == tq){ //agar apne sari queens place krdi hai to print karke return krenge
          for( int i=0; i< chess.length; i++){
              for( int j=0; j< chess.length; j++){
                  if( chess[i][j] == 0){ //agar uss cell mai kuch nhi pda cell khali hai 
                      System.out.print("-\t");
                  }else{
                      System.out.print("q"+ chess[i][j] + "\t");
                  }
              }
              System.out.println();
          }
         System.out.println();
         return;
        }
        
        for( int cell=0; cell < chess.length * chess.length; cell++){
            //ab isse row number col number bana skte hai
            int row= cell / chess.length;
            int col= cell % chess.length; 
            
            //ab apko check karna hoga woh dabba khali hai ya nhi
            if( chess[row][col] == 0 && IsQueenSafe(chess, row, col)){ //uss cell mai 0 pda hona chahiye aur woh jagah safe honi chahiye
             
               //agar aisa hai to iss cell ke andar apni queen ko bitha dunga
               chess[row][col]= qpsf + 1; // humne qpsf 0 pass ki hai means pehli queen isliye +1 kiye
               nqueens(qpsf+1, tq, chess); //bichme call lagadenge
               chess[row][col]= 0; // wapas aate hue uss cell pe 0 dal de
                
            }
        }
    }
// combination mai last selection pass krte the ki pichli wali kaha bithayi thi aur usse aage se loop lagate the yeh loop last choice+1 se chalta tha but permutation mai sare dabbe chalte hai piche bhi bitha skte hai

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
