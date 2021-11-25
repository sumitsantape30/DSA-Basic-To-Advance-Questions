Words - K Length Words - 3

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
baa
abb
bab
bba

Code:

import java.io.*;
import java.util.*;

public class Main {

 public static void fun(String str, HashMap<Character, Integer> map, int idx, Character[] spots, int ssf, int ts){ // idx means jiska failsa hum abhi kr rhe hai 
     if( idx == str.length()){ // jab sabka failsa hojaye jab index string.length() pe pohoch jaye to yahase hum karenge return apna answer print krte hue
      if( ssf == ts){ //jab sabka faisla hojaye to mai check karunga selection so far total selection ke equal hai to hume apne answer print karna chahiye
       for( int i=0; i< spots.length; i++){
           System.out.print(spots[i]);
       }
         System.out.println();
      }
      return;
     }
     
     //sabse pehle first character ka faisla hoga ki woh kaha kahape aa skta hai
     char ch= str.charAt(idx); // character nikal lo
     int lo = map.get(ch);// fir iss character ki last occurrence nikal lo
     
     //options ki agar yeh select hona chahta hai to yeh kis kis spot pe aa skta hai
     for( int i = lo+1; i < spots.length; i++){ // i ki value last occurrence + 1 se start hogi, itne options hai iske pas
       if( spots[i] == null){ // agar iss spot pe null pda hai, jab kiski character ne usko occupy nhi kara hai to hum usko occupy krlenge
         spots[i] = ch;
         map.put(ch, i);//yeh charcter ith spot ke upar aachuka hai to iski last occurrence ko update karna padega. ki meri last occurence i hai
         //bakiyo keliye recursive call
         fun( str, map, idx+1, spots, ssf+1, ts); // selection ek se badha hai
         //wapas aate time jo change aap laya the unko undo karna padega
         spots[i] = null; // upar jate hue character store kiya tha aate hue null store kardenge
         map.put(ch, lo); // wapas aate time uski last occurence dubara purani wali dal do
       }
     } // so yeh hogya ki woh agar answer ka part banna chahta hai to konse spot ke upar ayega
     
     // yeh bhi option hai ki agar woh character select nhi hona chahta
       if(lo == -1){ // na wali call tabhi lagti hai jab last occurence -1 hogi
           fun( str, map, idx+1, spots, ssf+0, ts);
       }
 }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    // hume last occurrence wala hashmap chahiye hoga
    HashMap<Character, Integer> map = new HashMap<>(); 
   
    for( int i=0; i< str.length(); i++){
        char ch= str.charAt(i);
        map.put(ch, -1); // map mai har character ke samne -1 put kardenge
        // bolenge starting mai sabki last occurrence -1 hai
    }
    
    fun(str, map, 0, new Character[k], 0, k); // spots ka array banayenge of size k kyuki k spots hai
   
  }

}
