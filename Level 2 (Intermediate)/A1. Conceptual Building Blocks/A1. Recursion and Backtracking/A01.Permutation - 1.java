Permutation - 1

  1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't 
                   force you but intends you to teach a concept.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 0 means empty box.

Constraints
0 < nboxes <= 10
0 <= ritems <= nboxes
Sample Input
5
3
Sample Output
12300
12030
12003
13200
10230
10203
13020
10320
10023
13002
10302
10032
21300
21030
21003
31200
01230
01203
31020
01320
01023
31002
01302
01032
23100
20130
20103
32100
02130
02103
30120
03120
00123
30102
03102
00132
23010
20310
20013
32010
02310
02013
30210
03210
00213
30012
03012
00312
23001
20301
20031
32001
02301
02031
30201
03201
00231
30021
03021
00321


Code:
import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti) { // ci: current item, ti: total items
  
    if( ci > ti){ //aisa krte krte agar current item total item se jada hojayega to means aap sabko bitha chuke hai to print krde
     for( int i=0; i< boxes.length; i++){
         System.out.print(boxes[i]);
     }
     System.out.println();
     return;
    }
   
    //level pe current item hai, to faisla karna hai current item ka, current items keliye options hai jinte boxes hai. usmese valid boxes woh honge jo empty boxes hai 
    for (int i = 0; i < boxes.length; i++) { //sare boxes mai loop lagaya
        if( boxes[i] == 0){ //bithane keliye jaruri hai ki box khali ho so agar box khali hai to box mai aap apne current item ko bithade. jab woh box mai yeh place unoccupied hai matlab valid place hai
            boxes[i]= ci;
            //aur call lagade agle level pe agle bande ke faisla hoga
            permutations(boxes, ci+1, ti);
            boxes[i]= 0; // wapas aate hue box ko khali krdenge
        }
    }
  }

   //so hume rakhna hoga current item konsa hai aur total items kitne hai taki pta chale ki basecase kahape ayega aur ek rakhna padega ki i1 keliye kitne options hai, 4 options hai i1 kahipe bhi jake place ho skta hai to ek array rakhenge. 0th index denote karega box1, 1st index denote karega box 2 so on.
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems); // n booxes keliye ek array pas kar rakha hai iss array mai sab jagah 0 pda hai means khali hai, ritems means total items kitne hai, aur 1 is ci: current item ki pehle item konsa hai pehle item no 1 ka faisla hoga
  }
}
