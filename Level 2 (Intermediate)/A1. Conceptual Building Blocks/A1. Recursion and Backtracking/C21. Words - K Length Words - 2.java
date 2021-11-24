Words - K Length Words - 2

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
acd
ace
adb
adc
ade
aeb
aec
aed
bac
bad
bae
bca
bcd
bce
bda
bdc
bde
bea
bec
bed
cab
cad
cae
cba
cbd
cbe
cda
cdb
cde
cea
ceb
ced
dab
dac
dae
dba
dbc
dbe
dca
dcb
dce
dea
deb
dec
eab
eac
ead
eba
ebc
ebd
eca
ecb
ecd
eda
edb
edc

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords( int cs, int ts, String ustr, HashSet<Character> used, String asf){
      if( cs > ts){ // agar current spot total spot se bada hojaye means sare spots hogye apke to print krke return
        System.out.println(asf);
        return;
      }
      
      for( int i = 0; i< ustr.length(); i++){ // pehle spot pe place hone keliye sare characters ko mauka denge
          char ch= ustr.charAt(i);
          //iss character ko use kr skte or nhi use kr skte yeh ispe depend karega ki kahi yeh pehlese used to nhi hai
          if( used.contains(ch) == false){ // nhi contain krta to hum ise use kr skte hai
            used.add(ch); // so hashmap mai add krdo iss character ko aur call lagado
            generateWords(cs + 1, ts, ustr, used, asf + ch); // asf mai yeh character use krlo
            used.remove(ch);// wapas aate hue remove karenge taki jo character used ho chuka hai woh dubara use nhi hoga
              
          }
          
      }
     // so yaha slots ko box ki tarah use nhi kiya hai, slots ko item ki tarah use kiya hai ki pehle slot ko a ke sath map kare or b ke sath map kare or c ke sath map kare. slot ko item ki tarah use kiya gye hai
      
  }
 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    
    generateWords(1, k, ustr, new HashSet<>(), ""); // yeh hashset isliye hai ki konsa character use ho chuka hai. pehli bari mai pehle slot ki solving kr rhe hai hum ki konsa character dale tujhme

   
  }

}
