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

  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){ // cb: current box konsa box hai, tb: total box (kitne box hai), items: konsa items use ho chuka hai, ssf: abhitak kitne select hue, ts: total selections
    
    if(cb > tb){
        if( ssf == ts){ // jab selection so far total selections hogi to mai print karunga
          System.out.println(asf);
        }
        return;
    }
  
    for( int i=0; i< ts; i++){
        //jo item use krlenge pehle hume check karna hoga ki woh item unused hai 
        if( items[i] == 0){ // 0 pda hai to woh item unused hai
           // to item ko use karle, item ke andar 1 dalde
            items[i]= 1; // 1 pda hai means yeh item unused hai
            permutations(cb+1, tb, items, ssf +1, ts, asf+ (i+1) ); // ssf mai 1 add hua kyuki ek banda select hua hai. aur asf ke andar add karenge uss item ka number
            items[i]= 0; //isko 0 dal denge ki tum unused ho
            
        }
    }
    
    //ab woh wali combination dekhte hai ki yeh box bola mai kisiko nhi bithara
         permutations(cb+1, tb, items, ssf, ts, asf+ 0); // kisiko nhi bithara to ssf waisehi rahega. asf mai 0 add karenge means yeh kisiko nhi bitha rha
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");  // mera item array yeh track rakh rha hai ki yeh item used hai ya unsed hai
  }

}

//==================================================== JB's=====================================================

import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){ //cb: current box jiska faisla karoge, tb is total number of boxes, yahape items ka array liya hai muje yeh information chahiye ki konsa item select hochuka hai abtak aur konsa select nhi hua hai, ssf is kitne itema select kr chuke ho, ts: total selection: total items kitne select krne hai, asf is answer so far

    //basecase: jab sare boxes ka faisla hojaye 
    if( cb > tb){ // jitne basecases generate hue usme dekho ki kitne aise case hai jisme ssf ts ke equal hai 
        if(ssf == ts){ // jab selection so far total selection ke equal hota hai uss uss case mai humko print karna hai
          System.out.println(asf);
        }
        return;
    }
    
    //pehle mai lagaunga 'ha' ki call, ha ki multiple calls hongi 
    for( int i=0; i< items.length; i++){ //jojo item humne abhitak select nhi kiya woh sare place ho skte hai
       if( items[i] == 0){ // iska matlab hai ki yeh item abhitak select nhi kara gya hai to hum iss item ko select kr skte hai 
           items[i] = cb; // so iss item ko select karliya aur current box pe rakh diya 
          
          //aur baki boxes keliye recursive call laga denge 
          permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i+1) ); // selection so far will get inremented by 1 kyuki ek naya select kiya hai humne abhi. aur asf mai iss box pe konsa item number likha hai woh i+1 rakhenge coz items 0 se nhi 1 se start hote hai 
          //wapas aate hue items ko unselect karna hoga
          items[i] = 0;
       }
    }

    //No ki call: box ne boldiya ki mai select hi nho hona chahta mai kisiko place nhi karunga
    permutations(cb + 1, tb, items, ssf, ts, asf + "0") ; // current box ka faisla hogya ki woh khali rahega. asf mai 0 add hoga
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}
