Permutations - Words - 1

1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 

Constraints
0 < str.length() <= 4
Sample Input
aabb
Sample Output
aabb
abab
abba
baab
baba
bbaa

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) { // box matlab yeh asf diya hai pehle level pe iske first position pe laga denge agli level pr iske second positon pe laga denge
    
    if(cs > ts){ //aise krte krte jab current spot total spot se upar pohchega matlab huara kam hochuka hai to print karke return
      System.out.println(asf);
      return;
    }

    for (char ch : fmap.keySet()) { //yahase muje milenge unique characters
        if( fmap.get(ch) > 0){ // iss character ki frequency 2 badi honi chahiye, agar jada hai to call laga denge
         fmap.put(ch, fmap.get(ch) - 1); //aap yeh character use karenge so map mese iski frequency decrease krdo
         generateWords(cs+1, ts, fmap, asf+ch); //current spot: cs badh jayega, total spot utnehi. aur asf mai yeh character add krde aur next level keliye call lagade
         
         //aur wapas aate hue woh character wapas add krde aur frequency badhade
         fmap.put(ch, fmap.get(ch) + 1);
         
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    HashMap<Character, Integer> fmap = new HashMap<>(); // yeh frequency map hai joki humara question represent krta hai
    for (char ch : str.toCharArray()) {
      if (fmap.containsKey(ch)) {
        fmap.put(ch, fmap.get(ch) + 1);
      } else {
        fmap.put(ch, 1);
      }
    }

    generateWords(1, str.length(), fmap, "");
  }

}
