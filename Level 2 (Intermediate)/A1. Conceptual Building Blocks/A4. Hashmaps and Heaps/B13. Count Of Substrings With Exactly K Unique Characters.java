Count Of Substrings With Exactly K Unique Characters

1. You are given a string(str) and a number K.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has exactly K unique characters.
Input Format
A string
Output Format
A number representing count of substrings with exactly K unique characters.

Constraints
1 <= length of string <= 10^5
1 <= k <= 26
Sample Input
aabcbcdbca
2
Sample Output
12

Code:

import java.util.*;

public class Main {
    
    public static int solutionforK1(String str){
        //isme hashmap ek hi chahiye
        int ans = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        
        while( true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire wala kam chalega
            while( i < str.length() - 1){
                f1 = true;
                
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1); 
                
                if( map.size() == 2){ // k==1 hai so jaisehi size 2 hojayega
                  removeInMap(map, ch);
                  i--;
                  break;
                }
            }
            
            while( j < i){
                f2 = true;
                
                if( map.size() == 1){
                    ans += i - j;
                }
                
                j++;
                char ch = str.charAt(j);
                removeInMap(map, ch);
                
                if( map.size() == 0){
                    break;
                }
            }
            
            if( f1 == false && f2 == false){
                break;
            }
            
        }
        
        return ans;
    }

	public static int solution(String str, int k){
        int ans = 0;
        
        //agar k==1 hai to special case hai
        if( k == 1){
            return solutionforK1(str);
        }
        
        //mai do hashmap banaunga ek bada aur ek chota
        HashMap<Character, Integer> mapb = new HashMap<>(); //mapbig
        HashMap<Character, Integer> maps = new HashMap<>();
        
        //ab mai do acquiring points banaunga
        int is = -1; //acquire small
        int ib = -1; //acquire big
        int j = -1; //release krne keliye dono same hai j
        
        while( true){
            //ab hum 3 flags rakhenge loop ke bahar ane keliye help mile taki
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            
            //pehle bada acquire karega, usko apne andar k characters collect karne hai
            while( ib < str.length() - 1){
                f1 = true;
                
                //ib badhega, character pakdenge aur mapbig ke andar put kardenge
                ib++;
                char ch = str.charAt(ib);
                mapb.put(ch, mapb.getOrDefault(ch, 0) + 1); //aur frequency badha denge
                
                if( mapb.size() == k + 1){ //map ka size k tak allowed hai, k se bada hogy to dikkat hai, less than or equal to k hai to acquire krte rahiye but greater than k hogya to break hoga. aur akhri character aap release bhi karenge kyuki usko acquire krke apka size k se bada hogya hai to usko release kare.
                  removeInMap(mapb, ch);//mapbig se yeh character hata do
                  ib--; //jis character ko acquire krke apke map ka size k+1 hojata hai usko remove karne ke bad wapas aayenge
                  break;
                }//ab yahape mapbig mai k honge
            }
            
            //ab small wala kabtak badhega
            while(is < ib){ //yeh is kabhi ib ko cross nhi karega
              f2 = true;
              
              is++; //ismall humesha badhega
              char ch = str.charAt(is);
              maps.put(ch, maps.getOrDefault(ch, 0) + 1); //map small apni frequency badha rha hai
              
              //map small mai bhi break lagega jab uske size k hojaye
                if( maps.size() == k){ 
                  removeInMap(maps, ch);
                  is--; 
                  break;
                }//yaha mapsmall mai k-1 hai ab
            }
            
            //mapbig mai k hai aur mapsmall mai k-1 hai to donoke endpoint mai jitna gap hai utne substrings apko milenge
            while( j < is){ //yeh j woh hai jo remove krta hai yeh ismall se aage nhi ja skta
                f3 = true;
                
                //settle karenge
                if(mapb.size() == k && maps.size() == k-1){
                    ans += ib - is; 
                }
                
                j++;
                char ch = str.charAt(j);
                //ab yeh remove hume dono ismese krna hai, mapbig mese bhi aur mapsmall mesebhi
                removeInMap(maps, ch);
                removeInMap(mapb, ch);
                //j badhake dono ismese remove kardiya
                
                //agar remove krke invalid hojaye to break kardenge
                if( maps.size() < k - 1 || mapb.size() < k){ //agar mapsmall ka size less than k-1 hojaye aur mapbig ka size less than k hojaye to break
                    break;
                }
            }
            
            if( f1 == false && f2 == false && f3 == false){
                break;
            }
            
        }
        
		return ans;
	}
	
	public static void removeInMap( HashMap<Character, Integer> map, char ch){ //map pass karenge aur character
	    if( map.get(ch) == 1){ //agar character ki frequency 1 hai to map se uda deta hai
	       map.remove(ch);
	    }else{
	        //otherwise iski frequency 1 se kam krdete hai
	      map.put(ch, map.get(ch) - 1);
	    }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}

