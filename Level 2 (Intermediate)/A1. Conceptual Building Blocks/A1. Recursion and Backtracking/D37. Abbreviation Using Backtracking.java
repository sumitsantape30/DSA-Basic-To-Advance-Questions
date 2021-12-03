Abbreviation Using Backtracking

1. You are given a word.
2. You have to generate all abbrevations of that word.

Use recursion as suggested in question video
Input Format
A string representing a word
Output Format
Check the sample ouput and question video.
Question Video

Constraints
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

    public static void solution(String str, String asf,int count, int pos){
        if( pos == str.length()){
            if( count == 0){ //count 0 hai to answer so far print karenge
                System.out.println(asf);
            }else{ //agar count 0 nhi hai to apko answer mai count bhi jodna padega
                System.out.println(asf + count);
            }
            return; 
        }
        
        if( count > 0){ // agar count >0 hai to hum count add karke settle karenge
            solution(str, asf + count + str.charAt(pos), 0, pos + 1); //apka answer chalkar aa rha hota hai apke pas count hota hai aur character hota hai teeno chize settle karna pdta hai (purana ans + count + character).  iss case mai count 0 hojayega kyuki you are saying yes, aur position to harbar badhti hai 
        }else{ // agar count hai hi nhi to asf mai kyahi add karenge
            solution(str, asf + str.charAt(pos), 0, pos + 1);
        }

        solution(str, asf, count + 1, pos + 1); // no ki call hai answer so far mai kuchnhi badlega, no bola hai to count badh jayega
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
    }
    
    
}

//================================================================= JBs===============================================

import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, int idx, int count, String asf){
        if( idx == str.length()){ // agar index badhte badhte str.length pe pahuch gya means sare characters ka faisla hogya to apna answer print karke return
          if( count > 0){ // count > 0 hai to asf mai count ki value add karke fir print karo
            System.out.println(asf + count);
            
          }else{ //agar count ki value 0 hi pohochti hai to sidha answer print kardo
            System.out.println(asf);
          }
          return;
        }

      solution(str, idx + 1, 0, count > 0? asf + count + str.charAt(idx) : asf + str.charAt(idx)); // idx ka faisla hogya hai so idx+1 pe chaliye, agar count ki value grater than 0 hai to asf mai count bhi add hoga aur current character bhi add hoga nhi sirf yeh character ass hoga asf mai.
      solution(str, idx + 1, count + 1, asf);// jo woh bolta hai ki woh 1 ki tarah ana chahta hai to mai count badhake bhej dunga bas aur asf mai kuch bhi add nhi kiya
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, 0, 0, "");
    }
    
    
}
