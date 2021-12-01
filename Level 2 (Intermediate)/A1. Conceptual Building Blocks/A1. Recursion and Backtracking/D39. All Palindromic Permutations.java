All Palindromic Permutations

1. You are given a string of length n.
2. You have to print all the palindromic permutations of the given string.
3. If no palindromic permutation exists for the given string, print "-1".

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A String of length n
Output Format
Check the sample ouput and question video.

Constraints
1 <= length of string <= 15
Sample Input
aaabb
Sample Output
ababa
baaab

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
    if( cs > ts){ // aise  krte krte agar apka current spot total spot ke beyond nikal gya hai maltab sare spots apke ban gye hai to apki permutations tayaf hai asf ke andar, uske sath permutations ka reverse bhi lagana hai
     //to uska reverse tayar karenge
     String rev= "";
     for( int i = asf.length() - 1 ; i >= 0; i--){
         rev += asf.charAt(i);
     }
     
     String res = asf; // yeh humara result hai, pehle isme asf dalenge
     if( oddc != null){ // agar odd nhi hai null to result ke andar odd wala character add karo
         res += oddc;
     }
     res += rev; // aur last mai result ke andar reverse add karo
     System.out.println(res);
     return;
    }

    for ( char ch : fmap.keySet()) { // frquency map pe lagaya loop
      int freq = fmap.get(ch); // frquency map mai frequency kam krdo iski
      if (freq > 0) { // jab apki frquency grater than 0 ho tabhi kuch kr skte ho
        fmap.put(ch, freq - 1); // use karliye ek bar isliye frequency kam krdi
        generatepw(cs + 1, ts, fmap, oddc, asf + ch); // agle spot keliye call laga diya. jo character nikala tha use asf mai dal diya
        //wapas aate hue uss frequency ko restore krna hoga
        fmap.put(ch, freq);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    HashMap<Character, Integer> fmap = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(fmap.containsKey(ch)) { // agar yeh character frequency map mai pda hai to iski frquency badhayenge
        int of = fmap.get(ch); // old frequency
        fmap.put(ch, of + 1);
      } else { // agar nhi pda hai pehli bar add kr rhe hai to iske freuqency set karenge 1
        fmap.put(ch, 1);
      }
    }

    //isme check karenge kitne character hai odd frequency wale, agar odd frequency wala 1 se jada character nikla to hum kuch nhi kr skte iski palindromic permutation possible hi nhi hai
    // ab sabki frquency half karenge
    Character odd = null;
    int odds = 0; // kitni bar mila kitne odds hai
    int len = 0; // string ki length

    for ( char ch : fmap.keySet()) { // iss loop mai hum har ek ki frquency half kardenge
      int freq = fmap.get(ch);

      if (freq % 2 == 1) { // agar frequency odd hai to odds ko kardenge ++
        odd = ch;// yeh character odd mai set kardenge
        odds++;
      }
      fmap.put(ch, freq / 2); // sabki frequency hal
      len += freq / 2;
    }
    
    //ek se jada odd hai to kuch nhi karna
    if( odds > 1){
        System.out.println(-1);
        return;
    }
    
    generatepw(1, len, fmap, odd, ""); // shuruwat mai current spot 1 hai 1st character solve kr rhe hai, aur total spots length tak solve karna hai. aur asf mai "".
  }

}
