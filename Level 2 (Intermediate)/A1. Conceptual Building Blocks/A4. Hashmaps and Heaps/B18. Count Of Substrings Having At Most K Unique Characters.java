Count Of Substrings Having At Most K Unique Characters

1. You are given a string(str) and a number K.
2. You have to find the count of substrings of the given string that contains at most K unique characters.
Input Format
A string
A number
Output Format
A number representing the count of substrings with at most K unique characters.

Constraints
1 <= length of string <= 10^5
1 <= K <= 26
  
Sample Input
aabcbcdbca
2
Sample Output
23

Code:

import java.util.*;

public class Main {

	public static int solution(String str, int k) {
        int ans = 0;
        
        int i = -1; //i acquire krne ka kam krta hai 
        int j = -1; //yeh release krne ka kam krta hai
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(true){
            
            //acquire
            while( i < str.length() - 1 ){
                // i ko badhaye character nikale aur acquire krle
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                //ab aap yaha check karenge kya map ka size less than equal to k hai
                if( map.size() <= k){ //kya less than equal to unique characters hai, agar hai to yeh answer mai add hoga
                  ans += i - j;
                }else{
                    //aur agar k se jada hogye to break karjaye kyuki invalid ho chuke ho
                    break;
                }
            }
            
            //*isko last mai dekhna: loop mai bahar aane keliye boolean f1,f2 se krte the
            if( i == str.length() - 1 && map.size() <= k){ //i agar end mai pohoch chuka hai aur map ka size less than or equal to k hai matlab apne apna kam krliya hai
                break;
            }
            
            //ab release karenge
            while( j < i){
                //j ko badhaye aur character le aur map mese release krde
                j++;
                char ch = str.charAt(j);
                //release krte waqt dhyan rakhe
                if( map.get(ch) == 1){ //agar frequency 1 hai to release krde
                    map.remove(ch);
                }else{
                    //map ke andar ek frequency ghatake dalde
                    map.put(ch, map.get(ch) - 1);
                }
                
                if( map.size() > k){ //agar map ka size abbhi grater than k hai to aur release krne honge apko to continue rakhe
                  continue;
                }else{ //aur agar woh less than equal to hogya to answer mai add kare i-j aur break karjaye
                  ans += i - j;
                  break;
                }
                
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
