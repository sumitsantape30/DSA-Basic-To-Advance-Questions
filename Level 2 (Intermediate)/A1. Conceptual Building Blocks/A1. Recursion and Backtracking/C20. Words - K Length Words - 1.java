Words - K Length Words - 1

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
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
acb
adb
aeb
acd
ace
adc
aec
ade
aed
bac
bad
bae
cab
dab
eab
cad
cae
dac
eac
dae
ead
bca
bda
bea
cba
dba
eba
cda
cea
dca
eca
dea
eda
bcd
bce
bdc
bec
bde
bed
cbd
cbe
dbc
ebc
dbe
ebd
cdb
ceb
dcb
ecb
deb
edb
cde
ced
dce
ecd
dec
edc

Code:

import java.io.*;
import java.util.*;

public class Main {

   // levels: characters, options: spots
  public static void generateWords( int cc, String ustr, int ssf, int ts, Character[] spots) { // cc: current character. spots array: konse spot pe konsa character aya

    if ( cc == ustr.length()) { // spots bharke aa rhe honge ab hum inn spots ko print karenge
      if ( ssf == ts) { // hum sirf tab print karenge jab ssf == total selections
        for ( int i = 0; i < spots.length; i++) {
          System.out.print(spots[i]);
        }
        System.out.println();
      }
       return;
    }

    char ch = ustr.charAt(cc); //current character ka faisla ho rha hai
    for ( int i = 0; i < spots.length; i++) { // iss character ke as pehla option hai ki koi bhi spot mai ajao
      if ( spots[i] == null) { // agar woh spot empty hai to apna current character rakhdenge waha
        spots[i] = ch;
        generateWords( cc + 1, ustr, ssf +1, ts, spots); // aur next character keliye call lagayenge
        spots[i] = null; // wapas aate hue null kardenge
      }
    }

    //iske bad no ki call, kyuki apke characters jada the aur spots kam the to character ke pas yeh option hai woh kiski spot pe na dale
    generateWords(cc + 1, ustr, ssf + 0, ts, spots); // ssf nhi badha kyuki koi spot pe dala hi nhi

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) { // string abcabc mili to humne usmese unique character nikal liye
      if (unique.contains(ch) == false) { // sorf unique characters ko hashet mai dala aur uniquestring mai dala
        unique.add(ch);
        ustr += ch;
      }
    }

    //jitne spots hai utne ka array bana lenge
    Character spots[] = new Character[k];
    generateWords(0, ustr, 0, k, spots);

  }

}
