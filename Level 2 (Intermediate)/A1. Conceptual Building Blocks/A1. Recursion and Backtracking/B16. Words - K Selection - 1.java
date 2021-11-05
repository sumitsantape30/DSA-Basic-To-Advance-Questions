Words - K Selection - 1

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


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) { // agar woh character unique hashset mai nhi pda to unique mai dal diya aur sathmehi unique string mai add krdiya
        unique.add(ch);
        ustr += ch;
      }
    }// so agar string abcabc thi to iske bad map mai woh abc bachega, distinct characters isliyecahiye kyuki hume distict hi selection karni hai 

    generateSelection(0, ustr, 0, k, ""); //k is kitni selections karni hai
  }


  public static void generateSelection(int i, String ustr, int ssf, int ts, String asf ) {
    if( i == ustr.length()){ // jab i unique string ki length ki barabr hojaye to 
       // hume sirf wahi print krne hai jisme selection so far == total selection
      if( ssf == ts){
          System.out.println(asf);
      }
      return;
    }
    
    // har character ke pas 2 options humko lo aur humko chhodado
    char ch= ustr.charAt(i);
    
    //pehle yes wali call
    generateSelection(i+1, ustr, ssf + 1, ts, asf+ch); // selection so far badh gyi aur asf ke andar yeh wala character add hogya
    
    // na wali call, na kehdiya iss call ne
    generateSelection(i+1, ustr, ssf + 0, ts, asf+""); // selection so far aur answer so far mai nhi add kiya
    
  }

}
