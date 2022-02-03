K Anagrams

1. You are given two strings s1, s2, and a number K.
2. You have to find if two strings are K-anagrams of each other or not.
3. Two strings are called K-anagrams if 
   -> Both s1 and s2 have the same number of characters.
   -> After changing K characters in any string, s1 and s2 become anagram of each other. 

Note -> Both s1 ad s2 consist of lowercase English letters only.
Input Format
Two strings s1 and s2
A number K
Output Format
true/false

Constraints
1 <= length of string s1 and s2 <= 20,000
1 <= K <= length of strings
Sample Input
fodr 
gork
2
Sample Output
true

Code:

import java.util.*;

public class Main {
	public static boolean areKAnagrams(String str1, String str2, int k) {
	    if( str1.length() != str2.length()){ //agar dono ki length equal nhi hai to waisebhi false hai fir woh k anagram nhi ho skte, hume sirf replace karna allowed hai add or remove krna allowed nhi hai
	        return false;
	    }
	    
		// pehli string ko parse krte hue hashmap banayenge
		HashMap<Character, Integer> map = new HashMap<>();
		for( int i =0 ;i < str1.length(); i++){ //aur pehle string pe loop laga diya
		    char ch = str1.charAt(i);
		    map.put(ch, map.getOrDefault(ch, 0)+ 1);
		}
		
		//ab dusre string pe loop lagayenge
		for( int i=0; i< str2.length(); i++){ //ab substract karenge
		    char ch = str2.charAt(i);
		    if( map.getOrDefault(ch, 0) > 0){ //agar yeh 0 se bada hai to ise use karenge
		      map.put(ch, map.get(ch) - 1); //agar hai to uski frequency ek se kam krde aur agar 0 ho chuka hai to hume kuch nhi karna 
		        
		    }
		}
		
		//fir last mai jitne bhi humare pas positive frequencies bach jayegi unka sum karlunga
		int count = 0;
		for(char ch: map.keySet()){
		    count += map.get(ch);// frequencies ko add krle
		}
		
		if( count > k){ //last mai agar yeh count apka greater than k hai to false hai aur less than equal to k hai to true hai
		    return false;
		}else{
		    return true;
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}
