Longest Substring With Non Repeating Characters

1. You are given a string.
2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.
Input Format
A string
Output Format
A number representing the length of longest substring with unique characters.

Constraints
1 <= length of string <= 10^5
Sample Input
aabcbcdbca
Sample Output
4

Code:

import java.util.*;

public class Main {

  public static int solution(String str) {

    int ans = 0;
    int i = -1;
    int j = -1;
    HashMap<Character, Integer> map = new HashMap<>(); //yeh hashmap jisko mai frequency map ki tarah use karunga, jaisehi kisi character ki frequency 2 hojati hai hum invalid hojate hai. aur release krte hue jaisehi frequency 1 hojati hai hum valid hojate hai

    while ( true) {
        
        //iss loop se kab bahar niklenge uske liye yeh 2 flags le rhe hai
      boolean f1 = false;
      boolean f2 = false;

      //acquire
      while ( i < str.length() - 1 ) { //acquire till i is less than str.length-1 and we are valid
        f1 = true; //jaisehi iss loop ko enter kiya to false ko true kardenge
       
        //i badhao aur character ko nikalke
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1); //frequency badhayi character ki

        if(map.get(ch) == 2) { //yeh character ki frequency badhake kahi 2 to nhi hogyi, 2 hogyi hai to tum invalid hogye ho break krdo
          break;
        } else {
          //aur agar valid ho
          int len = i - j; //length nikalo
          if(len > ans) { //kya yeh length pichle answer se badi hai to ans ko update krdo
            ans = len;
          }
        }
      }

      //agar invalid hoke tum yaha pohochte ho to release krna hai
      while ( j < i) { //tabtak release krenge jabtak j i se chota hai
        f2 = true; //jaisehi iss loop mai enter kiya to false ko true kardenge
        
        //j ko badhao aur charcter get karo aur release krdo
        j++;
        char ch = str.charAt(j);
        map.put(ch, map.get(ch) - 1); //character ki frequency ek se kam kardi

        //frequency kam krne ke bad kya tumne iski frequency 1 kardi kya
        if(map.get(ch) == 1){ //1 hogi hai to sab thik hai valid kardiya isko
          break; //tumne valid bana diya hai to tum break kr skte ho
        }//agar iski frequency tumne 1 nhi banayi matlab invalid hai to chalte rahega
      }
      
      if( f1 == false && f2 == false){ //agar donobhi false reh gye matlab mai koi bhi loop mai nhi ja rha
        break;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

}
