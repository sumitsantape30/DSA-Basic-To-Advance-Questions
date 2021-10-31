Queens Combinations - 2d As 2d - Queen Chooses

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

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        
        //aise krte krte jab sari queens baith chuki ho to loop lagao aur print krdo 
        if( qpsf == tq){
            for( int row=0; row < chess.length; row++){
                for( int col=0; col < chess.length; col++){
                    if( chess[row][col] == true){ //agar queen baithi hai to queen print karenge else dash print karenge
                      System.out.print("q\t");
                    }else{ // rani nhi baithi to dash print krdenge
                      System.out.print("-\t");
                    }
                }
                //jab ek row hojaye to enter lagado
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for( int col= j+1; col < chess.length; col++){ //maine column ka loop lagaya, maine row ka nhi lagaya kyuki row to same hi rahegi, last time meri qeueen jaha baithi thi usski row ke aage wale columns 
            chess[i][col]= true; //row wahi use kiya jo pichese pass hua tha
            queensCombinations(qpsf +1, tq, chess, i, col); // maine isko ith row mai aur col column mai bithaya to woh pass karenge
            chess[i][col]= false; // wapas aate waqt isko undo karenge
        } //abhi apne uss row ke jaha queen baithayi thi usko bache hue columns cover kiye but agli row and agli column bhi to cover karenge
        
        for(int row= i+1; row < chess.length; row++){ //agli row se start hoga
           //aur column humare 0 se chalenge
           for( int col=0; col < chess.length; col++){
               chess[row][col]= true;
               queensCombinations(qpsf +1, tq, chess, row, col); // jisme bithaya wahi aage pass karenge
               chess[row][col]= false;
           }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1); // hume pas kuya gya hai abhi kitni queens baithi hai 0, total kitni bithani hai n, then chess board, fir i and j yeh yeh represent krta hai ki previous level ki queen kaha baithi thi so shuruwat mai 0,-1 pas kiya to pichli queen kahi nhi baithi thi 
    }
}
