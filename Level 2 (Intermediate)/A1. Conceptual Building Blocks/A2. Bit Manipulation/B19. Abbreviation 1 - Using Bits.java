Abbreviation 1 - Using Bits

1. You are given a word.
2. You have to generate all abbrevations of that word.
Note - Use bit manipulation
Input Format
A string representing a word
Output Format
Check the sample ouput and question video.

  COMMENTConstraints
1 <= length of string <= 32
Sample Input
pep
Sample Output
pep
pe1
p1p
p2
1ep
1e1
2p
3

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void solve(String str){
        
        for( int i=0; i< (1 << str.length()); i++){ // agar string ki length 3 hai to this is 1<<3, so 000001 hoga to woh 001000 banjayega, this is basically math.pow(2,str.length());
          //so hume unko bits ko analyse krna hai
          
          //pep hai to first p keliye bits mai extreme wali bit analyse hogi kyuki bits mai 210, right to left bits read hoti hai so yaha 0th character keliye 2th bit ko analyse karenge
          
          //ek stringbuilder aur ek count bana lete hai
          StringBuilder sb= new StringBuilder();
          int count=0;
          
          for( int j=0; j< str.length(); j++){
              
              int ch = str.charAt(j); // jth character bhi rakhenge
              int b = str.length() - 1 - j ;  // j keliye bit dusre end se analyse hogi
              
              // ab check karenge ki woh bit on hai ya off
              if((i & (1 << b)) == 0 ){ // yeh 0 aya to i ki bth bit off hai, off hai to hume woh character lena hota hai 
                if( count == 0){ //lekin lene se pehle dekhenge kya count 0 hai kya, agar count 0 hai to string builder mai sidha jth chracter append karlo
                 sb.append(ch);
                    
                }else{ // aur agar count kuch hai to pehle count append karo fir character append karo
                 sb.append(count);
                 sb.append(ch);
                 count=0; // aur fir count ko 0 pe set krde
                }
                  
              }else{ // else i ki woh bit on hai means 1 hai to hume sirf count badhana hota hai
                count++;
              }
          }
          
          //aise krte krte bahar ajayenge, aur last mai agar count bach jata hai to hum uss count kobhi append krdenge
          if( count > 0){
               sb.append(count);
          }
          
          System.out.println(sb);
          
        }
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}
