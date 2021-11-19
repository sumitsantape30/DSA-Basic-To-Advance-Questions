Queens Combinations - 2d As 2d - Box Chooses

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
qq
--

q-
q-

q-
-q

-q
q-

-q
-q

--
qq




Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if( row == tq){ // agar row equal to total queen hojaye matlab usse aage nhi ja skte aap
         if(qpsf == tq){
            System.out.println(asf);
         }
          return;
        }
        
        int nr=0; //new row
        int nc=0; // new column
        String yasf= ""; // yes asf, ki bithaya uska answer
        String nasf= ""; // no asf, nhi bithaya uska answer
        
        if( col == tq-1){ //agar column extreme par hai, 4*4 ka board hai to extreme column 3 pe ho skta hai
            //agar col extreme pe hai to purane row se badh jayenge aur column 0 hojayega
            nr= row +1;
            col= 0;
            //agar row badal rhi hai to asf mai q add krdo, \n lagado kyuki enter lagana hai kyuki hum extreme par hai to next line
            yasf = asf + "q\n";
            nasf = asf + "-\n"; //nsf mai purana asf + dash ke sath \n
        }else{ //agar extreme pe nhi hai to
        
            nr = row; // row nhi badhegi
            nc= col + 1;
            //agar tum usi row ke andar ho to enter nhi lagega
            yasf = asf + "q"; // purane asf mai bithane keliye queen add krdo
            nasf=  asf + "-"; //nhi bithane keliye - add krdo
            
        }
        queensCombinations(qpsf + 1, tq, nr, nc, yasf) ; // isne ha kaha hai so yasf pass karre
        queensCombinations(qpsf + 0, tq, nr, nc, nasf) ; // isne na keh diya to qpsf badhi nhi, total queen utni hi hai, yeh no wali call hai to nasf pass kro kyuki queen nhi badhayi humne
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}

//=====================================================JB's===================================================

import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
       if( col == tq){ // aisa hua means woh extreme pe aagya hai apne
           col = 0;
           row++;
           asf += "\n";
       }

       //basecase
       if( row == tq){
           if( qpsf == tq){
               System.out.println(asf);
           }
           return;
       }

        // pehle ha ki call lagani hai 
       queensCombinations(qpsf + 1, tq, row, col+1, asf+"q"); // row wahi rahegi coz usi row mai ho so next column pe chale gye kyuki row,col pe to humne queen place karwa di. aur humne queen(q) place karwayi hai to asf mai "q" add kardo.
       //No ki call
       queensCombinations(qpsf, tq, row, col+1, asf+"-"); // queen select nhi hui to asf mai "-" add hogi

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
