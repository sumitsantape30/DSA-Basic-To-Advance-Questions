Toggle Case

1. You are given a string that contains only lowercase and uppercase alphabets. 
2. You have to toggle the case of every character of the given string.
Input Format
A String
Output Format
A String

Constraints
1 <= length of string <= 1000
Sample Input
pepCODinG
Sample Output
PEPcodINg

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
	
	public static String toggle( String str) {
		
		// hume character change krne hai to string form mai to change ho nhi payenge so hum unko string builder mai le lenge
		StringBuilder sb= new StringBuilder(str);
		
		for( int i=0; i< sb.length(); i++){
		    // sabe pehle character nikalunga
		    char ch= sb.charAt(i);
		    
		    //ab dekhunga yeh character upper case hai ya lower case
		    if( ch >= 'a' && ch<= 'z'){ //agar woh character small a and small z ke bich mai hai to woh lower case hai
		    //ab jo lower case hai uska upper case chahiye muje
		    char uch= (char)('A' + ch - 'a');  // uppercase chahiye to woh capital A mai add hoga, kya add hoga? jitna A character small a se aage hai, and character ko + - kiya to intergers hojate hai isliye wapas char mai typecaste karna padega 
		    //ab mai iss upper character ko string builder mai wapas set kardunga
		    sb.setCharAt(i, uch);
		        
		    }else if( ch >= 'A' && ch <= 'Z'){ //otherwise woh uppercase ka hoga
		    // agar woh character capital A and Z ke bich mai hai means woh capital hai, capital hai to lower case mai lana padega
		    char lch= (char)('a' + ch - 'A'); //lower case mai lane keliye mai character mese capital a minus karunga and yahi gap add karunga small a mai 
		     sb.setCharAt(i, lch);
		    }
		}
		//return krte waqt mai string builder pe toString method call karke usko string mai convert karlenge 
		return sb.toString();
	}
	
	public static String togeeleCase( String str) {
		
		StringBuilder sb= new StringBuilder();
		
		for( int i=0; i< sb.length(); i++) {
			
			char ch= str.charAt(i);
			if( ch >= 'a' && ch <= 'z') {
				// small case hai to usko append karenge
				sb.append((char)(ch - 'a' + 'A')); // small case hai to small 'a' minus karenge aur capital 'A' add karenge
				
			}else { //upper case hota hai to
				sb.append((char)(ch - 'A' + 'a')); // capital case hai to capital 'A' minus karenge aur small 'a' add karenge
			}
		}
		return sb.toString();
	}
    
    public static void main(String[] args) {
        String str= takeInput();
        System.out.println(toggle(str));
    }
}
