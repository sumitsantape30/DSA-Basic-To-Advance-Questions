Words - K Length Words - 4

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words by using chars of the word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 

Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aaabb
3
Sample Output
aaa
aab
aba
abb
baa
bab
bba

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void fun( String str, HashMap<Character, Integer> fmap, int cs, int ts, String asf){ // cs: current spot, ts: total spots, asf: answer so far
  
      if( cs == ts + 1){ // agar current spot total spot+1 ke equal hojata hai, kyuki humne main function mai current spot 1 pass kiya hai, 3 spot then aur tum 4 pe gye means humara kam hochuka hai
        System.out.println(asf);
        return;
      }
      
      //pehle spot keliye sare options hote hai, jitne bhi unique string ke andar characters hote hai woh sare options honge
      for( int i=0; i< str.length(); i++){
          char ch= str.charAt(i);
          //ab hume hashmap mai check karna hoga iski frequency bachi hui hai humare pas, agar iski frequency grater than 0 hai matlab hum isko use kr skte hai
          if( fmap.get(ch) > 0 ){
              fmap.put(ch, fmap.get(ch) - 1); // frequency ko 1 se kam krdo
              fun(str, fmap, cs + 1, ts, asf + ch); // current spot ka faila hogya so cs+1
              fmap.put(ch, fmap.get(ch) + 1); // wapas aate hue uss frequency ko dubara thik kardenge. freuquency 1 se kam ki thi isliye wapas aate hue badha di
          }
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    
    HashMap<Character, Integer> fmap = new HashMap<>();
    String ustr= "";
    
    for( int i=0; i< str.length(); i++){
        char ch= str.charAt(i);
        
        if( fmap.containsKey(ch) == true){ // agar map mai character apko mil jata hai to uski frequency update krdenge
          fmap.put(ch, fmap.get(ch) + 1);
        }else{ // yaha aaye means pehli bar aa rha hai to uski frquency rakhdo 1 aur usko unique string mai bhi add krdo
           fmap.put(ch, 1);
           ustr += ch;
        }
    }
    
    fun(ustr, fmap, 1, k, ""); // current spot is 1 means pehle spot ka faisla kr rhe hai, and total number of spots will be k

  }

}
