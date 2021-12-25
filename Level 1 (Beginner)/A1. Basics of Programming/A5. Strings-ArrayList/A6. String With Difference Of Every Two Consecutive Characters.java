String With Difference Of Every Two Consecutive Characters

1. You are given a string that contains only lowercase and uppercase alphabets. 
2. You have to form a string that contains the difference of ASCII values of every two consecutive characters between those characters.
   For "abecd", the answer should be "a1b3e-2c1d", as 
   'b'-'a' = 1
   'e'-'b' = 3
   'c'-'e' = -2
   'd'-'c' = 1
Input Format
A String
Output Format
A String

Constraints
1 <= length of string <= 1000
Sample Input
pepCODinG
Sample Output
p-11e11p-45C12O-11D37i5n-39G

Code:
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;
class HelloWorld {
    
    public static String takeInput() {
		
		Scanner s= new Scanner(System.in);
		String str= s.next();
		return str;
	}

	//JB's
	public static void solution2(String str) {
		String ans= "";
		ans += str.charAt(0);
		
		for( int i=1; i< str.length(); i++) {
			
			int diff= str.charAt(i) - str.charAt(i-1);
			
			ans += ""+ diff + str.charAt(i);
		}
		
		System.out.println(ans);
	}
	
	public static String Solution( String str) {
		//hume string form mai return karna hai
		//sbase pehle stringbuilder banayenge, kyuki append karne pr string builder better perform deta hai string ke comparative
		StringBuilder sb= new StringBuilder();
		//isme mai pehlehi string ka 0th character dal dunga
		sb.append(str.charAt(0));
		
		// loop 1st index se start hoga and ab mai dekhunga iske aur piche wale ka ascii ka gap nikalunga and then ans mai woh gap bhi dalunga and current wala character bhi
		for( int i=1; i< str.length(); i++){
		    char curr= str.charAt(i);
		    char prev= str.charAt(i-1);
		    //ab inka gap nikalenge
		    int gap= curr-prev;
		    
		    //ab yeh gap string builder mai append karenge
		    // pehle gap append hoga and then current character bhi
		    sb.append(gap);
		    sb.append(curr);
		}
		//last mai string builder ko tostring mai convert karke return
		return sb.toString();
	}
    
    public static void main(String[] args) {
        String str= takeInput();
        System.out.println(Solution(str));
    }
}
