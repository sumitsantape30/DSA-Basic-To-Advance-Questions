Count Of Substrings Having All Unique Characters

1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.
Input Format
A string
Output Format
A number representing the count of substrings having all unique characters.

  COMMENTConstraints
1 <= length of string <= 10^5
Sample Input
aabcbcdbca
Sample Output
24

Code:

import java.util.*;

public class Main {

	public static int solution(String str) {
        int ans = 0;
        
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while( true){
            
            //loop ko terminate karne keliye
            boolean f1 = false;
            boolean f2 = false;
            
            while( i < str.length() - 1){
                f1 = true; //iss loop mai ekbar bhi aye ho to iss flag1 ko true krdena
                
                //ab acquire karunga
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1); //map mai freqeuncy badhado
                
                //ab check karna hai valid hai ya invalid hai iss moment pe
                if( map.get(ch) == 2){ //frequency 2 hogyi hai to invalid ho chuke ho to break
                    break;
                }else{ //agar valid ho to answer mai add krlo i-j
                    ans += i - j; //j aur i ke bichka gap 2 hota hai to donoke bichme 2 strings hoti hai i pr khatam hone wali
                }
            }
            
            while( j < i){ //ab hum dubara release karenge jabtak dubara valid nhi hojate
                f2 = true; //iss loop ke andar ek bar bhi ghuse ho flag2 ko true kardena
                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) - 1); //map mai frequency ek se kam kardenge
                
                //agar ab tumhari frequency dubara 1 hogyi hai to tum valid ho to break karenge
                if( map.get(ch) == 1){ //valid hogye hai to uske nam ka answer collect karenge
                    ans += i - j;
                    break;
                }//otherwise tum valid hue hi nhi to kuch nhi karna
            }
            
            if( f1 == false && f2 == false){ //agar dono false hai means na pehle loop chala na dusra loop chala to break
                break;
            }
        }
        
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
