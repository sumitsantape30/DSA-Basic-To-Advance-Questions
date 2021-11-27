Cryptarithmetic

1. You are given three strings s1, s2 and s3.
2. First two are supposed to add and form third. s1 + s2 = s3
3. You have to map each individual character to a digit, so that the above equation holds true.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing the signature. The judge can't force you but intends you to teach a concept.
Input Format
Three strings
s1
s2
s3
Output Format
Check the sample output and question video

Constraints
1 <= length of s1,s2,s3 <= 10
Sample Input
team
pep
toppr
Sample Output
a-3 e-9 m-4 o-1 p-2 r-6 t-0 
a-3 e-9 m-5 o-1 p-2 r-7 t-0 
a-3 e-9 m-6 o-1 p-2 r-8 t-0 
a-4 e-9 m-2 o-1 p-3 r-5 t-0 
a-4 e-9 m-5 o-1 p-3 r-8 t-0 
a-5 e-9 m-2 o-1 p-4 r-6 t-0 
a-5 e-9 m-3 o-1 p-4 r-7 t-0 
a-6 e-9 m-2 o-1 p-5 r-7 t-0 
a-6 e-9 m-3 o-1 p-5 r-8 t-0 
a-7 e-9 m-2 o-1 p-6 r-8 t-0 

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();
    // 3 string input liye

    HashMap<Character, Integer> charIntMap = new HashMap<>(); // yeh woh hashmap hai jisme character ko interger ke sath map krna hai, isme sare unique characters ayenge
    String unique = "";
    for (int i = 0; i < s1.length(); i++) { // string 1 mai loop lagaya aur agar hashmap yeh characters contain nhi krti hai to inko hashmap mai dal diya
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1); // iss hashmap mai basically sare unique characters ajayenge aur unke samne -1 dala means yeh character abhi mapped nhi hai
        unique += s1.charAt(i); // iss unique string ke andar teeno string ke unique characters ajayenge
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10]; // used numbers ka boolean array hai, 10 size ka hai to 0 to 9 index honge, abhi har index pe false pda hai yeh indicate krta hai ki yeh number abhi used nhi hua hai, jab kisi digit ko map/use krloge to use true krdena ki yeh use ho chuki hai 
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }
   
  public static int getNum( String s, HashMap<Character, Integer> charIntMap){ // hashamp mai har character ko uski digit se replace krna hai aur interger.parseint karna hai
    String num = "";
    
    for( int i=0; i< s.length(); i++){
        num += charIntMap.get(s.charAt(i)); // string ka character uthaya, uss character ke against hashmap mai konsi digit pdi hai woh iss num nam ki string mai daldi
    }
    
    //num nam ki string generate hogyi but muje integer return karna hai 
    return Integer.parseInt(num);
      
  }
  
  public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, String s1, String s2, String s3) {
      if( idx == unique.length()){ // aise rkte rkte tumhara index unique ki length pe pahuchega, unique string ka last character unique.length()-1 pe hai aur tum unique.length() pe pahuch gye means sare mapped hogye but jaruri nhi hai ki isse s1+s2=s3 hoga. 
        int num1 = getNum(s1, charIntMap); //mapping ke anusare number mangwayenge, ki bta tere mapping ke hisab se s1 konsa number hai
        int num2 = getNum(s2, charIntMap); // aisahi string 2 ke sath karenge ki konsa number ho tum
        int num3 = getNum(s3, charIntMap);
        
        if( num1 + num2 == num3){ // agar aisa hua to print karke return karenge
            //hasmap mai characters ke samne mapping ho rakhi hai woh print karenge, order mai print karenge a>b>c>...
            for( int i=0; i< 26; i++){
                char ch = (char)('a' + i);
                //pehle check karunga kya yeh character apne hashmap hai ya nhi
                if( charIntMap.containsKey(ch)){// agar hai to print karenge woh character aur woh jis digit ke sath map hua th
                   System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                }
            }
            System.out.println(); // jab ek pura print hojaye to agle pe jane se pehle newline
        }
        return;
      }
      
     // so hume yaha uniqeue string mili hai uska idx character solve karna hai 
     char ch= unique.charAt(idx); // yeh wala char solve karna hai
     for( int num =0; num<= 9; num++){ // isme mere pas 0 to 9 sare options hai, yeh potential numbers/options hai 
       if( usedNumbers[num] == false){ // agar usedNumbers mai iske samne false pda hai tabhi isko usr kr skte hai
         charIntMap.put(ch, num); // hashmap mai iss character ke samne apna number put krdo
         usedNumbers[num] = true; // usednumbers mai dal do true ki used karliya
         solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3); // next character keliye call lagadi
         //backtrack krte hue inn numbers ko free karenge
         usedNumbers[num] = false; //this is not used anymore aise mark kardiya
         charIntMap.put(ch, -1); // wapas aate hue bola ki this character is not mapped
       }
         
     }

  }

}
