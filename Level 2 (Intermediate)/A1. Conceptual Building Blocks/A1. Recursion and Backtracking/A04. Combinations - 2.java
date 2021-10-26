Combinations - 2

1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without 
                   changing signature. The judge can't force you but intends you to teach a concept.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. - means empty box, i means occupied by item.

Constraints
0 < nboxes <= 10
0 <= ritems <= nboxes
Sample Input
5
3
Sample Output
iii--
ii-i-
ii--i
i-ii-
i-i-i
i--ii
-iii-
-ii-i
-i-ii
--iii

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(boolean[] boxes, int ci, int ti, int llb) { // llb: last level box, ki aakhi item konse box mai dala tha
  
    if( ci > ti){
        for( int i=0; i< boxes.length; i++){
            //true hai to i print karenge nhito - print karenge
            if(boxes[i] == true){
                System.out.print("i"); // i print karko ki wahape item hai
            }else{
                //else means empty box, empty box keliye - print karenge
                System.out.print("-");
            }
        }
        System.out.println();
        return;
    }
        
        for( int b= llb + 1; b < boxes.length; b++){ //jaha last box dala tha usse aage loop chalayenge
            if( boxes[b] == false){ //agar false pda hai means it is unoccupied box to usme true dal denge matlab it is occupied
                boxes[b]= true;
                combinations(boxes, ci +1, ti, b); //abhi aapne bth box mai place kiya hai to agle level ko btao ki humne bth box mai place kiya tha
                //wapas aate waqt hata de
                boxes[b]= false;
            }
            
        }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new boolean[nboxes], 1, ritems, -1); //boxes array interger tha but boolean bana diye
  }

}
