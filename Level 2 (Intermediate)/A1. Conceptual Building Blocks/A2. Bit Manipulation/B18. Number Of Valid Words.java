Number Of Valid Words

1. You are given N number of words.
2. You are given M puzzles in the form of M strings.
3. For a given puzzle, a word is valid if both the following conditions are confirmed - 
    Condition 1 -> Word contains the first letter of puzzle.
    Condition 2 -> For each letter in word, that letter should be present in puzzle.
4. You have to print the number of valid words corresponding to a puzzle.
Input Format
A number N
N space separated strings
A number M
M space separated strings
Output Format
Check the sample ouput and question video.

  COMMENTConstraints
1 <= N <= 10^5
4 <= length of word <= 50
1 <= M <= 10^4
length of puzzle string = 7
puzzle string doesn't contain any repeated characters.
Sample Input
7
aaaa asas able ability actt actor access 
6
aboveyz abrodyz abslute absoryz actresz gaswxyz
Sample Output
aboveyz -> 1
abrodyz -> 1
abslute -> 3
absoryz -> 2
actresz -> 4
gaswxyz -> 0

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) { // words diye hai aur puzzles diye hue hai 
     HashMap<Character, ArrayList<Integer>> map = new HashMap<>() ; // ek hashmap banayenge character vs arraylist of integers ka
     
     for( int i=0; i< 26; i++){ // a se leke z tak sabke samne khali hashmap dal do
       map.put((char)('a' + i), new ArrayList<>()); // i= 0 hai to woh 'a' keliye stand kr rha hai to maine unke samne khali arraylist daldi. character mai typecast karenge aur a+i ko store karunga
     }
     
     //ab mai words uthaunga
     for(String word: words){
         // ab iss word ka mask banayenge, maks keliye iss word ke ekek character ko dekhna padege
         int mask = 0;
         for( char ch: word.toCharArray()){ // words ke character mai loop laga rha hu
        
           int bit = ch - 'a'; // character ko convert karunga bit mai
           mask = mask | ((1 << bit));
         }// so abhi humare words ka mask ban gya
         
         HashSet<Character> unique = new HashSet<>() ;// hume sare character nhi chahiye word ke hume bas unique wale chahiye duplicates nhi chahiye. agar abab hai to hume bas ekbar ab chahiye
         
         for( char ch: word.toCharArray()){
             
             if( unique.contains(ch)){ // agar woh character ko contain krta hai already continue hojaye kyuki woh character already pda hai
                 continue;
             }
             // aur agar yeh character pehli bar aaya hai to use unique mai krenge aur map mai bhi
             unique.add(ch);
             map.get(ch).add(mask); // ch wali arraylist get kari aur usme dal diya yeh mask
         }
         
     } 
     
     ArrayList<Integer> res = new ArrayList<>(); // myresult
     
     //ab hum puzzles pe jayenge
     for(String puzzle: puzzles){
         
         int pmask = 0; // isbar hum puzzle ka mask banayenge
         for( char ch: puzzle.toCharArray()){ 
        
           int bit = ch - 'a'; 
           pmask = pmask | ((1 << bit));
         }
         
         //iss puzzle ke corresponding konsa konsa word check hona chahiye, jo iss puzzle ka pehla character hai woh pta karo
         char fch = puzzle.charAt(0); // iss character against jo sare words hai hashmap mai woh test hone chahiye
         ArrayList<Integer> wordsToCheck = map.get(fch); //pehle character ke against jo words hai woh mile hai, muje unke sabke mask mil jayenge
         int count =0;
         
         for( int wmask : wordsToCheck){
             //woh part tha ki jo puzzle ka pehle character word mai hona chahiye woh check karne ki jarurat nhi hai woh check karneki jarurat nhi hai, hume bas check karna hai ki word ke care character puzzle mai hai and word ka bitmask apne hai hi
             
             if( (wmask & pmask) == wmask){ // agar word ka mask & puzzle ka mask word ke mask ke equal aya to yeh relevant word tha
                count++; // aisa hua to count ko badha do
             }
         }
         
         //count ko badhaya hai to usko myresult mai add kardenge
         res.add(count);
     }
     
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i < words.length; i++) {
      words[i] = scn.next();
    }
    int m = scn.nextInt();
    String[] puzzles = new String[m];
    for (int i = 0 ; i < m ; i++) {
      puzzles[i] = scn.next();
    }
    ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
    for (int i = 0 ; i < ans.size() ; i++) {
      System.out.println(puzzles[i] + " -> " + ans.get(i));
    }
  }

}
