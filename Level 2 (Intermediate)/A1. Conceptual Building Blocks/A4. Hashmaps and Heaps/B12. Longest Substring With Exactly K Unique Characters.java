Longest Substring With Exactly K Unique Characters

1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
Input Format
A string
Output Format
A number representing length of the longest K unique characters substring.

Constraints
1 <= length of string <= 10^5
1 <= k <= 26
Sample Input
aabcbcdbca
2
Sample Output
4

Code:

import java.util.*;

public class Main {

	public static int solution(String str, int k){
        //hume chahiye longest substring jisme 2 unique characters ho
        int ans = 0;
        
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();//iss hashmap mai characters ki frequency rakhenge
        
        while( true){
            //loop se nikalne keliye flags
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire
            while( i < str.length() - 1){
                f1 = true; //iss loop mai ghuste hi flag1 ko true krdenge
                
                //i badhao, character lo aur frequency badhado
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                //ab dekhna hai kya map ka size less than k hai
                if( map.size() < k){ //agar map ka size less than k hai means abhi k unique characters nhi aaye hai apke pas to continue
                  continue;
                }else if( map.size() == k){ //kya map ka size k hogya hai agar bangya hai to yeh ek  answer ban gya hai potentially
                  int len = i - j; //length hogi i-j
                  if( len > ans){ // agar yeh length answer ki length se lambi hai to answer ko update krle
                    ans = len;
                  }
                    
                }else{ //ab tisri bat ho skti hai ya to size less than k hoga, ya equal to k hoga or k se bada hoga, k se jada hogya to invalid hogya jada characters aagye apkpe pas
                 break;
                }
            }
            
            //release krna start krde
            while( j < i){ //jabtak j is less than i tabtak release hoga
                f2 = true; //flag2 ko true kardenge iss loop mai atehi
                
                j++;
                char ch = str.charAt(j);
                if( map.get(ch) == 1){ //agar character ki frequency 1 hai to usko remove krna hoga
                    map.remove(ch);
                }else{ //else map mai iski frequency kam karni hogi
                    map.put(ch, map.get(ch) - 1);
                }
                
                //ab release krne ke bad dekho kya map ka size greater than k hai to abhi aap valid nhi hue ho to chalte rhe
                if( map.size() > k ){
                    continue;
                    
                }else if( map.size() == k){ //yafir map ka size equal to k hai to valid answer hai aur break kyuki apne use valid bana diya hai
                  int len = i - j; //length hogi i-j
                  if( len > ans){ // agar yeh length answer ki length se lambi hai to answer ko update krle
                    ans = len;
                  }
                  break;
                }
            }
            
            if( f1 == false && f2 == false){ //agar dono flags false reh gye matlab na mai pehle loop mai ja rha aur nahi dusre loop mai ja rha to mai isko break kardunga
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
