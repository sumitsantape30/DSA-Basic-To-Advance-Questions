Queens Permutations - 2d As 2d - Queen Chooses

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
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
q1	q2	
-	-	

q1	-	
q2	-	

q1	-	
-	q2	

q2	q1	
-	-	

-	q1	
q2	-	

-	q1	
-	q2	

q2	-	
q1	-	

-	q2	
q1	-	

-	-	
q1	q2	

q2	-	
-	q1	

-	q2	
-	q1	

-	-	
q2	q1	

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){ //qpsf: queens placed so far, tq: total queens
        if( qpsf == tq){ //aise krte krte jab sari queens baith chuki hogi to loop lagake print krdenge
         for( int i=0; i< chess.length; i++){
             for( int j=0; j< chess[0].length; j++){
                 if( chess[i][j] == 0){ //agar 0 pda hai to woh khali hai to dash print hoga
                  System.out.print("-\t");
                 }else{
                     // agar bhara hua hai to usme jo number hai woh wali queen print hogi
                     System.out.print("q"+ chess[i][j] + "\t");
                 }
             }
             System.out.println();
          }
          System.out.println();
          return;
        }
        
        //aapki pehli qeueen kahipe bhi baith skti hai bas woh dabba khali hona chahiye
        for( int i=0; i< chess.length; i++){
            for( int j=0; j< chess[0].length; j++){
                if( chess[i][j] == 0){ //agar board occupied nhi hai to aap apni queen waha place krde
                chess[i][j]= (qpsf + 1) ; //qpsf hai agr apko 0 pass kiya hai aap first queen waha baithaye fir call lagade
                queensPermutations(qpsf +1, tq, chess); // queen ko bitha diya to qpsf ko ek se badhaye
                chess[i][j] = 0;// wapas aate hue board ko khali karna na bhule
                }
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess); //abhitak 0 queens placed hai 
    }
}

//===============================================================================JB's===========================================================

import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
         if( qpsf == tq){ // agar queens placed so far total queens ke equal hai means sari queen placed krdi hai
            for( int i=0; i< chess.length; i++){
                for( int j=0; j< chess[0].length; j++){
                    if( chess[i][j] == 0){ // gar 0 pda hai means yeh empty box hai to mai dash print karunga
                      System.out.print("-\t");
                    }else{
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
         }

        //pehli queen keliye sare options
        for(int i=0; i< chess.length; i++){
            for( int j=0; j< chess[0].length; j++){
                //jojo empty boxes honge woh mere liye options honge
                if( chess[i][j] == 0){ // yeh spot empty hai to mai yaha apni queen place kr skta hu 
                   chess[i][j] = qpsf+1;
                   //aur baki queens keliye recursive call laga denge
                   queensPermutations( qpsf+1, tq, chess);
                   //wapis aate hue jo queen humne place ki thi usko unplace karni padegi
                   chess[i][j] = 0;
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}
