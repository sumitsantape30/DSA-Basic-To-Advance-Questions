Words - K Selection - 3

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k characters out of the word.

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

  public static void fun(String str, HashMap<Character, Integer> fmap, int idx, String asf, int k){
      
      if( k < 0){ //agar k negative hojata hai, jitne select karne the use jada select karliye to wahase apko answer nhi milne wala laut jao
        return;
      }
      
      if( idx == str.length()){ // jab aap sare characters ka faisla krlete ho to uss time i'll check 
        if( k == 0){ //basecase: agar k ki value 0 hojati hai to print kardenge
         System.out.println(asf);
       }
       return;
      }
      
      //maine pehle option diya ki 'a' ki kitni frequency hai, lets say 4 hai to 'a' 4 bar banke aa skta hai then 3,2,1 aur fir ho skta hai ki 'a' select hi na ho means 0 times aaye
      char ch= str.charAt(idx);
      
      for( int i= fmap.get(ch); i >=0 ; i--){ //iss character ki jitni frquency hogi max utni times yeh character aa skta hai aur minimum 0 times
        String s = "";
        for( int j=0; j< i; j++){
            s += ch; // iss string mai mai uss character ko bar babr add krta hu, agar frequnecy 5 thi to maine 'a' ko 5 times add karliya
        } // string merepas tayar hogyi now i'll make a call
        
        fun(str, fmap, idx + 1, asf + s, k - i); //current bande ka faisla ho chuka hai to index ko +1 karke pass kiya. fir jo string aapne tayar kithi usko asf mai add kardiya. aur k ki value ko i se decrease kardenge kyuki i number of times aapne character add kiya hai
          
      }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>(); // unique characters ka hashmap jiske andar frequency stored karenge
    String ustr = ""; // unique string bana rakhi hai 
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    } // so humne frequency store karli

     fun(ustr, unique, 0, "", k); // idx is abhi hum konse character ka faisla hum kr rhe hai uske liye index rakhliya. and asf will be blank
  }

}

//===============================Another Approach==============================================================

 public static void fun1(String str, HashMap<Character, Integer> fmap, int idx, String asf, int k){
      
      if( k < 0){ 
        return;
      }
      
      if( idx == str.length()){ 
        if( k == 0){ 
         System.out.println(asf);
       }
       return;
      }
      
      char ch= str.charAt(idx);
      
      //maine character nikala aur agar is character ki frequency grater than 0 hai to uske pas aane/select honeka ka mauka hoga
      if( fmap.get(ch) > 0){
          //agar woh select hona chahta hai to use ekbar use karlunga
          fmap.put(ch, fmap.get(ch) - 1); // us character ki frequency ek se kam krlena
          //fir lagayenge recursive call
          fun1(str, fmap, idx, asf+ ch, k -1); //woh select hona chahta hai to hum usi character ko dubar mauke dete hai isliye idx hi pass kiye idx+1 nhi kiya. asf mai character add karenge aur k ki value will decremented by 1
          //wapas aate hue yeh frequency dubara thik karni hogi
          fmap.put(ch, fmap.get(ch)-1);
      } // yh hogyi ha ki call
      
      //agar woh select nhi hona chahta
      fun1(str, fmap, idx+1, asf, k); //index will get incremented by one, asf mai kuch bhi add nhi hoga aur k pe koi farak nhi ayega
      
  }
