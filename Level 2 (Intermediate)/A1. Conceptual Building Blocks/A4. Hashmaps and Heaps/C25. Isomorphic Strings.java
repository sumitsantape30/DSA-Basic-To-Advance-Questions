Isomorphic Strings

1. You are given two strings s1 and s2.
2. You have to determine if they are isomorphic or not.
3. Two strings are called isomorphic if -
   -> Every character of s1 can be mapped with characters of s2.
   -> A character of s1 can be mapped to only one character.
   -> All occurrences of a character must be replaced with another character while preserving the order of characters.

Note -> Length of s1 is equal to the length of s2.
Input Format
Two strings s1 and s2
Output Format
true/false

Constraints
1 <= length of strings <= 1000
Sample Input
pepcoding
sosherlok
Sample Output
false

Code:

import java.util.*;

public class Main {

	public static boolean isIsomorphic(String s, String t) {
	    
	    if(s.length() != t.length()){ //agar donoki length barbar nhi hai to hum wahise laut jayenge
	        return false;
	    }
	    
	    HashMap<Character, Character> map1 = new HashMap<>();//yeh map banaya hai string1 ke characters ko string2 ke characters ke sath map karne keliye
	    //aur dusra hashmap mai isliye banaunga yeh dekhne keliye ki String2 ka character bacha bhi hai use karne keliye
	    HashMap<Character, Boolean> map2 = new HashMap<>();
	    
	    for( int i = 0; i< s.length(); i++){
	        //ab donomese character nikal liya jaye
	        char ch1 = s.charAt(i);
	        char ch2 = t.charAt(i);
	        
	        //ab dekhenge kya map1 ke andar mapped hai already 
	        if( map1.containsKey(ch1) == true){ //kya character already usme hai matlab woh kisina kisi target ke character ke sath woh mapped hoga ab hume yeh dekhna hai ki woh kiske sath mapped hai jiske sath mapped hai woh ch2 hi hai ki nhi hai, agar woh ch2 ke sath mapped nhi hai to gadbad hogyi
	          if( map1.get(ch1) != ch2){
	              return false;
	          }
	        }else{//agar woh mapped hi nhi hai abhi to usko map kr skte hai but uske liye ch2 ka unused hona jaruri hai 
	          if( map2.containsKey(ch2) == true){ //agar map2 ne use already use kr rakha hai means woh unused nhi hai to return false hoga
	            return false;
	          }else{
	              //agar woh map2 mai contain nhi hua to map1 mai bolenge ki ch1 ko ch2 ke sath map kiya jata hai aur map2 mai yeh bolenge ki ch2 use hogya hai
	              map1.put(ch1, ch2);
	              map2.put(ch2, true);
	          }
	            
	        }
	    }
	    
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
	}

}
