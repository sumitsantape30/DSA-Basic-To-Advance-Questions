Words - K Selection - 2

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
     word.
 
Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.

Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 
Question Video

Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aabbbccdde
3
Sample Output
abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void generateSelection(String ustr, int cs, int ts, int lc, String asf) { // cs: current selection, ts: total selections, lc: last choice
  
    if (cs > ts) { // jab aisa hua means you have selected all that you wanted so print and return
      System.out.println(asf);
      return;
    }

    //jo apne last select kiya hota hai i ka loop usse aage chalta hai 
    for (int i = lc + 1; i < ustr.length(); i++) {
      generateSelection(ustr, cs + 1, ts, i, asf + ustr.charAt(i)); // current selection +1. ab aapne ith character select kiya hai to last choice mai i pass hoga kyuki pichli bar i select hua tha. asf mai yeh character add krlenge aur call lagayenge
    }
  }
  
  public static void main(String[] args) throws Exception { BufferedReader
    br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int
    k = Integer.parseInt(br.readLine());
    HashSet unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    generateSelection(ustr, 1, k, -1, ""); //1 is pehli selection karne ja rhe hai, total k select karne hai, aur last konsa character select kiya tha woh asf mai dalna hai . aur last choice -1 pass kiya hai coz pehle koi select hi nhi kiya tha
  }


}
