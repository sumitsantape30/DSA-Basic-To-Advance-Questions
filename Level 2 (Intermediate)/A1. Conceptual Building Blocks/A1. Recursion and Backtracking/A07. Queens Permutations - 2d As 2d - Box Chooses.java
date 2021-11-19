Queens Permutations - 2d As 2d - Box Chooses

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


q2	-
q1	-


q2	-
-	q1


-	q1
q2	-


-	q1
-	q2


-	q2
q1	-


-	q2
-	q1


-	-
q1	q2


-	-
q2	q1


Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        
        if(row == tq){ //basecase: agar apki aakhri row ajaye 
            if(qpsf == tq){ //yeh sirf decide karega print hoga ya nhi: agar sari queens baith gyi hai to asf ko print krdo
             System.out.println(asf);
             System.out.println(); //jab answer print hoga tabhi new line karenge
           }
           return; 
        }
        
        int nr=0; //new row
        int nc=0; // new column
        String sep= "\0"; //end mai tab lagana hota hai or \n lagana hota hai uske liye separator
        
        if( col == tq-1){ // agar apka column extreme par hai, total queen 4 hai to apka column 3 pr hai to next row hogi row+1 aur next column hoga 0
         nr= row+1;
         nc= 0;
         sep= "\n"; // agar row change ho rhi hai to separator is \n which is enter
        }else{
            //agar extreme pr nhi hai to next row rahegi isi row ke barabr 
            nr= row;
            nc= col + 1; // aur next column hoga column+1
            sep= "\t";         ; // agar row change nhi ho rhi to separator is \t
        }
        
        //ab dekhenge hum kis queen ko bitha skte hai
        // har box ke pas option hai ki kis queen ko bithau ya kisiko na bithau 
        
        //so sari queens pe loop ghumao, hum sari queens ko mauka de rhe hai 
        for( int i=0 ; i< queens.length; i++){
            if( queens[i] == false){ //agar woh queen used nhi hai to usko use krlo
               queens[i]= true;
               queensPermutations(qpsf+1, tq, nr, nc, asf+"q"+ (i+1) + sep, queens ); //humne queen place kardi hai to qpsf badhega, fir new row and new column. i=0 hai to apne queen 1 bithayi hai isliye asf mai i+1 kiye aur separator bhi add kare
               queens[i]= false; // wapas aate hue false krdo
            } 
        } //yeh queen bithane wali call hogyi ab queen nhi bithayenge woh wali call lgayenge
        
         queensPermutations(qpsf+ 0, tq, nr, nc, asf+ "-" + sep, queens ); // isme queen nhi badhegi fir asf ke andar - add hoga
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}

//=========================================== JB's==========================================

import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(col == tq){ // jab column number total queen ke equal hojata hai
          //column ko reset kardenge 0 pe, row ko ek se badha denge, aur asf mai ek enter laga denge
          col = 0;
          row++;
          asf += "\n";
        }

        //basecase
        if(row == tq){ // jab mera row number total queen ke barabr hojaye
          if( qpsf == tq){
              System.out.println(asf);
              System.out.println(); // output mai ek enter extra diya tha so humne yaha enter dala taki eccept ho
          }

          return;
        }
        
        //pehle ha ki calls, jitni queens hai utne mere pas options honge
        for( int i = 0; i< queens.length; i++){
            if(queens[i] == false){ // agar woh queen abhitak selected nhi hai to uss spot ko true kardo means humne ek queen ko bitha diya
               queens[i] = true;
               queensPermutations( qpsf + 1, tq, row, col + 1, asf + "q"+ (i +1) + "\t", queens); // aapne queen select krli to qpsf will get increamented by 1.  asf mai qpsf+1 add karenge coz initially qpsf 0 hai aur pehli queen place kr rha hu to 1 add hona chahiye answer mai 
               queens[i] = false;
            }
        }// so yes ki multiple calls hogyi

        //ab no ki call
        queensPermutations(qpsf, tq, row, col+1, asf + "-\t", queens); // sirf column mai change ayega
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
    }                                     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];                               

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
