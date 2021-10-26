Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti) { // ci: current item, ti: total items
  
    if( ci > ti){ //aisa krte krte agar current item total item se jada hojayega to means aap sabko bithe chuke hai to print krde
     for( int i=0; i< boxes.length; i++){
         System.out.println(boxes[i]);
     }
     System.out.println();
     return;
        
    }

    for ( int i = 0; i < boxes.length; i++) { //sare boxes mai loop lagaya
        if( boxes[i] == 0){ //bithane keliye jaruri hai ki box khali ho so agar box khali hai to box mai aap apne current item ko bithade
           boxes[i]= ci;
           //aur call lagade agle level pe agle bande ke faisla hoga
            permutations(boxes, ci+1, ti)
            boxes[i]= 0; // wapas aate hue box ko khali krde
        }

    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems); // n booxes keliye ek array pas kar rakha hai iss array mai sab jagah 0 pda hai means khali hai, ritems means total items kitne hai, aur 1 is ci: current item ki pehle item konsa hai
  }

}
