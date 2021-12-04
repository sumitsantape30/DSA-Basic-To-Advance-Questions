Largest Number Possible After At Most K Swaps

1. You are given a string which represents digits of a number.
2. You have to create the maximum number by performing at-most k swap operations on its digits.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A string S and a number K
Output Format
A number

Constraints
1 <= length of S <= 30
1 <= K <= 10
Sample Input
1234567
4
Sample Output
7654321

Code:

import java.io.*;
import java.util.*;

public class Main {
    
    public static String swap(String str, int i, int j){
        
        char ith = str.charAt(i); 
        char jth = str.charAt(j);
        
        String left = str.substring(0, i); //isme i include nhi hoga
        String middle = str.substring(i + 1, j); //middle part i ke bad start ho rha hai aur j se pehle khatam hai
        String right = str.substring(j + 1); // j+1 se end tak
        
        return left + jth + middle + ith + right; 
    }

	static String max;
	public static void findMaximum(String str, int k) {
        
        if(Integer.parseInt(str) > Integer.parseInt(max)){ //yeh jo nayi string aap leke aaye ho agar woh max se bada hai to max mai yeh string pakdle
            max = str;
        }
        
        if(k == 0){ // k = 0 ka matlab hai there are no more swaps allowed
            return;
        }
        
        //yeh hai mere options hai 
        for(int i = 0; i < str.length() - 1; i++){ // sare characters pe jaunga, last character pr nhi jaunga kyuki j humesha i se aage hone chahiye
          for(int j = i + 1; j < str.length(); j++){ // j i+1 se start hoga, j is always to the right of i.
              if(str.charAt(j) > str.charAt(i)){ // agar j wala char bada hua i wale char se (char apne ascii pe compare honge) to hum swap karenge
                String swapped = swap(str, i, j); // swap karke ek nayi string ayegi
                //swap kiya ab call laga denge
                findMaximum(swapped, k - 1);// swapped string pass karenge aur k-1 ki ab itne swaps apne pas possible hai
                //iss case mai backtrack karke wapas string ko thik karne ki jarurat nhi hai jo change aya tha woh maine swapped mai pkda tha aur wahi call krte waqt pass kiya tha, string mai koi change hua nhi actually
              }
          }
        }
    
  /*      for(int i = 0; i < str.length() - 1; i++){ 
          for(int j = i + 1; j < str.length(); j++){ 
              if(str.charAt(j) > str.charAt(i)){ 
                str = swap(arr, i, j); 
                findMaximum(str, k - 1);
                str = swap(arr, i, j); // yahape string ko wapas pehle jaise banao, to dubara se i,j ko swap karlo. 2 bar swap honge to dubara wahi ban jayenge jo the
              }
          }
        }       */
        
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}
