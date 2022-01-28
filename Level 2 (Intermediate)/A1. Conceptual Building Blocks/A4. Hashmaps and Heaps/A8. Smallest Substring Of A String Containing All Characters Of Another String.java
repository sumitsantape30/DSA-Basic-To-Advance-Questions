Smallest Substring Of A String Containing All Characters Of Another String

1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").
Input Format
Two strings s1 and s2
Output Format
A string

Constraints
1 <= length of string s1 and s2 <= 10000
Sample Input
timetopractice
toc
Sample Output
toprac

Code:

import java.util.*;

public class Main {

	public static String solution(String s1, String s2){
	    String ans = "";
	    
	    //string 2 ka map banayenge
	    HashMap<Character, Integer> map2 = HashMap<>();
	    for( int i=0; i < s2.length; i++){ // String 2 pe loop chalaya
	      char ch = s2.charAt(i);
	      map2.add(ch, map2.getOrDefault(ch, 0) + 1); // yeh frequency map banane ka tarika, pehlese character pda hai to uski frequency de dega aur nhi pdi hai to 0 dega usme 1 add kr rhe hai 
	    }
	    
	    int mct = 0 ;//matchcount initially 0 hai
	    int dmct = s2.length(); // desired matchount jo string 2 ki length le barabr hai, ki itne character match honge to bat banegi
	    
	    HashMap<Character, Integer> map1 = new HashMap<>(); //yeh string 1 ka map banane mai help karega
	    int i = -1;
	    int j = -1; //shuruwat mai i and j -1 pe hai
	    
	    
	    while(true){ 
	        //acquire, tabtak acquire krte hai jabtak matchcount sahi nhi hojata
	        
	        
	    }
	    
        
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
