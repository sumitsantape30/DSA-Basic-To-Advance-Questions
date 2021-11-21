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

//=================================================================== JB's====================================================

import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cs, int ts, HashMap<Character, Integer> map, String asf) { // cs: current spot, ts: total number of spots
  
   if( cs > ts){ // jab sare spots ka faisla hojaye to answer print karke return jajayenge
     System.out.println(asf);
     return;
   }
    
    //pehle spot keliye hashmap mai jitne characters honge woh sare options honge
    for( char ch: map.keySet()){ //map ka keyset mangwa liya
        if( map.get(ch) > 0){ // mereliye yeh character mere liye tabhi usefull hai agar iss character ki frequency greater than 0 hai
            //is character mai use karna chahta hu to iss character ki frquency mai update kardunga
            map.put(ch, map.get(ch) - 1); // uss character ki frequency ko ek se reduce krdiya kyuki mai iss character ko usr krne ja rha hu
            //fir iss character ko use karo aur agle spot keliye recursive call
            generateWords( cs + 1, ts, map, asf + ch); // asf mai woh character add hojayega
            //wapas aate hue muje dubara uss character ki frequency thik karni padegi, upar frequency 1 se reduce ki thi so wapas aate hue iski frequency ek se badhani padegi
            map.put(ch, map.get(ch) +1);
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

//================================================================JB's============================================================

import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> map) { // iss hashmap mai store hoga last occurence, cc: current character
     if( cc == str.length()){ // jab current charcter string.length pe pohoch jaye 
        for( int i=0; i< spots.length; i++){
            System.out.print(spots[i]);
        }
        System.out.println();
         return;
     }
     
     int lo = map.get(str.charAt(cc)); // current character ki last occurence maine nikal li
     
     //pehle character keliye jitne spots hai sare options honge
     for(int i=  lo + 1 ; i< spots.length; i++){ // jobhi last occurence hai uske aage se start karunga
         if( spots[i] == null){ // spots[i] pe null pda hai matalb woh empty hai to hum usko acquire kr skte hai
            spots[i] = str.charAt(cc); // uss spot pe current character ko rakh diya
            //ab muje current character ki last occurence update karni padegi
            map.put(str.charAt(cc), i); // iss current character ki last occurence hai i
            
            //aur fir agle character keliye recursive call
            generateWords(cc + 1, str, spots, map);
            //wapas aate hue uss spot ko kahli krdenge aur uski original wali last occurence wapis rakhdenge
            spots[i] = null;
            map.put(str.charAt(cc), lo);
         }
     }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1); // character ke samne -1 pass kiya hai means abhi yeh character kahipe bhi nhi hai. -1 pe appear kiya tha but -1 to koi box hi nhi hai
    }

    generateWords(0, str, spots, lastOccurence);
  }

}
