Longest Substring With At Most K Unique Characters

1. You are given a string(str) and a number K.
2. You have to find the length of longest substring of the given string that contains at most K unique characters.
Input Format
A string
A number
Output Format
A number representing the length of longest substring with at most K unique characters.

Constraints
1 <= length of string <= 10^5
1 <= K <= 26
Sample Input
aabcbcdbca
2
Sample Output
4

Code:

import java.util.*;

public class Main {

	public static int solution(String str, int k) {
	    int ans = 0;
	    
	    int i = -1; //acquire krne wala hai yeh
	    int j = -1; //release krne wala hai
	    
	    HashMap<Character, Integer> map = new HashMap<>(); //yeh frequency map hai
	    
	    while( true){
	        boolean f1 = false;
	        boolean f2 = false;
	        
	        //acquire
	        while( i < str.length() - 1){
	            f1 = true;
	            
	            //andar aaye aur i ko badhaye
	            i++;
	            char ch = str.charAt(i);//yeh character liya isko acquire krlenge
	            map.put(ch, map.getOrDefault(ch, 0) + 1);
	            
	            //agar apka map ka size less than equal to k hai to sab thik hai
	            if( map.size() <= k ){
	                int len = i - j; //length
	                if( len > ans){ //aur agar yeh length ans se badi hai to ans mai length dal de
	                  ans = len;
	                }
	            }else{
	                //agar aap grater than equal to k hogye hai to break karjaye coz aap invalid hogye hai
	                break;
	            }
	        }
	        
	        //ab release krne ka kam
	        while( j < i){ 
	            f2 = true;
	            
	            j++;
	            char ch = str.charAt(j);
	            //ab release krne mai chakkar hai
	            if(map.get(ch) == 1){ //agar uski frequency ek hai to woh frequency kam nhi karata woh remove hojata hai hashmap se
	              map.remove(ch);
	            }else{
	                //agar uski frequency jada hai to uski frequency 1 se kam kardenge
	                map.put(ch, map.get(ch) - 1);
	            }
	            
	            //aisa karne ke bad agar map.size abhibhi grater than k hai continue kare abhibhi invalid hai
	            if( map.size() > k ){
	                continue;
	            }else{
	                //agar aap equal to hojate hai to aap valid hogye hai break karenge
	                int len = i - j; 
	                if( len > ans){ 
	                  ans = len;
	                }
	                break; //break karenge kyuki wapas acquire karna start karenge
	            }
	            
	        }
	        
	        if( f1 == false && f2 == false){
	            break;
	        }
	    }
        
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
