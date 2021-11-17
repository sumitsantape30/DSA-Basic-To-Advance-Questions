Combinations - 1

1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'.
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

  public static void combinations(int cb, int tb, int ssf, int ts, String asf){ //cb: current box, abhi kis box ki bari hai, tb: total boxes, ssf: selection so far, ts: total selection ki kitne items select hone chahiye
  
     if( cb > tb){
         //sare ban chuke hai but apko sare print nhi krne
         if( ssf == ts){
             System.out.println(asf);
         }
        return;
     }
     //ek bas yes ki call ek bar no ki call
     //banda yaha keh rha hai ha mai select hona chahta hu
     combinations(cb+1, tb, ssf +1, ts, asf + "i"); //select hona chahta hu isliye - nhi hoga, i add hoga yeh ana chahta hai
     combinations(cb+1, tb, ssf, ts, asf+"-"); // current box upar jate hue badhega. ssf nhi badhi box ne mana kard diya, bande ne mana kardiya usliye - ayega
     
     //ana chahta hai to i add kiya nhi ana chahta hai to - add kiya
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}

//================================================================JB's=========================================================

import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int cb, int tb, int ssf, int ts, String asf){ 
      // ha aur na ki call se woh sare basecases generate honge 
      if( cb > tb){ // jab sare boxes ka faisla hojaye means jab cb>tb
        if( ssf == ts){ // jab selection so far total selection ke equal hoga unke print karna hai
           System.out.println(asf);
        }
        return;
      }

      //given output mai dekhe to pehle badde bhare hue hai matlab ha ki call lagegi
      combinations(cb + 1, tb, ssf + 1, ts, asf + "i"); //ssf ek se badhega kyuki humne ek box ke select karliya, asf mai i add karlenge
      //na ki call
      combinations(cb + 1, tb, ssf, ts, asf + "-"); // ssf nhi badhega kyuki yahape uss box ko select nhi kara item ko place karwane keliye, aur answer so far mai - add kardenge


  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}
