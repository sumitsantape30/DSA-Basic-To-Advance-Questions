Smallest Substring Of A String Containing All Unique Characters Of Itself

1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.
Input Format
A string
Output Format
A number representing smallest window length that contains all unique characters of the given string.
Question Video

Constraints
1 <= length of string <= 10^6
Sample Input
aabcbcdbca
Sample Output
4

Code:

import java.util.*;

public class Main {

	public static int solution(String str){
        int len = str.length() ; //hume actually length hi btani hai woh sequence nhi btana, pehle len str.length() pe rakh rhe ki puri string mai uske sare unique character to honge hi
        
        //ek hashset banayenge taki iss string ke sare unique characters pta lag ske
        HashSet<Character>  set = new HashSet<>();
        for( int i=0 ; i< str.length(); i++){
            char ch = str.charAt(i);
            set.add(ch);
        }//iss muje sare unique characters pta alg jayenge aur hashset ka size btayega kitne unique character hai
        
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>(); //iss map mai mai frequencies banaunga
        
        while(true){
            //iss loop se bahar kaise aaye? yeh badme dekhna pehle niche wala pert dekhlo
            boolean f1 = false;
            boolean f2 = false;
            
            //aquire till it is invalid, jabtak invalid hai tabtak acquire krte rhe, invalid ka matlab (map.size() < unique.size()) jabtak yeh chota hai acquire krte rahiye
            while( i < str.length() - 1 && map.size() < set.size()){ //map ka size set se chota hai matlab apne enough characters collect nhi kiye hai and i ko badhaye aur map mai collect kare
               i++;
               char ch = str.charAt(i);
               map.put(ch, map.getOrDefault(ch, 0) + 1);
               f1 = true; //iss loop mai jatehi flag1 ko true kardo
            }//isse acquire hoke ekdin map ka size set ke size ke barabr hojayega matlab woh valid hogya hai 
            //valid hogya hai to hume answer collect krna hai
            
            //agar map aur set ka size equal hai means apko ek valid string mil gyi hai ab j aage aage badhke release krte hue choti choti string jo hogi humara answer hoga
            while( j < i && map.size() == set.size()){ // j ka kam hai release karna to j i ke barabr nhi aa skta. j ka kam hai, jabtak map ka size same chal rha hai set ke size se tabtak release karega
            //hume length return karni hai
                int plen = i - j; //potential answer length
                if( plen < len){ // agar yeh potential length choti hai length se to updte length
                  len = plen;
                }
            
            //collect ans and release
            // j badhaye aur character release krde
            j++;
            char ch = str.charAt(j);
            //character release karne keliye apko dekhna hoga map mai uski frequency kya hai
            if( map.get(ch) == 1){ //agar uski frequency hai 1 to usko map se udado
               map.remove(ch);
            }else{
                //aur agar uski frequency 1 se jada hai to uski frequency ko bas negate krdo
                map.put(ch, map.get(ch) - 1); //aur frequency ek se kam krdo
            }
            f2 = true; //iss loop mai jatehi flag true krdo
        }
        
        if( f1 == false && f2 == false){ //agar dono flag false hai matlab aap dono loop mai nhi gye to aap break rk skte hai
          break;
        }
      }
        
		return len;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
