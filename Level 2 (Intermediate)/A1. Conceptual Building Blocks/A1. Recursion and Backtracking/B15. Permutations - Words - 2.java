Permutations - Words - 2

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

  public static void generateWords(int cc, String str, Character[] spots, 
                                   HashMap<Character, Integer> lastOccurence) {
    
    if( cc == str.length()){ //aise krte krte current character string ki length ke equal hogya to apke spots[] mai jo character hai usko print karke return
      for( int i=0; i < spots.length; i++){
          System.out.print(spots[i]);
      }
      System.out.println();
      return;
    }
    
    char ch= str.charAt(cc); // humne current character nikal liya
    // ab uski last occurence dekhlo, last occurence kaha hui thi
    int lo= lastOccurence.get(ch); // agar iski last occurence hui thi to kaha hui thi. agar yeh nhi occur hua hoga to iski last occurence ayegi -1 ki pichli bar -1 pe hua tha. agar occur hua tha to woh position ayega uske bad se loop chalayenge
    
    for( int i= lo +1; i < spots.length; i++){
        if( spots[i] == null){ // woh spot occupied nhi hona chahiye uss spot pe iss character ko dalde aur last occurence update krde
         spots[i]= ch;
         lastOccurence.put(ch, i); //uss character ka last occurence ko update krdere
         generateWords(cc +1, str, spots, lastOccurence); // call laga denge
         //wapas aate hue uss character ke occurence mai (hashamp mai) jo uski last wali occurence thi usko wapas daldo aur uss spot pe null daldo
         lastOccurence.put(ch, lo);
         spots[i] = null;
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
