Words - K Selection - 4

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all ways you can select k characters out of the word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 

Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aabbbccdde
3
Sample Output
aab
aac
aad
aae
abb
abc
abd
abe
acc
acd
ace
add
ade
bbb
bbc
bbd
bbe
bcc
bcd
bce
bdd
bde
ccd
cce
cdd
cde
dde

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void fun(String str, HashMap<Character, Integer> fmap, int cs, int ts, String asf, int lcui){// cs: current spot jiska abhi faisla kr rhe ho. total number of spots k hote hai. lcui is last character useth ka index
  
    if( cs == ts){ // agar current spot total spot ke equal hojat hai to yahase karo return apna ans print krke
     System.out.println(asf);
     return;
    }
    
    //sabse pehle first spot ka faisla hoga, pehle spot keliye sare options hote hai 
    for( int i= lcui; i< str.length(); i++){ // lcui se leke last tak loop chalaye. pehli bas lcui 0 hi pass kiya hai to loop 0 sehi start hoga
       
       char ch= str.charAt(i);
       if( fmap.get(ch) > 0){ // agar uss character ki frquency 0 se jada hoti hai to hum usko use kr skte hai to ekbar usko use krlo
         fmap.put(ch, fmap.get(ch)-1); // aur frquency ko update krdo aur recursive call lagado
         fun(str, fmap, cs+1, ts, asf+ch, i); // last character used index will be i
         //wapas aate hue uss character ki frquency dubar update krni hogi
         fmap.put(ch, fmap.get(ch) + 1 );
       }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    
     fun(ustr, unique, 0, k, "", 0); // 0 is current spot ki konse spot ka faisla le rhe ho and asf will be blank. and 2nd 0 is last character useth ka index 0 pass kiya. 
    
  }

}
