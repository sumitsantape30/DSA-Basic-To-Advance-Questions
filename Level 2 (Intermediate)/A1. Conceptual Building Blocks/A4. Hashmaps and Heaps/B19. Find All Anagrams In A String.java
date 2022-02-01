Find All Anagrams In A String

1. You are given two strings s1 and s2.
2. You have to find the count of s2's anagrams that are present in s1.
3. Also, you have to print the start indices of such anagrams in s1.

Note -> Both s1 ad s2 consist of lowercase English letters only.
Input Format
Two strings s1 and s2
Output Format
A number(x) representing count of s2's anagrams which are present in s1.
X space separated numbers representing start indices of anagrams.

Constraints
1 <= length of string <= 20,000
Sample Input
cbaebabacd
abc
Sample Output
2
0 6 

Code:

import java.util.*;

public class Main {
	public static void findAnagrams(String s, String p) {
	    
	    //2 map banenge humare
	    HashMap<Character, Integer> smap = new HashMap<>(); //source map. source ka map to barbar banega usme jitni pattern ki length hai utni size ki sliding window chalegi aur utna map banta rahega
	    HashMap<Character, Integer> pmap = new HashMap<>();
	    
	    //pehle pattern ka map banate hai
	    for( int i=0; i < p.length(); i++){
	        char ch = p.charAt(i);
	        pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
	    }// to iss tarah se muje pattern ki frequency mil gyi
	    
	    //ab source se jitni badi pattern ki length hai utne source mai pehle acquire hoga
	    for( int i = 0; i < p.length(); i++){
	        char ch = s.charAt(i);
	        smap.put(ch, smap.getOrDefault(ch, 0) + 1);
	    }//so humne source ka bhi frequency map bana liya
	    
	    int i = p.length(); //i acquire krne ke kam ayega woh pattern.length pe hai, p.length ke chote tak ka kam hum kar chuke hai 
	    int count = 0;
	    String ans = "";
	    
	    while( i < s.length()){ //jabtak hum uske end tak nhi pohochte hum yeh window banake rakhenge
	      
	      if( compare(pmap, smap) == true){ //agar pattern map aur source map equal hai to count++
	          count++;
	          ans += (i - p.length()) + " ";//hume ans bhi print krna hai to isski position ans mai daldo, agar j rakhte to wahi i-p.length() hi hota
	      }
	      
	      //ab window apki aage sarakh rhi hai 
	      //to aap ith bande ko acquire karenge source map mai
	      char cha = s.charAt(i); //cha : ch for acquiring
	      smap.put(cha, smap.getOrDefault(cha, 0) + 1);
	      
	      //aur release karenge i se jitna pattern ki length hai utna piche wala character
	      char chr = s.charAt(i - p.length());//chr: character for release
	      if( smap.get(chr) == 1){ //agar apke andar iss character ki frequency 1 hai to isko hashmap sehi udao
	        smap.remove(chr);
	      }else{
	          //aur agar jada hai to use kam krdo
	        smap.put(chr, smap.get(chr) - 1);
	      }
	      
	      i++;
	    }
	    
	    //jo sabse last window hogi uska comparison nhi hojpayega, sabse last window jo hogi usko acquire krne ke bad comparision nhi hopayega to yeh comparison apko yaha bahar bhi karna padega
	      if( compare(pmap, smap) == true){ 
	          count++;
	          ans += (i - p.length()) + " ";
	      }
	      
	      //ab answer print karenge
	      System.out.println(count);
	      System.out.println(ans);
	}
	
	public static boolean compare( HashMap<Character, Integer> pmap, HashMap<Character, Integer> smap){
	    //apko check karna hai dono same hai ya nhi to ek ke keyset mai loop lagaye
	    for(char sch: smap.keySet()){ //smap ke keyset pe loop lagadiya
	        //ab muje check karna hai, pattern map mai yeh chracter hona chahiye aur uski frequency wahi honi chahiye jo source map mai hai ya nhi
	        if(pmap.getOrDefault(sch, 0) != smap.get(sch)){ 
	            return false;
	        }
	    }
	    //agar sare keyset keliye barabr nikal aaye to return true
	    return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}
