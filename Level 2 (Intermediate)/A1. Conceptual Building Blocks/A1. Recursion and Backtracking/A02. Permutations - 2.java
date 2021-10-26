Permutations - 2

1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without 
                   changing signature. The judge can't force you but intends you to teach a concept.
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
13020
13002
10230
10203
10320
10302
10023
10032
21300
21030
21003
23100
23010
23001
20130
20103
20310
20301
20013
20031
31200
31020
31002
32100
32010
32001
30120
30102
30210
30201
30012
30021
01230
01203
01320
01302
01023
01032
02130
02103
02310
02301
02013
02031
03120
03102
03210
03201
03012
03021
00123
00132
00213
00231
00312
00321

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
