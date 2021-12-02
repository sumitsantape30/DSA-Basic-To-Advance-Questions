All Palindromic Partitions

1. You are given a string of length n.
2. You have to partition the given string in such a way that every partition is a palindrome.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A String of length n
Output Format
Check the sample ouput and question video.
Question Video

Constraints
1 <= length of string <= 15
Sample Input
pep
Sample Output
(p) (e) (p) 
(pep) 

Code:

import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean isPalindrome(String str){
        int li = 0;
        int ri = str.length()-1;
        
        while( li < ri){
            char right = str.charAt(ri);
            char left = str.charAt(li);
            
            if(left != right){
                return false;
            }
            
            li++;
            ri--;
        }
        return true;
    }

	public static void solution(String str, String asf) {
	    if( str.length() == 0){
	        System.out.println(asf);
	        return;
	    }
	    
	    //string ke prefixes ko analyse karna hai 
	    for( int i=0; i< str.length(); i++){
	        //shuruwat mai i 0 pe hai to 0th character tak ka prefix muje nikalna hai 
	        String prefix = str.substring(0, i + 1); // iss o to i tak ke characters milenge i+1th character nhi milega
	        String ros = str.substring(i+1) ;// ros: rest of the string, 0 to i to apne kha liye to i+1 se end tak rest of the string hogi
	       
	        // ab tumhe check karna hoga ki kya yeh prefix palindromic hai ya nhi hai
	        if( isPalindrome(prefix)){
	            //agar yeh palindrome mila to hum ise call lagayenge nhito hum ise call nhi lagayenge 
	            solution(ros, asf + "(" + prefix + ") ");
	        }
	    }


	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

}
