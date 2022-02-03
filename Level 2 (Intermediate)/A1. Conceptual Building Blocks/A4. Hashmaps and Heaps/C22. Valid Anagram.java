Valid Anagram

1. You are given two strings s1 and s2.
2. You have to determine if s2 is an anagram of s1.
Input Format
Two strings s1 and s2
Output Format
true/false

Constraints
1 <= length of string <= 10^5
Sample Input
pepcoding
codingpep
Sample Output
true

Code:

import java.util.*;

public class Main {

  public static boolean solution(String s1, String s2) {
    HashMap<Character, Integer> map = new HashMap<>();

    //string1 mai loop lagate hue isko bharenge
    for ( int i = 0; i < s1.length(); i++) {
      char ch = s1.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);//frequency badhani hai to getOrDefault function ka use karenge
    }

    //ab hum dusri string mai loop lagayenge
    for ( int i = 0; i < s2.length(); i++) {
      //ab hashmap se chize remove karneki koshish karenge
      char ch = s2.charAt(i);
      
      if(map.containsKey(ch) == false){ //agar yeh chracter map mai nhi hai to return false. character hi nhi hai to anagram nhi hoga
        return false;
      }else if ( map.get(ch) == 1) { //agar yeh character map mai hai aur uski frequency 1 hai to usko remove kardenge
        map.remove(ch);

      } else { //yaha aneka matlab hai ki character bhi hai aur frequency 1 bhi nhi hai to frequency 1 se kam hojayegi
        //otherwise uski frequency ek se kam kardi jaye
        map.put(ch, map.get(ch) - 1);
      }
    }
    
    return map.size() == 0; //agar map ka size 0 hogya hai to aap anagramic hai
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.next();
    String s2 = scn.next();
    System.out.println(solution(s1, s2));
  }

}
