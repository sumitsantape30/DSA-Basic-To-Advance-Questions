Pattern Matching

1. You are given a string and a pattern. 
2. You've to check if the string is of the same structure as pattern without using any regular 
     expressions.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A String str
A pattern ptr
Output Format
Check the sample ouput and question video.

Constraints
1 <= length of str,ptr <= 20
Sample Input
graphtreesgraph
pep
Sample Output
p -> graph, e -> trees, . 

Code:

import java.io.*;
import java.util.*;

public class Main {

  //levels pe rakh rhe hai pattern ke character ki pattern ka p kiske sath map ho rha hai, pattern ka e kiske sath map ho rha hai... aur options mai rakh rha hu ki kitne subprefix ke sath map ho rha hai
  public static void solution(String str, String pattern, HashMap<Character, String> map, String op) { // orignal pattern(op) isliye pass kiye taki mai given order mai print kar saku, woh character print kar saku jo pattern mai pehle hai
    if( pattern.length() == 0){ // aise krte krte pattern ki length 0 hojayegi matlab pattern sara ka sara mapped hochuka hai
      //yaha aur string ki length bhi 0 hojani chahiye
      
       if( str.length() == 0 ){
           
          HashSet<Character> alreadyPrinted = new HashSet<>(); //pattern mai tha "pep" magar sample output sirf 'p' aur 'e' keliye print kiya hai dusre 'p' keliye print hi nhi kiya to hume bhi barbar print nhi karna, dublicate keliye print nhi karna to ek hashset rakhunga ki kon print ho chuka hai.
          for( int i = 0; i < op.length(); i++){
              char ch= op.charAt(i);
              if(alreadyPrinted.contains(ch) == false){ //agar woh already printed nhi hai means yeh contain nhi krta to character ko we'll print aur fir usko alreadyPrinted mai add karlenge ki yeh print hochuka
                System.out.print(ch + " -> " + map.get(ch) + ", "); // character ke samne uska map print karenge
                alreadyPrinted.add(ch);
              }
          }
          
          System.out.println(".");
          
      }
        return;
    }

    char ch = pattern.charAt(0); //pattern ka pehle character nikala
    String rop = pattern.substring(1); // rest of the pattern, pattern mese ek banda nikala aur baki pattern bach jayega

    if (map.containsKey(ch)) { //ab mai check karunga kya mera map already isko contain krta hai, already contain krta hai to map ho rakha hai pehlese
      //agar already mapped hai to tum yeh nikalo kiske sath mapped tha
      String previousMapping = map.get(ch); // previous mapping mil gyi isse
      
      //ab tum dekho tumhari string ke andar agle kuch character previous mapping ke barabr hai ya nhi hai
      
      //pehele yeh check karo string mai utne characters hai bhi jitni yeh previous mapping thi, kahi string choti to nhi pd gyi
      if( str.length() >= previousMapping.length() ){
          String left = str.substring(0, previousMapping.length());
          String right = str.substring(previousMapping.length());
          if( previousMapping.equals(left)){ //previos mapping aur abhi jo left part hai woh equal hai ki nhi 
            //agar equal hai to badhiya hai aage call chal skti hai
             solution(right, rop, map, op); 
          }
      }

    } else { //agar nhi contain krta hai to hume map karna hai
      for ( int i = 0; i < str.length(); i++) { // hume map krna hai to string pe loop ghuayenge
        //hume upar character ch pattern mese nikala hai aur abhi hum string pe loop laga rhe hai ki iss pattern ke pehle character ko string ke kis chiz ke sath map kiya jaye
        String left = str.substring(0, i + 1); //left part, yeh prefix nikala
        String right = str.substring( i + 1 ); //right part, prefix nikalne ke bad string bhi choti hojayegi, i + 1 se leke end tak ki string
                       map.put(ch, left); // character ko left(prefix) ke sath map kardiya, puri string mese left hissa nikal jayega to right hissa bachega to right wala function mai pass karenge
        solution(right, rop, map, op);
        map.remove(ch); // wapas aate hue remove krdo jo map mai dala tha
      }
    }
  }
 //agar character pehlese mapped nhi hai to tum alag alag left part ke sath use map kar karke call lagaoge, agar woh pehlese mapped hai to tum woh previos mapping nikaloge aur dekhoge string ekandar shuruwat mai wahi pda hai ki nhi pda hai 
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    String pattern = scn.next();
    HashMap<Character, String> map = new HashMap<>();
    solution(str, pattern, map, pattern);
  }
}
